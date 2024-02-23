package homescreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    private MyRecipePanel myNewRecipePanel;
    private RecipeDetialsPanel recipeDetailsPanel;
    private UpdateRecipePanel updateRecipePanel;

    private Container container;
    private JPanel navBar, content;

    public JPanel getContent() {
        return content;
    }
    private JButton recipeBtn, shopListBtn, mealPlannerBtn, recommBtn, profileBtn, logoutBtn;
    private CardLayout cardLayout;

    public CardLayout getCardLayout() {
        return cardLayout;
    }
    private HomeScreen app;

    public Dashboard(HomeScreen app) {
        this.app = app;
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        container = this.getContentPane();
        container.setLayout(null);

        navBar = new JPanel();
        navBar.setLayout(null);
        navBar.setBounds(0, 0, 150, 600);
        navBar.setBackground(new Color(74, 186, 113));

        ImageIcon homeIcon = new ImageIcon("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\home.png");
        recipeBtn = new JButton(homeIcon);
        recipeBtn.setBounds(43, 35, 64, 64);
        recipeBtn.setToolTipText("View All Recipes");
        recipeBtn.setFocusPainted(false);
        recipeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navBar.add(recipeBtn);

        ImageIcon shopIcon = new ImageIcon("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\shop.png");
        shopListBtn = new JButton(shopIcon);
        shopListBtn.setBounds(43, 129, 64, 64);
        shopListBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        shopListBtn.setToolTipText("Shoping List");
        shopListBtn.setFocusPainted(false);
        navBar.add(shopListBtn);

        ImageIcon mealIcon = new ImageIcon("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\meal.png");
        mealPlannerBtn = new JButton(mealIcon);
        mealPlannerBtn.setBounds(43, 222, 64, 64);
        mealPlannerBtn.setFocusPainted(false);
        mealPlannerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mealPlannerBtn.setToolTipText("Meal Planning");
        navBar.add(mealPlannerBtn);

        ImageIcon trendsIcon = new ImageIcon("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\trends.png");
        recommBtn = new JButton(trendsIcon);
        recommBtn.setBounds(43, 315, 64, 64);
        recommBtn.setFocusPainted(false);
        recommBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        recommBtn.setToolTipText("Hot Trends");
        navBar.add(recommBtn);

        ImageIcon contributeIcon = new ImageIcon("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\contribute.png");
        profileBtn = new JButton(contributeIcon);
        profileBtn.setFocusPainted(false);
        profileBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profileBtn.setToolTipText("Contribute");
        profileBtn.setBounds(43, 408, 64, 64);
        navBar.add(profileBtn);

        ImageIcon logoutIcon = new ImageIcon("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\logout.png");
        logoutBtn = new JButton(logoutIcon);
        logoutBtn.setBounds(43, 501, 64, 64);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setToolTipText("Logout");
        logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navBar.add(logoutBtn);

        content = new JPanel();
        content.setBounds(150, 0, 650, 600);

        cardLayout = new CardLayout();
        content.setLayout(cardLayout);

        myNewRecipePanel = new MyRecipePanel(this);
        content.add(myNewRecipePanel, "recipes");

        AddRecipePanel addRecipePanel = new AddRecipePanel(this, myNewRecipePanel);  // Create a JPanel to hold the content
        addRecipePanel.setBackground(Color.WHITE);  // Set the background color (you can customize it)
// Add components to the addRecipePanel as needed
        content.add(addRecipePanel, "addRecipe");

        recipeDetailsPanel = new RecipeDetialsPanel(this);
        content.add(recipeDetailsPanel, "recipeDetails");

        ShopListPanel shopListPanel = new ShopListPanel();
        content.add(shopListPanel, "shopList");
//  s
        MealPlannerPanel mealPlannerPanel = new MealPlannerPanel();
        content.add(mealPlannerPanel, "mealPlanner");

        ProfileViewPanel profileView = new ProfileViewPanel(this);
        content.add(profileView, "profileView");

        HotTrendsPanel trendsPanel = new HotTrendsPanel();
        content.add(trendsPanel, "trends");

        cardLayout.show(content, "recipes");

        container.add(navBar);
        container.add(content);

        //btn action listener
        recipeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCardLayout().show(getContent(), "recipes");
            }
        });

        shopListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCardLayout().show(getContent(), "shopList");
            }
        });
        mealPlannerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCardLayout().show(getContent(), "mealPlanner");
            }
        });
        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCardLayout().show(getContent(), "profileView");
            }
        });

        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank your for using this app");
                app.getAuth().resetPassField();
                app.getCardLayout().show(app.getCardContent(), "SignIn");
            }
        });
        recommBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCardLayout().show(getContent(), "trends");
            }
        });
    }

    public void showRecipeDetailsPanel(String[] selectedDetails) {
        var detailsPanel = new DetailsPanel(this);
        detailsPanel.setData(selectedDetails);
        content.add(detailsPanel, "recipeDetails");
        cardLayout.show(content, "recipeDetails");
    }

    public void showEditRecipePanel(String[] recipeDetails) {
        var editRecipePanel = new UpdateRecipePanel(this, myNewRecipePanel, recipeDetails);
        content.add(editRecipePanel, "editRecipe");
        cardLayout.show(content, "editRecipe");
        editRecipePanel.setRecipeDetails(recipeDetails);
    }

}
