package GUI;

import BUS.BUS_SinhVien;
import POJO.Sinhvien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_SinhVien extends JFrame{
    private JPanel sinhVienPanel;
    private JButton thongTinButton;
    private JButton ketQuaButton;
    private JButton dangKyButton;
    private JButton doiMatKhauButton;
    private JPanel noiDungPanel;
    private JPanel dangKyPanel;
    private JPanel ketQuaPanel;
    private JPanel doiMatKhauPanel;
    private JButton thayDoiThongTinhButton;
    private JTextField hoVaTenTF;
    private JTextField ngaySinhTF;
    private JLabel mssvLabel;
    private JRadioButton namButton;
    private JRadioButton nuButton;
    private JTextField diaChiTF;
    private JTextField soDienThoaiTF;
    private JLabel lopLabel;
    private JPanel thongTinPanel;
    private JButton dangXuatButton;

    public GUI_SinhVien(String idSinhVien)
    {
        add(sinhVienPanel);
        setSize(450,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thongTinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sinhvien sinhVien = BUS_SinhVien.loadSinhVienById(idSinhVien);
                loadThongTin(sinhVien);
                CardLayout cardLayout = (CardLayout) noiDungPanel.getLayout();
                cardLayout.show(noiDungPanel,"thongTinCard");
            }
        });
    }
    public void loadThongTin(Sinhvien sinhvien)
    {
        mssvLabel.setText(sinhvien.getMssv());
        hoVaTenTF.setText(sinhvien.getHoVaTen());
        ngaySinhTF.setText(sinhvien.getNgaySinh().toString());
        if(sinhvien.getGioiTinh().equals("Nam"))
        {
            namButton.setSelected(true);
        }
        else
        {
            nuButton.setSelected(true);
        }
        diaChiTF.setText(sinhvien.getDiaChi());
        soDienThoaiTF.setText(sinhvien.getSoDienThoai());
        lopLabel.setText(sinhvien.getLopHoc().getTenLopHoc());
    }
}
