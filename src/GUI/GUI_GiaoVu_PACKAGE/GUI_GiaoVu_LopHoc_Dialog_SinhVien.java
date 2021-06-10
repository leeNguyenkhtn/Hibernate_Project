package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_LopHoc;
import CONST_CODE.Code;
import POJO.Sinhvien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class GUI_GiaoVu_LopHoc_Dialog_SinhVien extends JDialog {
    private JPanel contentPane;
    private JButton themButton;
    private JTable sinhVienTable;
    DefaultTableModel model = new DefaultTableModel();
    final int rowHeight = 25;
    String idLopHoc;

    public GUI_GiaoVu_LopHoc_Dialog_SinhVien(String idLopHoc) {
        this.idLopHoc = idLopHoc;
        setContentPane(contentPane);
        setModal(true);
        setSize(800,450);
        getRootPane().setDefaultButton(themButton);
        taoBang();
        updateTableRow();
        themButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onThem();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        setVisible(true);
    }

    private void onThem() {
       String mssv = JOptionPane.showInputDialog(this,"Nhap MSSV","Them sinh vien",
                JOptionPane.INFORMATION_MESSAGE);
       int state = BUS_LopHoc.themSinhVienVaoLopHoc(mssv,idLopHoc);
       if(state== Code.THANH_CONG)
       {
           JOptionPane.showMessageDialog(this,"Them sinh vien thanh cong",
                                        "",JOptionPane.INFORMATION_MESSAGE);
           updateTableRow();
       }
       else if(state == Code.KHONG_DUOC_BO_TRONG)
       {
           JOptionPane.showMessageDialog(this,"Khong duoc bo trong",
                   "",JOptionPane.WARNING_MESSAGE);
       }
       else if(state==Code.BI_TRUNG)
       {
           JOptionPane.showMessageDialog(this,"Sinh vien da thuoc lop hoc khac",
                   "",JOptionPane.WARNING_MESSAGE);
       }
       else if(state == Code.DOI_TUONG_KHONG_TON_TAI)
       {
           JOptionPane.showMessageDialog(this,"Sinh vien khong ton tai",
                   "",JOptionPane.WARNING_MESSAGE);
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Them sinh vien that bai",
                   "",JOptionPane.ERROR_MESSAGE);
       }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    void taoBang()
    {
        Object[] col = {"MSSV","Ho va ten","Ngay sinh","Gioi tinh","Dia chi","So dien thoai"};
        model.setColumnIdentifiers(col);
        sinhVienTable.setModel(model);
        sinhVienTable.setRowHeight(rowHeight);

    }
    void updateTableRow() {
        List<Sinhvien> dsSinhVien = BUS_LopHoc.danhSachSinhVien(idLopHoc);
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
        for (Sinhvien sinhvien:dsSinhVien) {
            Object[] row = new Object[6];
            row[0] = sinhvien.getMssv();
            row[1] = sinhvien.getHoVaTen();
            row[2] = sinhvien.getNgaySinh().toString();
            row[3] = sinhvien.getGioiTinh();
            row[4] = sinhvien.getDiaChi();
            row[5] = sinhvien.getSoDienThoai();
            model.addRow(row);
        }
    }
}
