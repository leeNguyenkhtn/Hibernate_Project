package GUI;

import javax.swing.*;
import BUS.BUS_TaiKhoan;

public class GUI_Login extends JFrame{
    private JPasswordField passwordField;
    private JButton login_btn;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JPanel loginPanel;
    private String idSinhVien = null;
    private String idGiaoVu = null;
    public GUI_Login()
    {
        add(loginPanel);
        setTitle("QLDKHP");
        setSize(300,200);
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
                }
                else {
                    JOptionPane.showMessageDialog(loginPanel, message);
                }
        });

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        GUI_Login login = new GUI_Login();
        SwingUtilities.invokeLater(() -> login.setVisible(true));
    }
}
