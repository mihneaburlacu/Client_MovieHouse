package view;

import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class ManagerView extends JFrame implements ItemListener {

    private JPanel contentPane;
    private JLabel welcomeLabel;
    private JLabel insertUsernameLabel;
    private JButton viewButton;
    private JComboBox languageComboBox;
    private JLabel viewLabel;
    private JLabel lblOrSaveInfo;
    private String[][] text;

    public ManagerView(User user, String language) {
        text = getTextFromFile();

        int nrLanguage;
        if(language.equalsIgnoreCase("English")) {
            nrLanguage = 0;
        }
        else if(language.equalsIgnoreCase("Romanian")) {
            nrLanguage = 1;
        }
        else {
            nrLanguage = 2;
        }

        setTitle(text[nrLanguage][0]);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 560, 410);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel(text[nrLanguage][1]);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(125, 10, 145, 29);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(263, 8, 130, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        viewLabel = new JLabel(text[nrLanguage][2]);
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 96, 400, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton(text[nrLanguage][3]);
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(170, 220, 245, 29);
        contentPane.add(viewButton);

        lblOrSaveInfo = new JLabel(text[nrLanguage][4]);
        lblOrSaveInfo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblOrSaveInfo.setBounds(10, 162, 332, 22);
        contentPane.add(lblOrSaveInfo);

        insertUsernameLabel.setText(user.getUsername());

        languageComboBox = new JComboBox();
        languageComboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Romanian", "Deutsch"}));
        languageComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        languageComboBox.setBounds(437, 0, 109, 21);
        contentPane.add(languageComboBox);
        languageComboBox.addItemListener(this);

    }

    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public String[][] getTextFromFile() {
        String[][] matrix = new String[3][5];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Files/Manager.csv"));
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields;

                fields = line.split(",");
                for (int j = 0; j < 5; j++) {
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
            welcomeLabel.setText(text[0][1]);
            viewLabel.setText(text[0][2]);
            viewButton.setText(text[0][3]);
            lblOrSaveInfo.setText(text[0][4]);
        }
        else if(language.equalsIgnoreCase("Romanian")) {
            setTitle(text[1][0]);
            welcomeLabel.setText(text[1][1]);
            viewLabel.setText(text[1][2]);
            viewButton.setText(text[1][3]);
            lblOrSaveInfo.setText(text[1][4]);
        }
        else{
            setTitle(text[2][0]);
            welcomeLabel.setText(text[2][1]);
            viewLabel.setText(text[2][2]);
            viewButton.setText(text[2][3]);
            lblOrSaveInfo.setText(text[2][4]);
        }
    }

    public String returnLanguage() {
        return languageComboBox.getSelectedItem().toString();
    }
}

