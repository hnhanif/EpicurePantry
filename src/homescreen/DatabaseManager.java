package homescreen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/epicure";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root1234";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static List<String[]> fetchAllRecipes() throws SQLException {
        List<String[]> recipes = new ArrayList<>();

        try (Connection connection = connect(); Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM recipe"; // Adjust the table name if needed
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String recipeName = resultSet.getString("recipe_name");
                String ingredients = resultSet.getString("ingredients");
                String instructions = resultSet.getString("instruction");
                String category = resultSet.getString("category");
                String preparationTime = resultSet.getString("preparation_time");
                String difficulty = resultSet.getString("difficulty");

                String[] recipeData = {recipeName, ingredients, instructions, category, preparationTime, difficulty};
                recipes.add(recipeData);
            }
        }

        return recipes;
    }

    public static void deleteRecipe(String recipeName) throws SQLException {
        try (Connection connection = DatabaseConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM Recipe WHERE recipe_name = ?"
        )) {

            preparedStatement.setString(1, recipeName);

            preparedStatement.executeUpdate();
        }
    }

    public static void updateRecipe(String originalRecipeName, String newRecipeName, String newIngredients,
            String newInstructions, String newCategory, String newPreparationTime, String newDifficulty)
            throws SQLException {
        // Replace the following with your actual SQL update statement
        String updateSql = "UPDATE recipe SET recipe_name=?, ingredients=?, instruction=?, category=?, preparation_time=?, difficulty=? WHERE recipe_name=?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            // Set parameters for the prepared statement
            preparedStatement.setString(1, newRecipeName);
            preparedStatement.setString(2, newIngredients);
            preparedStatement.setString(3, newInstructions);
            preparedStatement.setString(4, newCategory);
            preparedStatement.setString(5, newPreparationTime);
            preparedStatement.setString(6, newDifficulty);
            preparedStatement.setString(7, originalRecipeName);

            // Execute the update statement
            preparedStatement.executeUpdate();
        }
    }
}
