package homescreen;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class ShopList extends JPanel {

    private DefaultListModel<String> listModel;
    private JList<String> shoppingList;
    private Connection connection;

    public ShopList() {
        listModel = new DefaultListModel<>();
        shoppingList = new JList<>(listModel);
        shoppingList.setBorder(BorderFactory.createLineBorder(new Color(74, 186, 113)));
        shoppingList.setCellRenderer(new CustomCellRenderer());
        shoppingList.setFixedCellHeight(40);
        shoppingList.setBackground(new Color(204, 255, 204));
        shoppingList.setSelectionBackground(Color.WHITE);
        shoppingList.setSelectionForeground(new Color(74, 186, 113));

        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Done");
        JButton clearButton = new JButton("Clear All");

        Dimension buttonSize = new Dimension(100, 30);
        addButton.setPreferredSize(buttonSize);
        editButton.setPreferredSize(buttonSize);
        deleteButton.setPreferredSize(buttonSize);
        clearButton.setPreferredSize(buttonSize);

        var btnFont = new Font("Arial", Font.BOLD, 15);
        var cursor = new Cursor(Cursor.HAND_CURSOR);

        addButton.setBackground(new Color(74, 186, 113));
        addButton.setForeground(Color.WHITE);
        addButton.setCursor(cursor);
        addButton.setFocusPainted(false);
        addButton.setBorder(null);
        addButton.setFont(btnFont);

        editButton.setBackground(new Color(255, 255, 255));
        editButton.setForeground(new Color(74, 186, 113));
        editButton.setCursor(cursor);
        editButton.setFocusPainted(false);
        editButton.setBorder(null);
        editButton.setFont(btnFont);

        clearButton.setBackground(new Color(255, 165, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.setFocusPainted(false);
        clearButton.setBorder(null);
        clearButton.setFont(btnFont);

        deleteButton.setBackground(new Color(152, 255, 152));
        deleteButton.setForeground(new Color(74, 186, 113));
        deleteButton.setCursor(cursor);
        deleteButton.setFocusPainted(false);
        deleteButton.setBorder(null);
        deleteButton.setFont(btnFont);

        shoppingList.setCursor(cursor);

        JPanel buttonPanel = new JPanel();
        int horizontalSpacing = 10;
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, horizontalSpacing, 10));

        buttonPanel.setBackground(new Color(204, 255, 204));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(shoppingList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        //buttonaction
        addButton.addActionListener(e -> addItem());
        editButton.addActionListener(e -> editItem());
        deleteButton.addActionListener(e -> deleteItem());
        clearButton.addActionListener(e -> clearAllItems());

        //database
        connectToDatabase();
        loadItemsFromDatabase();
    }

    private void connectToDatabase() {
        try {

            String url = "jdbc:mysql://localhost:3306/epicure";
            String user = "root";
            String password = "root1234";

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadItemsFromDatabase() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT product_name, timestamp FROM shopping_list ORDER BY timestamp DESC");

            while (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                LocalDateTime timestamp = resultSet.getTimestamp("timestamp").toLocalDateTime();

                String itemWithTimestamp = productName + " - " + getCurrentTimestamp(timestamp);
                listModel.addElement(itemWithTimestamp);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addItem() {
        String newItem = JOptionPane.showInputDialog("Enter new item:");
        if (newItem != null) {
            String itemWithTimestamp = newItem + " - " + getCurrentTimestamp(LocalDateTime.now());
            listModel.insertElementAt(itemWithTimestamp, 0);
            saveItemToDatabase(newItem);
        }
    }

    private void saveItemToDatabase(String itemName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shopping_list (product_name) VALUES (?)");
            preparedStatement.setString(1, itemName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editItem() {
        int selectedIndex = shoppingList.getSelectedIndex();
        if (selectedIndex == -1) {
            showNoItemSelectedDialog("Edit");
            return;
        }

        String selectedItem = listModel.getElementAt(selectedIndex);
        String existingItem = selectedItem.split(" - ")[0];
        String updatedItem = JOptionPane.showInputDialog("Edit item:", existingItem);
        if (updatedItem != null) {
            String itemWithTimestamp = updatedItem + " - " + getCurrentTimestamp(LocalDateTime.now());
            listModel.setElementAt(itemWithTimestamp, selectedIndex);
            updateItemInDatabase(selectedItem, updatedItem);
        }
    }

    private void updateItemInDatabase(String oldItem, String newItem) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE shopping_list SET product_name = ? WHERE product_name = ?");
            preparedStatement.setString(1, newItem);
            preparedStatement.setString(2, oldItem.split(" - ")[0]);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteItem() {
        int selectedIndex = shoppingList.getSelectedIndex();
        if (selectedIndex == -1) {
            showNoItemSelectedDialog("Delete");
            return;
        }

        int confirmDialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmDialogResult == JOptionPane.YES_OPTION) {
            String selectedItem = listModel.getElementAt(selectedIndex);
            listModel.removeElementAt(selectedIndex);
            deleteItemFromDatabase(selectedItem);
            PalySound.playNotificationSound();
        }
    }

    private void deleteItemFromDatabase(String itemToDelete) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM shopping_list WHERE product_name = ?");
            preparedStatement.setString(1, itemToDelete.split(" - ")[0]);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearAllItems() {
        int confirmDialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all items?", "Clear All Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirmDialogResult == JOptionPane.YES_OPTION) {
            clearAllItemsInDatabase();
            listModel.removeAllElements();
            PalySound.playNotificationSound();
        }
    }

    private void clearAllItemsInDatabase() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM shopping_list");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showNoItemSelectedDialog(String action) {
        JOptionPane.showMessageDialog(null, "Please select an item to " + action + ".", "No Item Selected", JOptionPane.INFORMATION_MESSAGE);
    }

    private String getCurrentTimestamp(LocalDateTime timestamp) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(timestamp, now);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        if (days > 0) {
            return days + (days == 1 ? " day ago" : " days ago");
        } else if (hours > 0) {
            return formatTimestamp(hours, "hour");
        } else if (minutes > 0) {
            return formatTimestamp(minutes, "minute");
        } else {
            return "just now";
        }
    }

    private String formatTimestamp(long value, String unit) {
        String unitText = value == 1 ? unit : unit + "s";
        return value + " " + unitText + " ago";
    }

    private class CustomCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            String item = value.toString();
            String[] parts = item.split(" - ");
            String itemName = parts[0];
            String timestamp = parts[1];
            label.setText("<html><p style='margin-left:100px; color:rgb(74,186,113)'><b><font size='4'>" + itemName + "</font></b>&nbsp;&nbsp;&nbsp&nbsp<font color='gray' size='2'>" + timestamp + "</font></p></html>");
            list.setFixedCellHeight(40);

            return label;
        }
    }

}
