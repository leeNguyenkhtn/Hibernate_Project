package GUI;

import BUS.BUS_GiaoVu;
import POJO.Thongtingiaovu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;

public class GUI_GiaoVu extends JFrame{
    private JButton dangXuatButton;
    private JComboBox<String> chucNangCB;
    private JPanel giaoVuCardLayout;
    private JPanel sinhVienPanel;
    private JPanel hocKiPanel;
    private JPanel monHocPanel;
    private JPanel lopHocPanel;
    private JPanel dangKiHocPhanPanel;
    private JPanel hocPhanHienTaiPanel;
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
    private JButton themMoiButton;
    final static String giaoVu = "Giao Vu";
    final static String sinhVien = "Sinh Vien";
    final static String monHoc = "Mon Hoc";
    final static String lopHoc = "Lop Hoc";
    final static String hocKi = "Hoc Ki";
    final static String hocPhanHienTai = "Hoc Ki Hien Tai";
    final static String dangKyHocPhan = "Dang Ky Hoc Phan";
    final static int maxColumnOfGiaoVuTable = 5;
    final static int size = 14;
    final static int rowHeight = 25;
    public GUI_GiaoVu()
    {
        createComboBox();
        changeCardName();
        createTable();
        add(chucNangGVPanel);
        setSize(650,550);
        setTitle("Giao vu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chucNangCB.addItemListener(e -> {
            CardLayout cl = (CardLayout)(giaoVuCardLayout.getLayout());
            cl.show(giaoVuCardLayout, (String)e.getItem());
        });
        namRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if(nuRadioButton.isSelected())
                    {
                        nuRadioButton.setSelected(false);
                    }
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED)
                {
                    if(!nuRadioButton.isSelected())
                    {
                        nuRadioButton.setSelected((true));
                    }
                }
            }
        });
        nuRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if(nuRadioButton.isSelected())
                    {
                        namRadioButton.setSelected(false);
                    }
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED)
                {
                    if(!namRadioButton.isSelected())
                    {
                        namRadioButton.setSelected((true));
                    }
                }
            }
        });
        themMoiButton.addActionListener(new ActionListener() {
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
            }
        });

    }
    //chinh lai font va size chu
    private static void setUIFont(javax.swing.plaf.FontUIResource f)
    {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while(keys.hasMoreElements())
        {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
        }
    }
    private void createComboBox()
    {
        String[] comboBoxItems = {giaoVu,sinhVien,monHoc,lopHoc,hocKi, hocPhanHienTai,dangKyHocPhan};
        for(String str: comboBoxItems)
        {
            chucNangCB.addItem(str);
        }
    }
    private void changeCardName()
    {
        giaoVuCardLayout.add(giaoVuPanel,giaoVu);
        giaoVuCardLayout.add(sinhVienPanel,sinhVien);
        giaoVuCardLayout.add(hocKiPanel,hocKi);
        giaoVuCardLayout.add(monHocPanel,monHoc);
        giaoVuCardLayout.add(lopHocPanel,lopHoc);
        giaoVuCardLayout.add(hocPhanHienTaiPanel,hocPhanHienTai);
        giaoVuCardLayout.add(dangKiHocPhanPanel,dangKyHocPhan);
    }
    private void createTable() {
        Object[] col = {"Ho va ten", "Ngay Sinh", "Gioi tinh", "So Dien Thoai", "Email"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        danhSachGVTable.setModel(model);
        danhSachGVTable.setRowHeight(rowHeight);
        ArrayList<Thongtingiaovu> dsGiaoVu = (ArrayList<Thongtingiaovu>) BUS_GiaoVu.danhSachGiaoVu();
        for(Thongtingiaovu giaoVu:dsGiaoVu) {
            Object[] row = new Object[5];
            row[0] = giaoVu.getHoVaTen();
            row[1] = giaoVu.getNgaySinh();
            row[2] = giaoVu.getGioiTinh();
            row[3] = giaoVu.getSoDienThoai();
            row[4] = giaoVu.getEmail();
            model.addRow(row);
        }
        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] row = new Object[5];
                row[0] = hoVaTenTF.getText();
                String ngaySinh = namSinhTF.getText()+"-"+thangSinhTF.getText()+"-"+ngaySinhTF.getText();
                row[1] = ngaySinh;

                if(namRadioButton.isSelected())
                {
                    row[2]="Nam";
                }
                else
                {
                    row[2] = "Nu";
                }
                row[3] = soDienThoaTF.getText();
                row[4] = emailTF.getText();
                String result = BUS_GiaoVu.themGiaoVu(tenDangNhapTF.getText(),matKhauTF.getText(),hoVaTenTF.getText(), Date.valueOf(ngaySinh),
                        row[2].toString(),soDienThoaTF.getText(),emailTF.getText());
                switch (result) {
                    case "NotNull":
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Ten dang nhap va mat khau khong duoc bo trong");
                        break;
                    case "NoSpace":
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Ten dang nhap va mat khau khong duoc chua khoang trang");
                        break;
                    case "Failed":
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Them giao vu that bai");
                        break;
                    default:
                        model.addRow(row);
                        break;
                }
            }
        });
        //Xoa Giao vu
        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = danhSachGVTable.getSelectedRow();
                if(i>=0)
                {
                    if(BUS_GiaoVu.xoaGiaoVu(i))
                    {
                        model.removeRow(i);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Xoa giao vu that bai");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(chucNangGVPanel, "Chon giao vu can xoa");
                }
            }
        });
        //Sua giao vu
        suaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hoVaTen = hoVaTenTF.getText();
                String ngaySinh = namSinhTF.getText()+"-"+thangSinhTF.getText()+"-"+ngaySinhTF.getText();
                String gioiTinh;
                if(namRadioButton.isSelected())
                {
                    gioiTinh = "Nam";
                }
                else
                {
                    gioiTinh ="Nu";
                }
                String soDienThoai = soDienThoaTF.getText();
                String email = emailTF.getText();
                int i = danhSachGVTable.getSelectedRow();
                if(i>=0) {
                    if(BUS_GiaoVu.capNhatGiaoVu(i,hoVaTen,ngaySinh,gioiTinh,soDienThoai,email))
                    {
                        model.setValueAt(hoVaTen,i,0);
                        model.setValueAt(ngaySinh,i,1);
                        model.setValueAt(gioiTinh,i,2);
                        model.setValueAt(soDienThoai,i,3);
                        model.setValueAt(email,i,4);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(chucNangGVPanel, "Cap nhat thong tin giao vu that bai");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(chucNangGVPanel, "Chon giao vu can cap nhat");
                }

            }
        });
        //Chon 1 dong trong bang
        danhSachGVTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = danhSachGVTable.getSelectedRow();
                hoVaTenTF.setText(model.getValueAt(i,0).toString());
                String namThangNgaySinh = model.getValueAt(i,1).toString();
                String[] arrSplit = namThangNgaySinh.split("-");
                namSinhTF.setText(arrSplit[0]);
                thangSinhTF.setText(arrSplit[1]);
                ngaySinhTF.setText(arrSplit[2]);
                if(model.getValueAt(i,2).toString().equals("Nam"))
                {
                    namRadioButton.setSelected(true);
                }
                else
                {
                    nuRadioButton.setSelected(true);
                }
                soDienThoaTF.setText(model.getValueAt(i,3).toString());
                emailTF.setText(model.getValueAt(i,4).toString());
            }
        });
        //Tim kiem theo ten dang nhap
        timKiemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenDangNhap = JOptionPane.showInputDialog(chucNangGVPanel,"Nhap ten dang nhap: ",
                        "Tim kiem giao vu",JOptionPane.INFORMATION_MESSAGE);
                int chiSoGiaoVu = BUS_GiaoVu.timChiSoBangTenDangNhap(tenDangNhap);
                if(chiSoGiaoVu!=-1)
                {
                    danhSachGVTable.setRowSelectionInterval(chiSoGiaoVu,chiSoGiaoVu);
                }
                else
                {
                    JOptionPane.showMessageDialog(chucNangGVPanel, "Giao Vu khong ton tai");
                }
            }
        });

    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        setUIFont(new javax.swing.plaf.FontUIResource("Arial",Font.PLAIN,size));
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        GUI_GiaoVu giaovu = new GUI_GiaoVu();
        SwingUtilities.invokeLater(() -> giaovu.setVisible(true));
    }

}
