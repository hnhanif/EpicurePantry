package homescreen;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;

public class CustomizeCupboardBoxRenderer extends DefaultListCellRenderer {

    private static final Color DEFAULT_HOVER_BACKGROUND_COLOR = new Color(74, 186, 113);
    private static final Color DEFAULT_TEXT_COLOR = Color.WHITE;

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Center the text
        label.setHorizontalAlignment(JLabel.CENTER);

        // Customize hover background color
        if (isSelected) {
            label.setBackground(DEFAULT_HOVER_BACKGROUND_COLOR);
            label.setForeground(DEFAULT_TEXT_COLOR);
        } else {
            label.setBackground(UIManager.getColor("ComboBox.background"));
            label.setForeground(new Color(74, 186, 113)); // Adjust this color as needed
        }

        return label;
    }
}
