package GUI_SinhVien_PACKAGE;

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
    private JPanel sinhVienCardLayout;
    private JPanel dangKyPanel;
    private JButton thayDoiThongTinhButton;
    private JTextField hoVaTenTF;
    private JTextField ngaySinhTF;
    private JLabel mssvLabel;
    private JRadioButton namButton;
    private JRadioButton nuButton;
    private JTextField diaChiTF;
    private JTextField soDienThoaiTF;
    private JPanel thongTinPanel;
    private JButton dangXuatButton;
    final String thongTinCard = "thongTinCard";
    final String dangKyCard = "dangKyCard";
    final String ketQuaCard = "ketQuaCard";
    final String doiMatKhauCard = "doiMatKhauCard";
    public GUI_SinhVien(String idSinhVien)
    {
        BUS_SinhVien bus_sinhVien = new BUS_SinhVien(idSinhVien);

        add(sinhVienPanel);
        setSize(950,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thongTinButton.addActionListener(e -> {
            Sinhvien sinhVien = BUS_SinhVien.loadSinhVienById(idSinhVien);
            loadThongTin(sinhVien);
            CardLayout cardLayout = (CardLayout) sinhVienCardLayout.getLayout();
            cardLayout.show(sinhVienCardLayout,"thongTinCard");
        });
        dangKyButton.addActionListener(e -> {
            dangKyPanel = new GUI_SinhVien_DangKiHocPhan(bus_sinhVien);
            sinhVienCardLayout.add(dangKyPanel,dangKyCard);
            CardLayout cardLayout = (CardLayout) sinhVienCardLayout.getLayout();
            cardLayout.show(sinhVienCardLayout,dangKyCard);
        });
        dangXuatButton.addActionListener(e -> dispose());
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
    }
}
