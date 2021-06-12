package GUI;

import javax.swing.*;
import BUS.BUS_TaiKhoan;
import GUI.GUI_GiaoVu_PACKAGE.GUI_GiaoVu;
import GUI_SinhVien_PACKAGE.GUI_SinhVien;

import java.awt.*;
import java.util.Enumeration;

public class GUI_Login extends JFrame{
    private JPasswordField passwordField;
    private JButton login_btn;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JPanel loginPanel;
    private String idSinhVien = null;
    private String idGiaoVu = null;
    final static int size = 14;
    public GUI_Login()
    {
        add(loginPanel);
        setTitle("QLDKHP");
        setSize(450,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login_btn.addActionListener(e -> {
            String matKhau = new String(passwordField.getPassword());
            String tenDangNhap = usernameTextField.getText();
            String message = BUS_TaiKhoan.check(tenDangNhap,matKhau);
                if (message.equals("sinhvien"))
                {
                    idSinhVien = BUS_TaiKhoan.findIdByTenDangNhap(tenDangNhap);
                    SwingUtilities.invokeLater(() -> this.setVisible(false));
                    GUI_SinhVien gui_sinhVien = new GUI_SinhVien(idSinhVien);
                    SwingUtilities.invokeLater(() -> gui_sinhVien.setVisible(true));
                }
                if(message.equals("giaovu"))
                {
                    idGiaoVu = BUS_TaiKhoan.findIdByTenDangNhap(tenDangNhap);
                    SwingUtilities.invokeLater(() -> this.setVisible(false));
                    GUI_GiaoVu gui_giaoVu = new GUI_GiaoVu();
                    SwingUtilities.invokeLater(() -> gui_giaoVu.setVisible(true));
                }
                else {
                    JOptionPane.showMessageDialog(loginPanel, message);
                }
        });

    }
    private static void setUIFont(javax.swing.plaf.FontUIResource f) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
        }
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        setUIFont(new javax.swing.plaf.FontUIResource("Arial", Font.PLAIN, size));
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        GUI_Login login = new GUI_Login();
        SwingUtilities.invokeLater(() -> login.setVisible(true));
    }
}
