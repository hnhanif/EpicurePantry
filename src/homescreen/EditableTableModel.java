package homescreen;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class EditableTableModel extends DefaultTableModel {

    public EditableTableModel(List<List<Object>> data, List<Object> columnNames) {
        super(data.toArray(new Object[0][0]), columnNames.toArray());
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true; // All cells are editable
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        super.setValueAt(value, row, column);
        fireTableCellUpdated(row, column);
    }

    // New method to get the data list
    public List<List<Object>> getDataList() {
        List<List<Object>> result = new ArrayList<>();
        for (int i = 0; i < getRowCount(); i++) {
            List<Object> row = new ArrayList<>();
            for (int j = 0; j < getColumnCount(); j++) {
                row.add(getValueAt(i, j));
            }
            result.add(row);
        }
        return result;
    }
}
