package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_HocKi;
import BUS.BUS_LopHoc;
import CONST_CODE.Code;
import POJO.Hocki;
import POJO.Lophoc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class GUI_GiaoVu_HocKi extends JPanel {
    private JButton xoaButton;
    private JButton setHKButton;
    private JButton themButton;
    private JTextField namHocTF;
    private JTextField ngayBatDauTF;
    private JComboBox<String> tenHocKiCB;
    private JTextField thangBatDauTF;
    private JTextField namBatDauTF;
    private JTextField ngayKetThucTF;
    private JTextField thangKetThucTF;
    private JTextField namKetThucTF;
    private JTable hocKiTable;
    private JPanel hocKiPanel;
    private JButton taiLaiButton;
    DefaultTableModel model = new DefaultTableModel();
    final int rowHeight = 25;
    final String hocKi_1 = "HK1";
    final String hocKi_2 = "HK2";
    final String hocKi_3 = "HK3";
    final int DANG_DIEN_RA = 1;
    void setTenHocKiCB()
    {
        tenHocKiCB.addItem(hocKi_1);
        tenHocKiCB.addItem(hocKi_2);
        tenHocKiCB.addItem(hocKi_3);
    }
    public GUI_GiaoVu_HocKi()
    {
        setTenHocKiCB();
        //tao bang
        createTable();
        //cap nhat du lieu cho bang
        updateTable();
        //
        add(hocKiPanel);
        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenHocKi = Objects.requireNonNull(tenHocKiCB.getSelectedItem()).toString();
                String namHoc = namHocTF.getText();
                String ngayBatDau = ngayBatDauTF.getText();
                String thangBatDau = thangBatDauTF.getText();
                String namBatDau = namBatDauTF.getText();
                String ngayKetThuc = ngayKetThucTF.getText();
                String thangKetThuc = thangKetThucTF.getText();
                String namKetThuc = namKetThucTF.getText();
                int state = BUS_HocKi.themHocKi(tenHocKi,namHoc,ngayBatDau,
                        thangBatDau,namBatDau,ngayKetThuc,thangKetThuc,namKetThuc);
                if(state== Code.THANH_CONG)
                {
                    updateTable();
                    setEmpty();
                    JOptionPane.showMessageDialog(hocKiPanel, "Them hoc ki thanh cong ","",JOptionPane.INFORMATION_MESSAGE);
                }
                else if (state==Code.TRUOC_NGAY_HIEN_TAI)
                {
                    JOptionPane.showMessageDialog(hocKiPanel, "Ngay ket thuc dien ra truoc ngay hien tai","",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(hocKiPanel, "Them hoc ki that bai ","",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = hocKiTable.getSelectedRow();
                if(i>=0)
                {
                    if(BUS_HocKi.xoaHocKi(i)==Code.THANH_CONG)
                    {
                        JOptionPane.showMessageDialog(hocKiPanel, "Xoa hoc ki thanh cong ","",JOptionPane.INFORMATION_MESSAGE);
                        updateTable();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(hocKiPanel, "Xoa hoc ki that bai ","",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(hocKiPanel, "Vui long chon hoc ki can xoa ","",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        setHKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = hocKiTable.getSelectedRow();
                if(i>=0)
                {
                    int state = BUS_HocKi.setHocKiHienTai(i);
                    if(state==Code.THANH_CONG)
                    {
                        JOptionPane.showMessageDialog(hocKiPanel, "Chon hoc ki hien tai thanh cong ","",JOptionPane.INFORMATION_MESSAGE);
                        updateTable();
                    }
                    else if (state==Code.TRUOC_NGAY_HIEN_TAI)
                    {
                        JOptionPane.showMessageDialog(hocKiPanel, "Ngay ket thuc dien ra truoc ngay hien tai","",JOptionPane.WARNING_MESSAGE);
                    }
                    else if (state==Code.SAU_NGAY_HIEN_TAI)
                    {
                        JOptionPane.showMessageDialog(hocKiPanel, "Ngay bat dau dien ra sau ngay hien tai","",JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(hocKiPanel, "Chon hoc ki hien tai that bai ","",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(hocKiPanel, "Vui long chon hoc ki can thao tac ","",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    void createTable()
    {
        Object[] col = {"Ten hoc ki","Nam hoc","Ngay bat dau","Ngay ket thuc","Trang thai"};
        model.setColumnIdentifiers(col);
        hocKiTable.setModel(model);
        hocKiTable.setRowHeight(rowHeight);
    }
    void setEmpty()
    {
        namHocTF.setText("");
        ngayBatDauTF.setText("");
        thangBatDauTF.setText("");
        namBatDauTF.setText("");
        ngayKetThucTF.setText("");
        thangKetThucTF.setText("");
        namKetThucTF.setText("");
        hocKiTable.clearSelection();
    }
    void updateTable()
    {
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
        for (Hocki hocki: BUS_HocKi.danhSachHocKi) {
            Object[] row = new Object[5];
            row[0] = hocki.getTenHocKi();
            row[1] = hocki.getNamHoc();
            row[2] = hocki.getNgayBatDau();
            row[3] = hocki.getNgayKetThuc();
            if(hocki.getTrangThai()==DANG_DIEN_RA)
            {
                row[4] = "Dang dien ra";
            }
            else
            {
                row[4] = "";
            }
            model.addRow(row);
        }
    }
}
