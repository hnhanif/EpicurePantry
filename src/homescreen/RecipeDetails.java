package homescreen;
// RecipeDetails.java

public class RecipeDetails {

    private String recipeName;
    private String ingredients;
    private String instructions;
    private String category;
    private int preparationTime;

    public String getRecipeName() {
        return recipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getCategory() {
        return category;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public String getDifficulty() {
        return difficulty;
    }
    private String difficulty;

    public RecipeDetails(String recipeName, String ingredients, String instructions, String category, int preparationTime, String difficulty) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
        this.preparationTime = preparationTime;
        this.difficulty = difficulty;
    }

    // Add getters and setters if needed
}
