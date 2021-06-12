package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_KyDangKiHocPhan;
import CONST_CODE.Code;
import POJO.Kydangkihocphan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_KyDangKiHocPhan extends JPanel {
    private JTable kyDangKiHocPhanTable;
    private JButton themButton;
    private JButton taiLaiButton;
    private JPanel kyDangKiHocPhanPanel;
    private JTextField ngayBatDauTF;
    private JTextField thangBatDauTF;
    private JTextField namBatDauTF;
    private JTextField ngayKetThucTF;
    private JTextField thangKetThucTF;
    private JTextField namKetThucTF;
    DefaultTableModel model = new DefaultTableModel();
    final int rowHeight = 25;
    public GUI_KyDangKiHocPhan()
    {
        add(kyDangKiHocPhanPanel);
        setSize(650, 450);
        setUp();
        updateTableRow();
        taiLaiButton.addActionListener(e -> {
            setEmpty();
            updateTableRow();
        });
        themButton.addActionListener(e -> {
            int state =BUS_KyDangKiHocPhan.themKyDangKiHocPhan(ngayBatDauTF.getText(),thangBatDauTF.getText(),namBatDauTF.getText(),
                    ngayKetThucTF.getText(),thangKetThucTF.getText(),namKetThucTF.getText());
            if(state == Code.THANH_CONG)
            {
                updateTableRow();
                setEmpty();
                JOptionPane.showMessageDialog(this,"Mo ki dang ki hoc phan thanh cong","",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(state ==Code.NGAY_KHONG_HOP_LE)
            {
                JOptionPane.showMessageDialog(this,"Ngay khong hop le",
                                            "",JOptionPane.WARNING_MESSAGE);
            }
            else if (state==Code.BI_TRUNG)
            {
                JOptionPane.showMessageDialog(this,"Dang co mot ky dang ki hoc phan dien ra luc nay",
                                                "",JOptionPane.WARNING_MESSAGE);
            }
            else if(state ==Code.CHUA_CO_HOC_KI_HIEN_TAI)
            {
                JOptionPane.showMessageDialog(this,"Chua co hoc ki hien tai",
                        "",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Mo ki dang ki hoc phan that bai",
                        "",JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    void setUp()
    {
        Object[] col = {"Nam hoc", "Hoc ki", "Ngay bat dau","Ngay ket thuc","Trang thai"};
        model.setColumnIdentifiers(col);
        kyDangKiHocPhanTable.setModel(model);
        kyDangKiHocPhanTable.setRowHeight(rowHeight);
    }
    void updateTableRow()
    {
        int i = model.getRowCount();
        for (i = i - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
        i = 0;
        String idKyDangKyHocPhanHienTai = null;
        if(BUS_KyDangKiHocPhan.kyDangKyHocPhanHienTai!=null)
        {
            idKyDangKyHocPhanHienTai = BUS_KyDangKiHocPhan.kyDangKyHocPhanHienTai.getIdKyDangKiHocPhan();
        }
        for (Kydangkihocphan kydangkihocphan: BUS_KyDangKiHocPhan.danhSachKyDangKiHocPhan()) {
                Object[] row = new Object[5];
                if(kydangkihocphan.getIdKyDangKiHocPhan().equals(idKyDangKyHocPhanHienTai))
                {
                    row[4] = "Dang dien ra" ;
                }
                else {
                    row[4] = "";
                }
                row[0] = kydangkihocphan.getHocKi().getNamHoc();
                row[1] = kydangkihocphan.getHocKi().getTenHocKi();
                row[2] = kydangkihocphan.getNgayBatDau();
                row[3] = kydangkihocphan.getNgayKetThuc();
                model.addRow(row);
            }

    }
    void setEmpty()
    {
        kyDangKiHocPhanTable.clearSelection();
        ngayBatDauTF.setText("");
        thangBatDauTF.setText("");
        namBatDauTF.setText("");
        ngayKetThucTF.setText("");
        thangKetThucTF.setText("");
        namKetThucTF.setText("");
    }
}
