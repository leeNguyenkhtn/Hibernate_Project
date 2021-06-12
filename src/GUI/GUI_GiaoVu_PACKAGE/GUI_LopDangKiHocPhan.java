package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_KyDangKiHocPhan;
import BUS.BUS_LopDangKiHocPhan;
import CONST_CODE.Code;
import POJO.Lopdangkihocphan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_LopDangKiHocPhan extends JPanel{
    private JButton themButton;
    private JButton xoaButton;
    private JButton timKiemButton;
    private JTable lopDangKiHocPhanTable;
    private JButton xemDsSVButton;
    private JPanel lopDangKiHocPhanPanel;
    private JPanel BorderPanel;
    private JButton taiLaiButton;
    DefaultTableModel model = new DefaultTableModel();
    final int rowHeight = 25;
    public GUI_LopDangKiHocPhan()
    {
        taoBang();
        setEmpty();
        updateTableRow();
        add(lopDangKiHocPhanPanel);
        themButton.addActionListener(e -> {
            if(BUS_KyDangKiHocPhan.getKyDangKiHocPhanHienTai()!=null)
            {
                GUI_GiaoVu_LopDangKiHocPhan_Dialog_HocPhan dialog_hocPhan = new GUI_GiaoVu_LopDangKiHocPhan_Dialog_HocPhan();
                updateTableRow();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Ky dang ki hoc phan chua dien ra","",JOptionPane.WARNING_MESSAGE);
            }

        });
        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = lopDangKiHocPhanTable.getSelectedRow();
                int state = BUS_LopDangKiHocPhan.xoaHocPhan(i);
                if(state==Code.THANH_CONG)
                {
                    updateTableRow();
                    JOptionPane.showMessageDialog(lopDangKiHocPhanPanel,"Xoa hoc phan thanh cong","",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(state==Code.THAT_BAI)
                {
                    JOptionPane.showMessageDialog(lopDangKiHocPhanPanel,"Xoa hoc phan that bai","",JOptionPane.ERROR_MESSAGE);
                }
                else if(state==Code.CHI_SO_KHONG_HOP_LE)
                {
                    JOptionPane.showMessageDialog(lopDangKiHocPhanPanel,"Chon dong can xoa","",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        taiLaiButton.addActionListener(e -> {
            BUS_LopDangKiHocPhan.capNhatDanhSachHocPhan();
            updateTableRow();
        });
        xemDsSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = lopDangKiHocPhanTable.getSelectedRow();
                if(i>-1)
                {
                    String idHocPhan = BUS_LopDangKiHocPhan.danhSachHocPhan.get(i).getIdLopDangKiHocPhan();
                    GUI_GiaoVu_LopDangKiHocPhan_Dialog_SinhVien dialog_sinhVien
                            = new GUI_GiaoVu_LopDangKiHocPhan_Dialog_SinhVien(idHocPhan);
                }
            }
        });
    }
    void taoBang()
    {
        Object[] col = {"Ma MH","Ten mon hoc","Lop hoc","So TC","GVLT",
                        "Phong hoc","Buoi hoc","Ca hoc","Si so","Da dang ky"};
        int[] colWidth = {70,150,70,60,150,90,80,90,45,95};
        model.setColumnIdentifiers(col);
        lopDangKiHocPhanTable.setModel(model);
        lopDangKiHocPhanTable.setRowHeight(rowHeight);
        int i = 0;
        for (int width : colWidth) {
            TableColumn column = lopDangKiHocPhanTable.getColumnModel().getColumn(i++);
            column.setPreferredWidth(width);
        }
    }
    void setEmpty()
    {
        lopDangKiHocPhanTable.clearSelection();
    }
    void updateTableRow() {
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
        if(BUS_LopDangKiHocPhan.danhSachHocPhan!=null)
        {
            for (Lopdangkihocphan lopdangkihocphan: BUS_LopDangKiHocPhan.danhSachHocPhan) {
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
