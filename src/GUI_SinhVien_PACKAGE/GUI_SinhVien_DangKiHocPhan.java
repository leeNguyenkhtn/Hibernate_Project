package GUI_SinhVien_PACKAGE;

import BUS.BUS_LopDangKiHocPhan;
import BUS.BUS_SinhVien;
import CONST_CODE.Code;
import POJO.Lopdangkihocphan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUI_SinhVien_DangKiHocPhan extends JPanel{
    private JTable dangKiHocPhanTable;
    private JPanel hocPhanPanel;
    private JButton dangKiButton;
    private JPanel dangKiPanel;
    DefaultTableModel model = new DefaultTableModel();
    final int rowHeight = 25;
    BUS_SinhVien bus_sinhVien;
    public GUI_SinhVien_DangKiHocPhan(BUS_SinhVien bus_SinhVien)
    {
        taoBang();
        updateTableRow();
        this.bus_sinhVien = bus_SinhVien;
        add(dangKiPanel);
        dangKiButton.addActionListener(e -> {
            int index = dangKiHocPhanTable.getSelectedRow();
            if(bus_SinhVien.dangKiHocPhan(index)== Code.THANH_CONG)
            {
                JOptionPane.showMessageDialog(this,
                        "Dang ki hoc phan thanh cong","Thong bao",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this,
                        "Dang ki hoc phan that bai","Thong bao",JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    void taoBang()
    {
        Object[] col = {"Ma MH","Ten mon hoc","Lop hoc","So TC","GVLT",
                "Phong hoc","Buoi hoc","Ca hoc","Si so","Da dang ky"};
        int[] colWidth = {70,150,70,60,150,90,80,90,45,95};
        model.setColumnIdentifiers(col);
        dangKiHocPhanTable.setModel(model);
        dangKiHocPhanTable.setRowHeight(rowHeight);
        int i = 0;
        for (int width : colWidth) {
            TableColumn column = dangKiHocPhanTable.getColumnModel().getColumn(i++);
            column.setPreferredWidth(width);
        }
    }
    void updateTableRow() {
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
        if(BUS_LopDangKiHocPhan.danhSachHocPhan!=null)
        {
            for (Lopdangkihocphan lopdangkihocphan :BUS_LopDangKiHocPhan.danhSachHocPhan) {
                Object[] row = new Object[10];
                row[0] = lopdangkihocphan.getMonHoc().getMaMonHoc();
                row[1] = lopdangkihocphan.getMonHoc().getTenMonHoc();
                row[2] = lopdangkihocphan.getLopHoc().getTenLopHoc();
                row[3] = lopdangkihocphan.getMonHoc().getSoTinChi();
                row[4] = lopdangkihocphan.getGiaoVienLiThuyet();
                row[5] = lopdangkihocphan.getTenPhongHoc();
                row[6] = lopdangkihocphan.getBuoiHoc();
                row[7] = lopdangkihocphan.getCaHoc();
                row[8] = lopdangkihocphan.getSiSo();
                row[9] = lopdangkihocphan.getSoLuongDaDangKy();
                model.addRow(row);
            }
        }
    }

}
