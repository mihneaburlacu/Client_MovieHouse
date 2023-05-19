package view;

import model.Enums.Role;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class AdministratorView extends JFrame implements ItemListener {

    private JPanel contentPane;
    private JLabel welcomeLabel;
    private JTable createTable;
    private JLabel insertUsernameLabel;
    private JButton createButton;
    private JTextField usernameReadTextField;
    private JTextField idReadTextField;
    private JButton readButton;
    private JTable readTable;
    private JTable updateTable;
    private JTextField updateIDTextField;
    private JTextField usernameDeleteTextField;
    private JTextField idDeleteTextField;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton updateButton;
    private JLabel createLabel;
    private JLabel idInsertLabel;
    private JLabel nameInsertLabel;
    private JLabel usernameInsertLabel;
    private JLabel passwordInsertLabel;
    private JLabel lblRole;
    private JLabel readLabel;
    private JLabel readUsernameLabel;
    private JLabel readIDLabel;
    private JLabel updateLabel;
    private JLabel readIDLabel_1;
    private JLabel nameInsertLabel_1;
    private JLabel usernameInsertLabel_1;
    private JLabel passwordInsertLabel_1;
    private JLabel lblRole_1;
    private JLabel deleteLabel;
    private JLabel readUsernameLabel_1;
    private JLabel readIDLabel_2;
    private JLabel viewLabel;
    private String[][] text;
    private JComboBox languageComboBox;

    public AdministratorView(User administrator, String lang) {
        text = getTextFromFile();

        int nrLanguage;
        if(lang.equalsIgnoreCase("English")) {
            nrLanguage = 0;
        }
        else if(lang.equalsIgnoreCase("Romanian")) {
            nrLanguage = 1;
        }
        else {
            nrLanguage = 2;
        }

        setTitle(text[nrLanguage][0]);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 685, 575);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel(text[nrLanguage][1]);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(225, 10, 135, 37);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(356, 10, 170, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        createLabel = new JLabel(text[nrLanguage][2]);
        createLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createLabel.setBounds(10, 50, 160, 22);
        contentPane.add(createLabel);

        createTable = new JTable();
        createTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column"
                }
        ));
        createTable.setBounds(20, 115, 420, 16);
        contentPane.add(createTable);

        createButton = new JButton(text[nrLanguage][3]);
        createButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createButton.setBounds(485, 100, 115, 29);
        contentPane.add(createButton);

        idInsertLabel = new JLabel("ID");
        idInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idInsertLabel.setBounds(36, 85, 45, 13);
        contentPane.add(idInsertLabel);

        nameInsertLabel = new JLabel(text[nrLanguage][4]);
        nameInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel.setBounds(124, 85, 45, 13);
        contentPane.add(nameInsertLabel);

        usernameInsertLabel = new JLabel(text[nrLanguage][5]);
        usernameInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        usernameInsertLabel.setBounds(189, 85, 74, 13);
        contentPane.add(usernameInsertLabel);

        passwordInsertLabel = new JLabel(text[nrLanguage][6]);
        passwordInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        passwordInsertLabel.setBounds(284, 85, 74, 13);
        contentPane.add(passwordInsertLabel);

        lblRole = new JLabel(text[nrLanguage][7]);
        lblRole.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblRole.setBounds(368, 85, 45, 13);
        contentPane.add(lblRole);

        readLabel = new JLabel(text[nrLanguage][8]);
        readLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readLabel.setBounds(10, 150, 160, 22);
        contentPane.add(readLabel);

        readUsernameLabel = new JLabel(text[nrLanguage][9]);
        readUsernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        readUsernameLabel.setBounds(36, 175, 155, 22);
        contentPane.add(readUsernameLabel);

        usernameReadTextField = new JTextField();
        usernameReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameReadTextField.setBounds(215, 178, 143, 19);
        contentPane.add(usernameReadTextField);
        usernameReadTextField.setColumns(10);

        readIDLabel = new JLabel(text[nrLanguage][10]);
        readIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel.setBounds(36, 206, 152, 22);
        contentPane.add(readIDLabel);

        idReadTextField = new JTextField();
        idReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idReadTextField.setColumns(10);
        idReadTextField.setBounds(215, 206, 143, 19);
        contentPane.add(idReadTextField);

        readButton = new JButton(text[nrLanguage][11]);
        readButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readButton.setBounds(485, 184, 115, 29);
        contentPane.add(readButton);

        updateLabel = new JLabel(text[nrLanguage][12]);
        updateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateLabel.setBounds(10, 263, 160, 22);
        contentPane.add(updateLabel);

        readTable = new JTable();
        readTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column"
                }
        ));
        readTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        readTable.setBounds(20, 235, 420, 16);
        contentPane.add(readTable);

        updateTable = new JTable();
        updateTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column"
                }
        ));
        updateTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateTable.setBounds(20, 347, 420, 16);
        contentPane.add(updateTable);

        readIDLabel_1 = new JLabel(text[nrLanguage][13]);
        readIDLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_1.setBounds(36, 297, 152, 22);
        contentPane.add(readIDLabel_1);

        updateIDTextField = new JTextField();
        updateIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateIDTextField.setColumns(10);
        updateIDTextField.setBounds(215, 301, 143, 19);
        contentPane.add(updateIDTextField);

        nameInsertLabel_1 = new JLabel(text[nrLanguage][14]);
        nameInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel_1.setBounds(47, 329, 45, 13);
        contentPane.add(nameInsertLabel_1);

        usernameInsertLabel_1 = new JLabel(text[nrLanguage][15]);
        usernameInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        usernameInsertLabel_1.setBounds(143, 329, 74, 13);
        contentPane.add(usernameInsertLabel_1);

        passwordInsertLabel_1 = new JLabel(text[nrLanguage][16]);
        passwordInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        passwordInsertLabel_1.setBounds(238, 329, 74, 13);
        contentPane.add(passwordInsertLabel_1);

        lblRole_1 = new JLabel(text[nrLanguage][17]);
        lblRole_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblRole_1.setBounds(356, 329, 45, 13);
        contentPane.add(lblRole_1);

        updateButton = new JButton(text[nrLanguage][18]);
        updateButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateButton.setBounds(485, 313, 115, 29);
        contentPane.add(updateButton);

        deleteLabel = new JLabel(text[nrLanguage][19]);
        deleteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteLabel.setBounds(10, 383, 160, 22);
        contentPane.add(deleteLabel);

        readUsernameLabel_1 = new JLabel(text[nrLanguage][20]);
        readUsernameLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        readUsernameLabel_1.setBounds(36, 413, 154, 22);
        contentPane.add(readUsernameLabel_1);

        readIDLabel_2 = new JLabel(text[nrLanguage][21]);
        readIDLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_2.setBounds(36, 439, 152, 22);
        contentPane.add(readIDLabel_2);

        usernameDeleteTextField = new JTextField();
        usernameDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameDeleteTextField.setColumns(10);
        usernameDeleteTextField.setBounds(215, 413, 143, 19);
        contentPane.add(usernameDeleteTextField);

        idDeleteTextField = new JTextField();
        idDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idDeleteTextField.setColumns(10);
        idDeleteTextField.setBounds(215, 443, 143, 19);
        contentPane.add(idDeleteTextField);

        deleteButton = new JButton(text[nrLanguage][22]);
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteButton.setBounds(485, 416, 115, 29);
        contentPane.add(deleteButton);

        viewLabel = new JLabel(text[nrLanguage][23]);
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 489, 270, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton(text[nrLanguage][24]);
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(485, 492, 115, 29);
        contentPane.add(viewButton);

        languageComboBox = new JComboBox();
        languageComboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Romanian", "Deutsch"}));
        languageComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        languageComboBox.setBounds(560, 10, 109, 21);
        contentPane.add(languageComboBox);
        languageComboBox.addItemListener(this);

        //pAdministrator = new PAdministrator(administrator, this);

        setUsernameOnLabel(administrator.getUsername());

    }

    public User getUserFromCreateTable() {
        String role = createTable.getModel().getValueAt(0, 4).toString();

        if (role.equals("ADMINISTRATOR")) {
            return new User(Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString()), createTable.getModel().getValueAt(0, 1).toString(), createTable.getModel().getValueAt(0, 2).toString(), createTable.getModel().getValueAt(0, 3).toString(), Role.ADMINISTRATOR);
        }
        else if (role.equals("MANAGER")){
            return new User(Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString()), createTable.getModel().getValueAt(0, 1).toString(), createTable.getModel().getValueAt(0, 2).toString(), createTable.getModel().getValueAt(0, 3).toString(), Role.MANAGER);
        }
        else {
            return new User(Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString()), createTable.getModel().getValueAt(0, 1).toString(), createTable.getModel().getValueAt(0, 2).toString(), createTable.getModel().getValueAt(0, 3).toString(), Role.EMPLOYEE);
        }
    }

    public String getUsernameFromReadTextField() {
        return usernameReadTextField.getText();
    }

    public String getIDFromReadTextField() {
        return idReadTextField.getText();
    }

    public void setReadTable(User user) {
        readTable.getModel().setValueAt(user.getID(), 0, 0);
        readTable.getModel().setValueAt(user.getName(), 0, 1);
        readTable.getModel().setValueAt(user.getUsername(), 0, 2);
        readTable.getModel().setValueAt(user.getPassword(), 0, 3);
        readTable.getModel().setValueAt(user.getRole().toString(), 0, 4);
    }

    public int getIDFromTextFieldUpdate() {
        return Integer.parseInt(updateIDTextField.getText());
    }

    public String getNameFromUpdateTable(int row) {
        return updateTable.getModel().getValueAt(row, 0).toString();
    }

    public String getUsernameFromUpdateTable(int row) {
        return updateTable.getModel().getValueAt(row, 1).toString();
    }

    public String getPasswordFromUpdateTable(int row) {
        return updateTable.getModel().getValueAt(row, 2).toString();
    }

    public String getRoleFromUpdateTable(int row) {
        return updateTable.getModel().getValueAt(row, 3).toString();
    }

    public String getUsernameFromDeleteTextField() {
        return usernameDeleteTextField.getText();
    }

    public String getIDFromDeleteTextField() {
        return idDeleteTextField.getText();
    }

    public void addCreateListener(ActionListener actionListener) {
        this.createButton.addActionListener(actionListener);
    }

    public void addReadListener(ActionListener actionListener) {
        this.readButton.addActionListener(actionListener);
    }

    public void addUpdateListener(ActionListener actionListener) {
        this.updateButton.addActionListener(actionListener);
    }

    public void addDeleteListener(ActionListener actionListener) {
        this.deleteButton.addActionListener(actionListener);
    }

    public void addViewAllListener(ActionListener actionListener) {
        this.viewButton.addActionListener(actionListener);
    }

    public void setUsernameOnLabel(String username) {
        this.insertUsernameLabel.setText(username);
    }

    public void showMessage(String string) {
        JOptionPane.showMessageDialog(null, string);
    }

    public String[][] getTextFromFile() {
        String[][] matrix = new String[3][25];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Files/Administrator.csv"));
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields;

                fields = line.split(",");
                for (int j = 0; j < 25; j++) {
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
            createLabel.setText(text[0][2]);
            createButton.setText(text[0][3]);
            nameInsertLabel.setText(text[0][4]);
            usernameInsertLabel.setText(text[0][5]);
            passwordInsertLabel.setText(text[0][6]);
            lblRole.setText(text[0][7]);
            readLabel.setText(text[0][8]);
            readUsernameLabel.setText(text[0][9]);
            readIDLabel.setText(text[0][10]);
            readButton.setText(text[0][11]);
            updateLabel.setText(text[0][12]);
            readIDLabel_1.setText(text[0][13]);
            nameInsertLabel_1.setText(text[0][14]);
            usernameInsertLabel_1.setText(text[0][15]);
            passwordInsertLabel_1.setText(text[0][16]);
            lblRole_1.setText(text[0][17]);
            updateButton.setText(text[0][18]);
            deleteLabel.setText(text[0][19]);
            readUsernameLabel_1.setText(text[0][20]);
            readIDLabel_2.setText(text[0][21]);
            deleteButton.setText(text[0][22]);
            viewLabel.setText(text[0][23]);
            viewButton.setText(text[0][24]);
        }
        else if(language.equalsIgnoreCase("Romanian")) {
            setTitle(text[1][0]);
            welcomeLabel.setText(text[1][1]);
            createLabel.setText(text[1][2]);
            createButton.setText(text[1][3]);
            nameInsertLabel.setText(text[1][4]);
            usernameInsertLabel.setText(text[1][5]);
            passwordInsertLabel.setText(text[1][6]);
            lblRole.setText(text[1][7]);
            readLabel.setText(text[1][8]);
            readUsernameLabel.setText(text[1][9]);
            readIDLabel.setText(text[1][10]);
            readButton.setText(text[1][11]);
            updateLabel.setText(text[1][12]);
            readIDLabel_1.setText(text[1][13]);
            nameInsertLabel_1.setText(text[1][14]);
            usernameInsertLabel_1.setText(text[1][15]);
            passwordInsertLabel_1.setText(text[1][16]);
            lblRole_1.setText(text[1][17]);
            updateButton.setText(text[1][18]);
            deleteLabel.setText(text[1][19]);
            readUsernameLabel_1.setText(text[1][20]);
            readIDLabel_2.setText(text[1][21]);
            deleteButton.setText(text[1][22]);
            viewLabel.setText(text[1][23]);
            viewButton.setText(text[1][24]);
        }
        else{
            setTitle(text[1][0]);
            welcomeLabel.setText(text[2][1]);
            createLabel.setText(text[2][2]);
            createButton.setText(text[2][3]);
            nameInsertLabel.setText(text[2][4]);
            usernameInsertLabel.setText(text[2][5]);
            passwordInsertLabel.setText(text[2][6]);
            lblRole.setText(text[2][7]);
            readLabel.setText(text[2][8]);
            readUsernameLabel.setText(text[2][9]);
            readIDLabel.setText(text[2][10]);
            readButton.setText(text[2][11]);
            updateLabel.setText(text[2][12]);
            readIDLabel_1.setText(text[2][13]);
            nameInsertLabel_1.setText(text[2][14]);
            usernameInsertLabel_1.setText(text[2][15]);
            passwordInsertLabel_1.setText(text[2][16]);
            lblRole_1.setText(text[2][17]);
            updateButton.setText(text[2][18]);
            deleteLabel.setText(text[2][19]);
            readUsernameLabel_1.setText(text[2][20]);
            readIDLabel_2.setText(text[2][21]);
            deleteButton.setText(text[2][22]);
            viewLabel.setText(text[2][23]);
            viewButton.setText(text[2][24]);
        }
    }

    public String returnLanguage() {
        return languageComboBox.getSelectedItem().toString();
    }
}
