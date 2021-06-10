package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_LopHoc;
import CONST_CODE.Code;
import POJO.Lophoc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_GiaoVu_LopHoc extends JPanel{
    private JButton themDongMoiButton;
    private JTextField tenLopHocTF;
    private JButton themButton;
    private JButton xoaButton;
    private JTable lopHocTable;
    private JPanel lopHocPanel;
    private JScrollPane dsLopHocScroll;
    DefaultTableModel model = new DefaultTableModel();
    final int rowHeight = 25;
    public GUI_GiaoVu_LopHoc()
    {
        add(lopHocPanel);
        //tao bang
        taoBang();
        //cap nhat du lieu
        updateTableRow();
        themButton.addActionListener(e -> {
            if(BUS_LopHoc.themLopHoc(tenLopHocTF.getText())== Code.THANH_CONG)
            {
                JOptionPane.showMessageDialog(lopHocPanel, "Them lop hoc thanh cong", "", JOptionPane.INFORMATION_MESSAGE);
                updateTableRow();
                setEmpty();
            }
            else
            {
                JOptionPane.showMessageDialog(lopHocPanel, "Them lop hoc that bai", "", JOptionPane.ERROR_MESSAGE);
            }
        });
        xoaButton.addActionListener(e -> {
            int i = lopHocTable.getSelectedRow();
            if(BUS_LopHoc.xoaLopHoc(i)== Code.THANH_CONG)
            {
                JOptionPane.showMessageDialog(lopHocPanel, "Them lop hoc thanh cong", "", JOptionPane.INFORMATION_MESSAGE);
                updateTableRow();
                setEmpty();
            }
            else
            {
                JOptionPane.showMessageDialog(lopHocPanel, "Them lop hoc that bai", "", JOptionPane.ERROR_MESSAGE);
            }
        });
        lopHocTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = lopHocTable.getSelectedRow();
                String idLopHoc = BUS_LopHoc.danhSachLopHoc.get(i).getIdLopHoc();
                GUI_GiaoVu_LopHoc_Dialog_SinhVien dialog_sinhVien = new GUI_GiaoVu_LopHoc_Dialog_SinhVien(idLopHoc);

            }
        });
        themDongMoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEmpty();
            }
        });
    }
    //set up table
    void taoBang()
    {
        Object[] col = {"Ten lop hoc","Tong so SV","Tong so nam","Tong so nu"};
        model.setColumnIdentifiers(col);
        lopHocTable.setModel(model);
        lopHocTable.setRowHeight(rowHeight);
    }
    //dua ve trang thai ban dau
    void setEmpty()
    {
        tenLopHocTF.setText("");
        lopHocTable.clearSelection();
    }
    private void updateTableRow() {
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
        for (Lophoc lophoc: BUS_LopHoc.danhSachLopHoc) {
            Object[] row = new Object[4];
            row[0] = lophoc.getTenLopHoc();
            row[1] = lophoc.getTongSoSv();
            row[2] = lophoc.getTongSoNam();
            row[3] = lophoc.getTongSoNu();
            model.addRow(row);
        }
    }
}
