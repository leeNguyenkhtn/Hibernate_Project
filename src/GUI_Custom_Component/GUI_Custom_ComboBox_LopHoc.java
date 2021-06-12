package GUI_Custom_Component;

import POJO.Lophoc;

import javax.swing.*;
import java.awt.*;

public class GUI_Custom_ComboBox_LopHoc extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setText(((Lophoc) value).getTenLopHoc());
        return this;
    }
}
