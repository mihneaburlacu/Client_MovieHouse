package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class LogInView extends JFrame implements ItemListener {

    private JPanel contentPane;
    private JButton LogInButton;
    private JLabel welcomeLabel;
    private JLabel logInLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JLabel imageLabel;
    private JComboBox languageComboBox;
    private String[][] text;


    public LogInView() {
        text = getTextFromFile();

        setTitle("MovieHouse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 710, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        LogInButton = new JButton("Log In");
        LogInButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
        LogInButton.setBounds(250, 320, 165, 40);
        contentPane.add(LogInButton);

        welcomeLabel = new JLabel("Welcome to the Movie House Application!");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        welcomeLabel.setBounds(70, 10, 550, 65);
        contentPane.add(welcomeLabel);

        logInLabel = new JLabel("Please log in into your account!");
        logInLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        logInLabel.setBounds(155, 65, 395, 50);
        contentPane.add(logInLabel);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameLabel.setBounds(25, 160, 105, 30);
        contentPane.add(usernameLabel);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        passwordLabel.setBounds(25, 230, 100, 30);
        contentPane.add(passwordLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(135, 160, 240, 30);
        contentPane.add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(135, 230, 240, 30);
        contentPane.add(passwordTextField);

        imageLabel = new JLabel("");
        ImageIcon img = new ImageIcon("src/Images/movie.png");
        imageLabel.setIcon(img);
        imageLabel.setBounds(454, 112, 166, 194);
        contentPane.add(imageLabel);

        languageComboBox = new JComboBox();
        languageComboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Romanian", "Deutsch"}));
        languageComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        languageComboBox.setBounds(587, 10, 109, 21);
        contentPane.add(languageComboBox);
        languageComboBox.addItemListener(this);
    }

    public void addLogInListener(ActionListener actionListener) {
        this.LogInButton.addActionListener(actionListener);
    }

    public String getUsernameTextField() {
        return usernameTextField.getText();
    }

    public String getPasswordTextField() {
        return passwordTextField.getText();
    }

    public String[][] getTextFromFile() {
        String[][] matrix = new String[3][6];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Files/LogIn.csv"));
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields;

                fields = line.split(",");
                for (int j = 0; j < 6; j++) {
                    matrix[i][j] = fields[j];
                }

                i++;
            }
        } catch(Exception exp){
            exp.printStackTrace();
            System.out.println("Exception while reading from CSV File");
        }

        return matrix;
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        String language = (String) languageComboBox.getSelectedItem();
        if(language.equalsIgnoreCase("English")) {
            setTitle(text[0][0]);
            LogInButton.setText(text[0][1]);
            welcomeLabel.setText(text[0][2]);
            logInLabel.setText(text[0][3]);
            usernameLabel.setText(text[0][4]);
            passwordLabel.setText(text[0][5]);
        }
        else if(language.equalsIgnoreCase("Romanian")) {
            usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            usernameLabel.setBounds(25, 160, 115, 30);
            setTitle(text[1][0]);
            LogInButton.setText(text[1][1]);
            welcomeLabel.setText(text[1][2]);
            logInLabel.setText(text[1][3]);
            usernameLabel.setText(text[1][4]);
            passwordLabel.setText(text[1][5]);
        }
        else{
            setTitle(text[2][0]);
            LogInButton.setText(text[2][1]);
            welcomeLabel.setText(text[2][2]);
            logInLabel.setText(text[2][3]);
            usernameLabel.setText(text[2][4]);
            passwordLabel.setText(text[2][5]);
        }
    }

    public String returnLanguage() {
        return languageComboBox.getSelectedItem().toString();
    }
}

