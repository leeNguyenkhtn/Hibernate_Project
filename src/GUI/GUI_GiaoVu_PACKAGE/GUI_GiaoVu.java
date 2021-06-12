package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_GiaoVu;
import POJO.Thongtingiaovu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.List;
import java.util.Enumeration;

import CONST_CODE.Code;

public class GUI_GiaoVu extends JFrame {
    private JButton dangXuatButton;
    private JComboBox<String> chucNangCB;
    private JPanel giaoVuCardLayout;
    private JPanel hocKiPanel;
    private JPanel monHocPanel;
    private JPanel lopHocPanel;
    private JPanel cacKyDangKiHocPhanPanel;
    private JPanel kyDangKiHocPhanHienTaiPanel;
    private JPanel chucNangGVPanel;
    private JPanel giaoVuPanel;
    private JTable danhSachGVTable;
    private JTextField hoVaTenTF;
    private JTextField soDienThoaTF;
    private JTextField emailTF;
    private JRadioButton namRadioButton;
    private JRadioButton nuRadioButton;
    private JButton themButton;
    private JButton suaButton;
    private JButton xoaButton;
    private JButton timKiemButton;
    private JButton resetMKButton;
    private JTextField ngaySinhTF;
    private JTextField thangSinhTF;
    private JTextField namSinhTF;
    private JTextField matKhauTF;
    private JTextField tenDangNhapTF;
    private JButton taiLaiButton;
    final static String giaoVu = "Giao Vu";
    final static String monHoc = "Mon Hoc";
    final static String lopHoc = "Lop Hoc";
    final static String hocKi = "Hoc Ki";
    final static String kyDangKiHocPhanHienTai = "Ky Dang Ki Hoc Phan Hien Tai";
    final static String cacKyDangKiHocPhan = "Cac Ky Dang Ki Hoc Phan";
    final static int maxColumnOfGiaoVuTable = 6;
    final static int size = 14;
    final static int rowHeight = 25;
    DefaultTableModel model = new DefaultTableModel();
    public GUI_GiaoVu() {
        createComboBox();
        createTable();
        add(chucNangGVPanel);
        setSize(950, 650);
        setTitle("Giao vu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tao panel xuat hien dau tien cua card layout
        giaoVuCardLayout.add(giaoVuPanel, giaoVu);
        //
        chucNangCB.addItemListener(e -> {
            switch ((String)e.getItem())
            {
                case monHoc:
                    monHocPanel = new GUI_GiaoVu_MonHoc();
                    giaoVuCardLayout.add(monHocPanel, monHoc);
                    break;
                case lopHoc:
                    lopHocPanel = new GUI_GiaoVu_LopHoc();
                    giaoVuCardLayout.add(lopHocPanel, lopHoc);
                    break;
                case hocKi:
                    hocKiPanel = new GUI_GiaoVu_HocKi();
                    giaoVuCardLayout.add(hocKiPanel,hocKi);
                    break;
                case kyDangKiHocPhanHienTai:
                    kyDangKiHocPhanHienTaiPanel = new GUI_LopDangKiHocPhan();
                    giaoVuCardLayout.add(kyDangKiHocPhanHienTaiPanel,kyDangKiHocPhanHienTai);
                    break;
                case cacKyDangKiHocPhan:
                    cacKyDangKiHocPhanPanel = new GUI_KyDangKiHocPhan();
                    giaoVuCardLayout.add(cacKyDangKiHocPhanPanel,cacKyDangKiHocPhan);
                    break;
                default:
                    break;
            }
            CardLayout cl = (CardLayout) (giaoVuCardLayout.getLayout());
            cl.show(giaoVuCardLayout, (String) e.getItem());
        });
        namRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (nuRadioButton.isSelected()) {
                        nuRadioButton.setSelected(false);
                    }
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    if (!nuRadioButton.isSelected()) {
                        nuRadioButton.setSelected((true));
                    }
                }
            }
        });
        nuRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (nuRadioButton.isSelected()) {
                        namRadioButton.setSelected(false);
                    }
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    if (!namRadioButton.isSelected()) {
                        namRadioButton.setSelected((true));
                    }
                }
            }
        });
        taiLaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tenDangNhapTF.setText("");
                matKhauTF.setText("");
                hoVaTenTF.setText("");
                ngaySinhTF.setText("");
                thangSinhTF.setText("");
                namSinhTF.setText("");
                namRadioButton.setSelected(true);
                soDienThoaTF.setText("");
                emailTF.setText("");
                danhSachGVTable.clearSelection();
                updateTableRow();
            }
        });
    }

    //chinh lai font va size chu
    private static void setUIFont(javax.swing.plaf.FontUIResource f) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
        }
    }

    private void createComboBox() {
        String[] comboBoxItems = {giaoVu, monHoc, lopHoc, hocKi, kyDangKiHocPhanHienTai, cacKyDangKiHocPhan};
        for (String str : comboBoxItems) {
            chucNangCB.addItem(str);
        }
    }
    void setUpTable()
    {
        Object[] col = {"Ho va ten", "Ngay Sinh", "Gioi tinh", "So Dien Thoai", "Email"};

        model.setColumnIdentifiers(col);
        danhSachGVTable.setModel(model);
        danhSachGVTable.setRowHeight(rowHeight);
    }
    void updateTableRow()
    {
        int i = danhSachGVTable.getRowCount();
        for(i = i-1;i>=0;i--)
        {
            model.removeRow(i);
        }
        List<Thongtingiaovu> dsGiaoVu = BUS_GiaoVu.danhSachGiaoVu();
        for (Thongtingiaovu giaoVu : dsGiaoVu) {
            Object[] row = new Object[5];
            row[0] = giaoVu.getHoVaTen();
            row[1] = giaoVu.getNgaySinh();
            row[2] = giaoVu.getGioiTinh();
            row[3] = giaoVu.getSoDienThoai();
            row[4] = giaoVu.getEmail();
            model.addRow(row);
        }
    }
    private void createTable() {
        setUpTable();
        updateTableRow();
        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] row = new Object[5];
                row[0] = hoVaTenTF.getText();
                String ngaySinh = namSinhTF.getText() + "-" + thangSinhTF.getText() + "-" + ngaySinhTF.getText();
                row[1] = ngaySinh;

                if (namRadioButton.isSelected()) {
                    row[2] = "Nam";
                } else {
                    row[2] = "Nu";
                }
                row[3] = soDienThoaTF.getText();
                row[4] = emailTF.getText();
                String result = BUS_GiaoVu.themGiaoVu(tenDangNhapTF.getText(), matKhauTF.getText(), hoVaTenTF.getText(), Date.valueOf(ngaySinh),
                        row[2].toString(), soDienThoaTF.getText(), emailTF.getText());
                switch (result) {
                    case "NotNull":
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Ten dang nhap va mat khau khong duoc bo trong", "", JOptionPane.WARNING_MESSAGE);
                        break;
                    case "NoSpace":
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Ten dang nhap va mat khau khong duoc chua khoang trang", "", JOptionPane.WARNING_MESSAGE);
                        break;
                    case "Failed":
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Them giao vu that bai", "", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        updateTableRow();
                        break;
                }
            }
        });
        //Xoa Giao vu
        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = danhSachGVTable.getSelectedRow();
                if (i >= 0) {
                    if (BUS_GiaoVu.xoaGiaoVu(i)) {
                        updateTableRow();
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Xoa giao vu that bai", "", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Xoa giao vu that bai", "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(chucNangGVPanel, "Chon giao vu can xoa", "", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //Sua giao vu
        suaButton.addActionListener(e -> {
            String hoVaTen = hoVaTenTF.getText();
            String ngaySinh = namSinhTF.getText() + "-" + thangSinhTF.getText() + "-" + ngaySinhTF.getText();
            String gioiTinh;
            if (namRadioButton.isSelected()) {
                gioiTinh = "Nam";
            } else {
                gioiTinh = "Nu";
            }
            String soDienThoai = soDienThoaTF.getText();
            String email = emailTF.getText();
            int i = danhSachGVTable.getSelectedRow();
            if (i >= 0) {
                if (BUS_GiaoVu.capNhatGiaoVu(i, hoVaTen, ngaySinh, gioiTinh, soDienThoai, email)) {
                    updateTableRow();
                } else {
                    JOptionPane.showMessageDialog(chucNangGVPanel, "Cap nhat thong tin giao vu that bai", "", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(chucNangGVPanel, "Chon giao vu can cap nhat", "", JOptionPane.WARNING_MESSAGE);
            }

        });
        //Chon 1 dong trong bang
        danhSachGVTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = danhSachGVTable.getSelectedRow();
                hoVaTenTF.setText(model.getValueAt(i, 0).toString());
                String namThangNgaySinh = model.getValueAt(i, 1).toString();
                String[] arrSplit = namThangNgaySinh.split("-");
                namSinhTF.setText(arrSplit[0]);
                thangSinhTF.setText(arrSplit[1]);
                ngaySinhTF.setText(arrSplit[2]);
                if (model.getValueAt(i, 2).toString().equals("Nam")) {
                    namRadioButton.setSelected(true);
                } else {
                    nuRadioButton.setSelected(true);
                }
                soDienThoaTF.setText(model.getValueAt(i, 3).toString());
                emailTF.setText(model.getValueAt(i, 4).toString());
            }
        });
        //Tim kiem theo ten dang nhap
        timKiemButton.addActionListener(e -> {
            String tenDangNhap = JOptionPane.showInputDialog(chucNangGVPanel, "Nhap ten dang nhap: ",
                    "Tim kiem giao vu", JOptionPane.INFORMATION_MESSAGE);
            if(tenDangNhap!=null) {
                int index = BUS_GiaoVu.timGiaoVuBangTenDangNhap(tenDangNhap);
                if (index>=0) {
                    danhSachGVTable.setRowSelectionInterval(index, index);
                }
                else {
                    JOptionPane.showMessageDialog(chucNangGVPanel, "Giao Vu khong ton tai", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //ResetMK
        resetMKButton.addActionListener(e -> {
            String tenDangNhap = JOptionPane.showInputDialog(chucNangGVPanel, "Nhap ten dang nhap: ",
                    "Reset mat khau", JOptionPane.INFORMATION_MESSAGE);
            int state = BUS_GiaoVu.resetMatKhau(tenDangNhap);
            if (state == Code.TEN_DANG_NHAP_KHONG_TON_TAI) {
                JOptionPane.showMessageDialog(chucNangGVPanel, "Ten dang nhap khong ton tai", "", JOptionPane.WARNING_MESSAGE);
            } else if (state == Code.MAT_KHAU_KHONG_DUNG) {
                JOptionPane.showMessageDialog(chucNangGVPanel, "Reset mat khau that bai", "", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(chucNangGVPanel, "Mat khau moi la: " + tenDangNhap);
        });
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        setUIFont(new javax.swing.plaf.FontUIResource("Arial", Font.PLAIN, size));
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        GUI_GiaoVu giaovu = new GUI_GiaoVu();
        SwingUtilities.invokeLater(() -> giaovu.setVisible(true));
    }
}
