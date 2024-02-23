package homescreen;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class MultiLineCellRenderer extends JScrollPane implements TableCellRenderer {

    private JTextArea textArea;

    public MultiLineCellRenderer() {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        setViewportView(textArea);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Set alignment
        setAlignmentX(CENTER_ALIGNMENT); // Set horizontal alignment to center
        setAlignmentY(CENTER_ALIGNMENT); // Set vertical alignment to center

        // Add mouse wheel listener to enable scrolling
        addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = getVerticalScrollBar();
            int newValue = verticalScrollBar.getValue() - e.getWheelRotation() * verticalScrollBar.getUnitIncrement();
            verticalScrollBar.setValue(newValue);
            textArea.scrollRectToVisible(new Rectangle(0, newValue, 1, 1));
        });

        // Add adjustment listener to handle scrolling with the scrollbar
        getVerticalScrollBar().addAdjustmentListener(e -> {
            int value = e.getValue();
            textArea.scrollRectToVisible(new Rectangle(0, value, 1, 1));
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        textArea.setText(value != null ? value.toString() : "");

        // Adjust the background color based on selection state
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            textArea.setBackground(table.getSelectionBackground());
            textArea.setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            textArea.setBackground(table.getBackground());
            textArea.setForeground(table.getForeground());
        }

        return this;
    }
   
}
