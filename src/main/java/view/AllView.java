package view;

import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class AllView extends JFrame implements ItemListener {

    private JPanel contentPane;
    private JTable table;
    private JTextField filterTextField;
    private JButton filterButton;
    private JLabel lblFilterAllUsers;
    private JComboBox languageComboBox;
    private JLabel lblNewLabel;
    private String[][] text;

    public AllView(String language){
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
        setBounds(100, 100, 795, 570);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel(text[nrLanguage][1]);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(200, 10, 380, 32);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {text[nrLanguage][4], text[nrLanguage][5], text[nrLanguage][6], text[nrLanguage][7], text[nrLanguage][8]},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "ID", "Name", "Username", "Password", "Role"
                }
        ));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 66, 761, 347);
        contentPane.add(table);

        lblFilterAllUsers = new JLabel(text[nrLanguage][2]);
        lblFilterAllUsers.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblFilterAllUsers.setBounds(10, 459, 230, 22);
        contentPane.add(lblFilterAllUsers);

        filterTextField = new JTextField();
        filterTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterTextField.setColumns(10);
        filterTextField.setBounds(240, 461, 143, 21);
        contentPane.add(filterTextField);

        filterButton = new JButton(text[nrLanguage][3]);
        filterButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        filterButton.setBounds(527, 456, 115, 29);
        contentPane.add(filterButton);

        languageComboBox = new JComboBox();
        languageComboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Romanian", "Deutsch"}));
        languageComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        languageComboBox.setBounds(662, 10, 109, 21);
        contentPane.add(languageComboBox);
        languageComboBox.addItemListener(this);

    }

    public void designTables(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    public void resetTable(String language) {
        if(language.equalsIgnoreCase("English")) {
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {"ID", "Name", "Username", "Password", "Role"},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[]{
                            "ID", "Name", "Username", "Password", "Role"
                    }
            ));
        }
        else if(language.equalsIgnoreCase("Romanian")) {
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {"ID", "Nume", "NumeUtilizator", "Parola", "Rol"},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[]{
                            "ID", "Nume", "NumeUtilizator", "Parola", "Rol"
                    }
            ));
        }
        else {
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {"ID", "Name", "Nutzername", "Passwort", "Rolle"},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[]{
                            "ID", "Name", "Nutzername", "Passwort", "Rolle"
                    }
            ));
        }
    }

    public void addFilterListener(ActionListener actionListener) {
        filterButton.addActionListener(actionListener);
    }

    public void setUserInTable(int row, User user) {
        this.table.getModel().setValueAt(user.getID(), row, 0);
        this.table.getModel().setValueAt(user.getName(), row, 1);
        this.table.getModel().setValueAt(user.getUsername(), row, 2);
        this.table.getModel().setValueAt(user.getPassword(), row, 3);
        this.table.getModel().setValueAt(user.getRole().toString(), row, 4);
    }

    public void setTextInTable(int row, int col, String s) {
        this.table.getModel().setValueAt(s, row, col);
    }

    public String getRoleFilter() {
        return filterTextField.getText();
    }

    public String[][] getTextFromFile() {
        String[][] matrix = new String[3][9];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Files/AllView.csv"));
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields;

                fields = line.split(",");
                for (int j = 0; j < 9; j++) {
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
            lblNewLabel.setText(text[0][1]);
            lblFilterAllUsers.setText(text[0][2]);
            filterButton.setText(text[0][3]);
            setTextInTable(0, 0, text[0][4]);
            setTextInTable(0, 1, text[0][5]);
            setTextInTable(0, 2, text[0][6]);
            setTextInTable(0, 3, text[0][7]);
            setTextInTable(0, 4, text[0][8]);
        }
        else if(language.equalsIgnoreCase("Romanian")) {
            setTitle(text[1][0]);
            lblNewLabel.setText(text[1][1]);
            lblFilterAllUsers.setText(text[1][2]);
            filterButton.setText(text[1][3]);
            setTextInTable(0, 0, text[1][4]);
            setTextInTable(0, 1, text[1][5]);
            setTextInTable(0, 2, text[1][6]);
            setTextInTable(0, 3, text[1][7]);
            setTextInTable(0, 4, text[1][8]);
        }
        else{
            setTitle(text[2][0]);
            lblNewLabel.setText(text[2][1]);
            lblFilterAllUsers.setText(text[2][2]);
            filterButton.setText(text[2][3]);
            setTextInTable(0, 0, text[2][4]);
            setTextInTable(0, 1, text[2][5]);
            setTextInTable(0, 2, text[2][6]);
            setTextInTable(0, 3, text[2][7]);
            setTextInTable(0, 4, text[2][8]);
        }
    }
}

