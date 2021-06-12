package GUI_Custom_Component;

import POJO.Monhoc;

import javax.swing.*;
import java.awt.*;

public class GUI_Custom_ComboBox_MonHoc extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setText(((Monhoc) value).getTenMonHoc());
        return this;
    }
}
