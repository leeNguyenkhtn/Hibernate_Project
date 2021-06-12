package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_MonHoc;
import CONST_CODE.Code;
import POJO.Monhoc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_GiaoVu_MonHoc extends JPanel {
    private JPanel monHocPanel;
    private JTable monHocTable;
    private JTextField maMonHocTF;
    private JTextField tenMonHocTF;
    private JSpinner soTinChiSpinner;
    private JButton themButton;
    private JButton xoaButton;
    private JButton suaButton;
    private JButton taiLaiButton;
    DefaultTableModel model = new DefaultTableModel();
    final int rowHeight = 25;
    public GUI_GiaoVu_MonHoc() {
        add(monHocPanel);
        setSize(550, 450);
        //set up table
        Object[] col = {"Ma mon hoc", "Ten mon hoc", "So tin chi"};
        model.setColumnIdentifiers(col);
        monHocTable.setModel(model);
        monHocTable.setRowHeight(rowHeight);
        int[] colWidth = {90,250,70};
        int i = 0;
        for(int width:colWidth)
        {
            TableColumn column = monHocTable.getColumnModel().getColumn(i++);
            column.setPreferredWidth(width);
        }
        //update table
        updateTableRow();
        //su kien click vao mot row
        monHocTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = monHocTable.getSelectedRow();
                maMonHocTF.setText(model.getValueAt(i,0).toString());
                tenMonHocTF.setText(model.getValueAt(i,1).toString());
                soTinChiSpinner.setValue(model.getValueAt(i,2));
            }
        });
        //them
        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maMonHoc = maMonHocTF.getText();
                String tenMonHoc = tenMonHocTF.getText();
                int soTinChi = (int) soTinChiSpinner.getValue();
                int state = BUS_MonHoc.themMonHoc(maMonHoc, tenMonHoc, soTinChi);
                if (state == Code.KHONG_DUOC_BO_TRONG) {
                    JOptionPane.showMessageDialog(monHocPanel, "Khong duoc bo trong", "", JOptionPane.WARNING_MESSAGE);
                } else if (state == Code.SO_TIN_CHI_PHAI_LON_HON_1) {
                    JOptionPane.showMessageDialog(monHocPanel, "So tin chi phai lon hon 1", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(monHocPanel, "Them thanh cong", "", JOptionPane.INFORMATION_MESSAGE);
                    updateTableRow();
                    setEmpty();
                }

            }
        });
        //xoa
        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = monHocTable.getSelectedRow();
                int state = BUS_MonHoc.xoaMonHoc(index);
                if(state == Code.THANH_CONG)
                {
                    JOptionPane.showMessageDialog(monHocPanel, "Xoa thanh cong", "", JOptionPane.INFORMATION_MESSAGE);
                    updateTableRow();
                    setEmpty();
                }
                else if(state == Code.CHON_HANG)
                {
                    JOptionPane.showMessageDialog(monHocPanel, "Vui long chon mon hoc can xoa", "", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(monHocPanel, "Xoa that bai", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //cap nhat
        suaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = monHocTable.getSelectedRow();
                String maMonHoc = maMonHocTF.getText();
                String tenMonHoc = tenMonHocTF.getText();
                int soTinChi = (int) soTinChiSpinner.getValue();
                int state = BUS_MonHoc.suaMonHoc(i,maMonHoc,tenMonHoc,soTinChi);
                if(state == Code.THANH_CONG)
                {
                    JOptionPane.showMessageDialog(monHocPanel, "Cap nhat thanh cong", "", JOptionPane.INFORMATION_MESSAGE);
                    updateTableRow();
                    setEmpty();
                }
                else if(state == Code.CHON_HANG)
                {
                    JOptionPane.showMessageDialog(monHocPanel, "Vui long chon mon hoc can cap nhat", "", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(monHocPanel, "Cap nhat that bai", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //them dong moi
        taiLaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEmpty();
            }
        });
    }
    private void setEmpty()
    {
        maMonHocTF.setText("");
        tenMonHocTF.setText("");
        soTinChiSpinner.setValue(0);
        monHocTable.clearSelection();
    }
    private void updateTableRow() {
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
            for (Monhoc monhoc : BUS_MonHoc.dsMonHoc) {
                Object[] row = new Object[3];
                row[0] = monhoc.getMaMonHoc();
                row[1] = monhoc.getTenMonHoc();
                row[2] = monhoc.getSoTinChi();
                model.addRow(row);
            }
    }
}
