package GUI.GUI_GiaoVu_PACKAGE;

import BUS.BUS_KyDangKiHocPhan;
import BUS.BUS_LopDangKiHocPhan;
import BUS.BUS_LopHoc;
import BUS.BUS_MonHoc;
import CONST_CODE.Code;
import GUI_Custom_Component.GUI_Custom_ComboBox_LopHoc;
import GUI_Custom_Component.GUI_Custom_ComboBox_MonHoc;
import POJO.Lophoc;
import POJO.Monhoc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class GUI_GiaoVu_LopDangKiHocPhan_Dialog_HocPhan extends JDialog {
    private JPanel contentPane;
    private JButton themButton;
    private JComboBox<Monhoc> tenMonHocCB;
    private JComboBox<String> buoiHocCB;
    private JComboBox<String> caHocCB;
    private JTextField phongHocTF;
    private JTextField gVLTTF;
    private JComboBox<Lophoc> tenLopHocCB;
    private JSpinner siSoSpinner;
    public GUI_GiaoVu_LopDangKiHocPhan_Dialog_HocPhan() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Them Hoc Phan");
        setSize(450,450);
        getRootPane().setDefaultButton(themButton);
        //
        DefaultListCellRenderer custom_MonHoc = new GUI_Custom_ComboBox_MonHoc();
        tenMonHocCB.setRenderer(custom_MonHoc);
        DefaultListCellRenderer custom_LopHoc = new GUI_Custom_ComboBox_LopHoc();
        tenLopHocCB.setRenderer(custom_LopHoc);
        //
        createLopHocCB();
        createMonHocCB();
        createBuoiHocCB();
        createCaHocCB();
        //
        themButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onThem();
            }
        });

        setVisible(true);
    }
    void createMonHocCB()
    {
        List<Monhoc> listMonHoc =  BUS_MonHoc.dsMonHoc;
        for(Monhoc monhoc:listMonHoc)
        {
            tenMonHocCB.addItem(monhoc);
        }
    }
    void createLopHocCB()
    {
        List<Lophoc> listLopHoc = BUS_LopHoc.danhSachLopHoc;
        for(Lophoc lophoc:listLopHoc)
        {
            tenLopHocCB.addItem(lophoc);
        }
    }
    void createBuoiHocCB()
    {
        String[] dateOfWeek = {"Thu 2","Thu 3","Thu 4","Thu 5","Thu 6","Thu 7","Chu Nhat"};
        for(String date:dateOfWeek)
        {
            buoiHocCB.addItem(date);
        }
    }
    void createCaHocCB()
    {
        String[] listPeriod = {"7:30–9:30","9:30–11:30", "13:30–15:30", "15:30–17:30"};
        for(String period:listPeriod)
        {
            caHocCB.addItem(period);
        }
    }
    private void onThem() {
        // add your code here
            String idMonHoc = ((Monhoc) Objects.requireNonNull(tenMonHocCB.getSelectedItem())).getIdMonHoc();
            String idLopHoc = ((Lophoc) Objects.requireNonNull(tenLopHocCB.getSelectedItem())).getIdLopHoc();
            String buoiHoc =  Objects.requireNonNull(buoiHocCB.getSelectedItem()).toString();
            String caHoc  = Objects.requireNonNull(caHocCB.getSelectedItem()).toString();
            int siSo = (int)siSoSpinner.getValue();
            int result = BUS_LopDangKiHocPhan.themHocPhanMoi(idMonHoc,idLopHoc,gVLTTF.getText(),phongHocTF.getText(),
                    buoiHoc,caHoc,siSo);
            switch (result)
            {
                case Code.THANH_CONG:
                    JOptionPane.showMessageDialog(this,"Them hoc phan thanh cong","",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    break;
                case Code.THAT_BAI:
                    JOptionPane.showMessageDialog(this,"Them hoc phan that bai","",JOptionPane.ERROR_MESSAGE);
                    break;
                case Code.CHUA_CO_KY_DANG_KI_HOC_PHAN:
                    JOptionPane.showMessageDialog(this,"Khong co ki dang ki hoc phan nao","",JOptionPane.WARNING_MESSAGE);
                    break;
                case Code.LOP_HOC_KHONG_HOP_LE:
                    JOptionPane.showMessageDialog(this,"Lop hoc khong hop le","",JOptionPane.WARNING_MESSAGE);
                    break;
                case Code.MON_HOC_KHONG_HOP_LE:
                    JOptionPane.showMessageDialog(this,"Mon hoc khong hop le","",JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    break;
            }


    }
}
