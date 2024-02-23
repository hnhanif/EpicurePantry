package homescreen;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoadingScreen extends JFrame {

    private JLabel appNameLabel;
    private JLabel loadingLabel;
    private JProgressBar progressBar;
    private HomeScreen app;

    public LoadingScreen(HomeScreen app) {
        this.app = app;
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Loading Screen");

        appNameLabel = new JLabel("Epicure Pantry", SwingConstants.CENTER);
        appNameLabel.setFont(new Font("Arial", Font.BOLD, 28));
        appNameLabel.setForeground(new Color(43, 174, 102));

        loadingLabel = new JLabel("Loading...", SwingConstants.CENTER);
        loadingLabel.setForeground(new Color(74,186,113));

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true); // Show percentage text
        // Update the progress bar size
        progressBar.setPreferredSize(new Dimension(250, progressBar.getPreferredSize().height)); // You can adjust the width as needed
        // Update the progress bar size
        progressBar.setPreferredSize(new Dimension(progressBar.getPreferredSize().width, 20)); // You can adjust the height as needed

        Container container = new CustomContainer();
        setLayout(new BorderLayout());
        add(container, BorderLayout.CENTER);

        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50);
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {

                progressBar.setValue(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                SwingUtilities.invokeLater(() -> {
                    dispose();
                    // Main application begin from below
                    app.getCardLayout().show(app.cardPanel, "SignIn");
                });
            }
        };

        worker.execute();
        progressBar.setForeground(new Color(74, 186, 113));

    }

    private class CustomContainer extends JPanel {

        private Image backgroundImage;
        private ImageIcon titleIcon;

        public CustomContainer() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.NORTH;

            // Load the title image using ImageIcon and getResource()
            titleIcon = new ImageIcon(getClass().getResource("title.png"));

            // Set the layout for the title image
            appNameLabel = new JLabel(titleIcon);
            gbc.insets = new Insets(60, 0, 0, 0);
            add(appNameLabel, gbc);

            // Loading label with 10px spacing above the progress bar
            gbc.gridy = 1;
            gbc.insets = new Insets(10, 0, 0, 0);
            add(loadingLabel, gbc);

            // Progress bar
            gbc.gridy = 2;
            gbc.insets = new Insets(10, 0, 0, 0);
            add(progressBar, gbc);

            // Load the background image using ImageIcon and getResource()
            URL imageUrl = getClass().getResource("bg.png");
            ImageIcon icon = new ImageIcon(imageUrl);
            backgroundImage = icon.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
