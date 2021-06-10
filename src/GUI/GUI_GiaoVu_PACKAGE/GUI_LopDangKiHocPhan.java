package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_LopHoc;
import POJO.Lophoc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_LopDangKiHocPhan extends JPanel{
    private JButton themButton;
    private JButton xoaButton;
    private JButton timKiemButton;
    private JTable lopDangKiHocPhanTable;
    private JButton xemDsSVButton;
    private JPanel lopDangKiHocPhanPanel;
    DefaultTableModel model = new DefaultTableModel();
    final int rowHeight = 25;
    public GUI_LopDangKiHocPhan()
    {
        taoBang();
        add(lopDangKiHocPhanPanel);
    }
    void taoBang()
    {
        Object[] col = {"Ma MH","Ten mon hoc","So tin chi","GVLT",
                        "Phong hoc","Ngay trong tuan","Ca hoc","Si so","Da dang ky"};
        model.setColumnIdentifiers(col);
        lopDangKiHocPhanTable.setModel(model);
        lopDangKiHocPhanTable.setRowHeight(rowHeight);
    }
    void setEmpty()
    {
        lopDangKiHocPhanTable.clearSelection();
    }
    /*private void updateTableRow() {
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
        for (Lopdangkihocphan lopdangkihocphan: BUS_LopHoc.danhSachLopHoc) {
            Object[] row = new Object[9];
            row[0] = lopdangkihocphan.getTenLopHoc();
            row[1] = lopdangkihocphan.getTongSoSv();
            row[2] = lopdangkihocphan.getTongSoNam();
            row[3] = lopdangkihocphan.getTongSoNu();
            model.addRow(row);
        }
    }*/
}
