package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_LopDangKiHocPhan;
import POJO.Sinhviendangkihocphan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GUI_GiaoVu_LopDangKiHocPhan_Dialog_SinhVien extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTable table1;
    final int rowHeight = 25;
    DefaultTableModel model = new DefaultTableModel();
    String idHocPhan;
    public GUI_GiaoVu_LopDangKiHocPhan_Dialog_SinhVien(String idHocPhan) {
        this.idHocPhan = idHocPhan;
        setContentPane(contentPane);
        setModal(true);
        setSize(800,450);
        getRootPane().setDefaultButton(buttonOK);
        //
            setUp();
            updateTableRow();
        //
        setVisible(true);
    }
    void setUp()
    {
        Object[] col = {"MSSV","Ho va ten","Thoi gian dang ki"};
        model.setColumnIdentifiers(col);
        table1.setModel(model);
        table1.setRowHeight(rowHeight);
    }
    void updateTableRow()
    {
        List<Sinhviendangkihocphan> danhSachSinhVienTrongHocPhan = BUS_LopDangKiHocPhan.danhSachSinhVienDangKi(idHocPhan);
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
        for(Sinhviendangkihocphan sinhVien:danhSachSinhVienTrongHocPhan)
        {
            Object[] row = new Object[3];
            row[0] = sinhVien.getSinhVien().getMssv();
            row[1] = sinhVien.getSinhVien().getHoVaTen();
            row[2] = sinhVien.getThoiGianDangKi();
            model.addRow(row);
        }
    }
}
