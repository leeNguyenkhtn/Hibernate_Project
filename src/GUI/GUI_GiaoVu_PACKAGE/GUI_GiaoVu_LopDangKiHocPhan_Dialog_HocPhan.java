package GUI.GUI_GiaoVu_PACKAGE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_GiaoVu_LopDangKiHocPhan_Dialog_HocPhan extends JDialog {
    private JPanel contentPane;
    private JButton themButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JLabel tenMonHocLabel;
    private JTextField textField2;

    public GUI_GiaoVu_LopDangKiHocPhan_Dialog_HocPhan() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(themButton);

        themButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }
}
