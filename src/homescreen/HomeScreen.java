package homescreen;

import java.awt.CardLayout;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HomeScreen extends JFrame {

    JPanel cardPanel;
    CardLayout cardLayout;
    private AuthenticationFrame signin;

    public HomeScreen() {
        this.setSize(815, 640);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        try {
            Image icon = ImageIO.read(getClass().getResource("icon.png"));
            setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        JFrame loading = new LoadingScreen(this);
        cardPanel.add(loading.getContentPane(), "loading");

        signin = new AuthenticationFrame(this);
        cardPanel.add(signin.getContentPane(), "SignIn");

        JFrame signup = new SingUpForm(this);
        cardPanel.add(signup.getContentPane(), "SignUp");

        JFrame dashboard = new Dashboard(this);
        cardPanel.add(dashboard.getContentPane(), "dashboard");

        cardLayout.show(cardPanel, "loading");

        this.add(cardPanel);
        this.setVisible(true);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getCardContent() {
        return cardPanel;
    }

    public AuthenticationFrame getAuth() {
        return signin;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeScreen();
            }
        });
    }
}
