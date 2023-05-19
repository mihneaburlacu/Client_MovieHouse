package view;

import model.Movie;
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

public class EmployeeView extends JFrame implements ItemListener {

    private JPanel contentPane;
    private JLabel welcomeLabel;
    private JTable createTable;
    private JLabel insertUsernameLabel;
    private JButton createButton;
    private JTextField nameReadTextField;
    private JTextField idReadTextField;
    private JButton readButton;
    private JTable readTable;
    private JTable updateTable;
    private JTextField updateIDTextField;
    private JTextField nameDeleteTextField;
    private JTextField idDeleteTextField;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton chartsButton;
    private User employee;
    private String[][] text;
    private JLabel createLabel;
    private JLabel idInsertLabel;
    private JLabel nameInsertLabel;
    private JLabel typeInsertLabel;
    private JLabel categoryInsertLabel;
    private JLabel lblYear;
    private JLabel readLabel;
    private JLabel readNameLabel;
    private JLabel readIDLabel;
    private JLabel updateLabel;
    private JLabel readIDLabel_1;
    private JLabel nameInsertLabel_1;
    private JLabel typeInsertLabel_1;
    private JLabel categoryInsertLabel_1;
    private JLabel lblYear_1;
    private JLabel deleteLabel;
    private JLabel readNameLabel_1;
    private JLabel readIDLabel_2;
    private JLabel viewLabel;
    private JLabel lblOrFilter;
    private JLabel lblNewLabel;
    private JLabel createChart;
    private JComboBox languageComboBox;

    public EmployeeView(User employee, String language) {
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
        setBounds(100, 100, 785, 605);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel(text[nrLanguage][1]);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(210, 10, 150, 29);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(356, 10, 130, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        createLabel = new JLabel(text[nrLanguage][2]);
        createLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createLabel.setBounds(10, 36, 108, 22);
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
        createTable.setBounds(20, 90, 433, 16);
        contentPane.add(createTable);

        createButton = new JButton(text[nrLanguage][3]);
        createButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createButton.setBounds(485, 82, 165, 29);
        contentPane.add(createButton);

        idInsertLabel = new JLabel("ID");
        idInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idInsertLabel.setBounds(36, 69, 45, 13);
        contentPane.add(idInsertLabel);

        nameInsertLabel = new JLabel(text[nrLanguage][4]);
        nameInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel.setBounds(124, 69, 45, 13);
        contentPane.add(nameInsertLabel);

        typeInsertLabel = new JLabel(text[nrLanguage][5]);
        typeInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        typeInsertLabel.setBounds(188, 69, 74, 13);
        contentPane.add(typeInsertLabel);

        categoryInsertLabel = new JLabel(text[nrLanguage][6]);
        categoryInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        categoryInsertLabel.setBounds(282, 69, 76, 13);
        contentPane.add(categoryInsertLabel);

        lblYear = new JLabel(text[nrLanguage][7]);
        lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblYear.setBounds(368, 69, 45, 13);
        contentPane.add(lblYear);

        readLabel = new JLabel(text[nrLanguage][8]);
        readLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readLabel.setBounds(10, 116, 108, 22);
        contentPane.add(readLabel);

        readNameLabel = new JLabel(text[nrLanguage][9]);
        readNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readNameLabel.setBounds(36, 148, 152, 22);
        contentPane.add(readNameLabel);

        nameReadTextField = new JTextField();
        nameReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nameReadTextField.setBounds(215, 150, 143, 19);
        contentPane.add(nameReadTextField);
        nameReadTextField.setColumns(10);

        readIDLabel = new JLabel(text[nrLanguage][10]);
        readIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel.setBounds(36, 180, 152, 22);
        contentPane.add(readIDLabel);

        idReadTextField = new JTextField();
        idReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idReadTextField.setColumns(10);
        idReadTextField.setBounds(215, 182, 143, 19);
        contentPane.add(idReadTextField);

        readButton = new JButton(text[nrLanguage][11]);
        readButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readButton.setBounds(485, 155, 165, 29);
        contentPane.add(readButton);

        updateLabel = new JLabel(text[nrLanguage][12]);
        updateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateLabel.setBounds(10, 238, 160, 22);
        contentPane.add(updateLabel);

        readTable = new JTable();
        readTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column", "New column"
                }
        ));
        readTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        readTable.setBounds(20, 212, 433, 16);
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
        updateTable.setBounds(20, 325, 433, 16);
        contentPane.add(updateTable);

        readIDLabel_1 = new JLabel(text[nrLanguage][13]);
        readIDLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_1.setBounds(36, 270, 152, 22);
        contentPane.add(readIDLabel_1);

        updateIDTextField = new JTextField();
        updateIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateIDTextField.setColumns(10);
        updateIDTextField.setBounds(215, 272, 143, 19);
        contentPane.add(updateIDTextField);

        nameInsertLabel_1 = new JLabel(text[nrLanguage][14]);
        nameInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel_1.setBounds(46, 302, 45, 13);
        contentPane.add(nameInsertLabel_1);

        typeInsertLabel_1 = new JLabel(text[nrLanguage][15]);
        typeInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        typeInsertLabel_1.setBounds(136, 302, 74, 13);
        contentPane.add(typeInsertLabel_1);

        categoryInsertLabel_1 = new JLabel(text[nrLanguage][16]);
        categoryInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        categoryInsertLabel_1.setBounds(235, 301, 76, 13);
        contentPane.add(categoryInsertLabel_1);

        lblYear_1 = new JLabel(text[nrLanguage][17]);
        lblYear_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblYear_1.setBounds(356, 301, 45, 13);
        contentPane.add(lblYear_1);

        updateButton = new JButton(text[nrLanguage][18]);
        updateButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateButton.setBounds(485, 272, 165, 29);
        contentPane.add(updateButton);

        deleteLabel = new JLabel(text[nrLanguage][19]);
        deleteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteLabel.setBounds(10, 351, 108, 22);
        contentPane.add(deleteLabel);

        readNameLabel_1 = new JLabel(text[nrLanguage][20]);
        readNameLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readNameLabel_1.setBounds(36, 383, 152, 22);
        contentPane.add(readNameLabel_1);

        readIDLabel_2 = new JLabel(text[nrLanguage][21]);
        readIDLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_2.setBounds(36, 415, 152, 22);
        contentPane.add(readIDLabel_2);

        nameDeleteTextField = new JTextField();
        nameDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nameDeleteTextField.setColumns(10);
        nameDeleteTextField.setBounds(215, 385, 143, 19);
        contentPane.add(nameDeleteTextField);

        idDeleteTextField = new JTextField();
        idDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idDeleteTextField.setColumns(10);
        idDeleteTextField.setBounds(215, 417, 143, 19);
        contentPane.add(idDeleteTextField);

        deleteButton = new JButton(text[nrLanguage][22]);
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteButton.setBounds(485, 365, 165, 29);
        contentPane.add(deleteButton);

        viewLabel = new JLabel(text[nrLanguage][23]);
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 445, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton(text[nrLanguage][24]);
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(440, 447, 225, 29);
        contentPane.add(viewButton);

        lblOrFilter = new JLabel(text[nrLanguage][25]);
        lblOrFilter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblOrFilter.setBounds(10, 465, 415, 22);
        contentPane.add(lblOrFilter);

        lblNewLabel = new JLabel(text[nrLanguage][26]);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel.setBounds(10, 484, 400, 22);
        contentPane.add(lblNewLabel);

        createChart = new JLabel(text[nrLanguage][27]);
        createChart.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createChart.setBounds(10, 520, 400, 22);
        contentPane.add(createChart);

        chartsButton = new JButton(text[nrLanguage][28]);
        chartsButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        chartsButton.setBounds(440, 515, 225, 29);
        contentPane.add(chartsButton);

        languageComboBox = new JComboBox();
        languageComboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Romanian", "Deutsch"}));
        languageComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        languageComboBox.setBounds(655, 0, 109, 21);
        contentPane.add(languageComboBox);
        languageComboBox.addItemListener(this);

        this.employee = employee;
        setUsernameToInsertLabel(employee.getUsername());
    }

    public Movie getMovieFromCreateTable(int idCreator) {
        int ID = Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString());
        String name = createTable.getModel().getValueAt(0, 1).toString();
        String type = createTable.getModel().getValueAt(0, 2).toString();
        String category = createTable.getModel().getValueAt(0, 3).toString();
        int year = Integer.parseInt(createTable.getModel().getValueAt(0, 4).toString());
        int id_creator = idCreator;

        if(type.equals("SERIES")) {
            return new Movie(ID, name, model.Enums.Type.SERIES, category, year, id_creator);
        }
        else {
            return new Movie(ID, name, model.Enums.Type.ARTISTIC, category, year, id_creator);
        }
    }

    public String getNameFromReadTextField() {
        return nameReadTextField.getText();
    }

    public String getIDFromReadTextField() {
        return idReadTextField.getText();
    }

    public void setMovieToReadTable(Movie movie) {
        readTable.getModel().setValueAt(movie.getID(), 0, 0);
        readTable.getModel().setValueAt(movie.getName(), 0, 1);
        readTable.getModel().setValueAt(movie.getType().toString(), 0, 2);
        readTable.getModel().setValueAt(movie.getCategory(), 0, 3);
        readTable.getModel().setValueAt(movie.getYear(), 0, 4);
        readTable.getModel().setValueAt(movie.getIdCreator(), 0 , 5);
    }

    public int getIDFromUpdateTextField() {
        return Integer.parseInt(updateIDTextField.getText());
    }

    public String getNameFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 0).toString();
    }

    public String getTypeFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 1).toString();
    }

    public String getCategoryFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 2).toString();
    }

    public int getYearFromUpdateTable() {
        return Integer.parseInt(updateTable.getModel().getValueAt(0, 3).toString());
    }

    public String getNameFromDeleteTextField() {
        return nameDeleteTextField.getText();
    }

    public String getIDFromDeleteTextField() {
        return idDeleteTextField.getText();
    }

    public void addCreateButton(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    public void addReadButton(ActionListener actionListener) {
        readButton.addActionListener(actionListener);
    }

    public void addUpdateButton(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }

    public void addDeleteButton(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }

    public void setUsernameToInsertLabel(String username) {
        insertUsernameLabel.setText(username);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void addChartButton(ActionListener actionListener) {chartsButton.addActionListener(actionListener);}

    public String[][] getTextFromFile() {
        String[][] matrix = new String[3][29];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Files/Employee.csv"));
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields;

                fields = line.split(",");
                for (int j = 0; j < 29; j++) {
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
            typeInsertLabel.setText(text[0][5]);
            categoryInsertLabel.setText(text[0][6]);
            lblYear.setText(text[0][7]);
            readLabel.setText(text[0][8]);
            readNameLabel.setText(text[0][9]);
            readIDLabel.setText(text[0][10]);
            readButton.setText(text[0][11]);
            updateLabel.setText(text[0][12]);
            readIDLabel_1.setText(text[0][13]);
            nameInsertLabel_1.setText(text[0][14]);
            typeInsertLabel_1.setText(text[0][15]);
            categoryInsertLabel_1.setText(text[0][16]);
            lblYear_1.setText(text[0][17]);
            updateButton.setText(text[0][18]);
            deleteLabel.setText(text[0][19]);
            readNameLabel.setText(text[0][20]);
            readIDLabel_2.setText(text[0][21]);
            deleteButton.setText(text[0][22]);
            viewLabel.setText(text[0][23]);
            viewButton.setText(text[0][24]);
            lblOrFilter.setText(text[0][25]);
            lblNewLabel.setText(text[0][26]);
            createChart.setText(text[0][27]);
            chartsButton.setText(text[0][28]);
        }
        else if(language.equalsIgnoreCase("Romanian")) {
            setTitle(text[1][0]);
            welcomeLabel.setText(text[1][1]);
            createLabel.setText(text[1][2]);
            createButton.setText(text[1][3]);
            nameInsertLabel.setText(text[1][4]);
            typeInsertLabel.setText(text[1][5]);
            categoryInsertLabel.setText(text[1][6]);
            lblYear.setText(text[1][7]);
            readLabel.setText(text[1][8]);
            readNameLabel.setText(text[1][9]);
            readIDLabel.setText(text[1][10]);
            readButton.setText(text[1][11]);
            updateLabel.setText(text[1][12]);
            readIDLabel_1.setText(text[1][13]);
            nameInsertLabel_1.setText(text[1][14]);
            typeInsertLabel_1.setText(text[1][15]);
            categoryInsertLabel_1.setText(text[1][16]);
            lblYear_1.setText(text[1][17]);
            updateButton.setText(text[1][18]);
            deleteLabel.setText(text[1][19]);
            readNameLabel.setText(text[1][20]);
            readIDLabel_2.setText(text[1][21]);
            deleteButton.setText(text[1][22]);
            viewLabel.setText(text[1][23]);
            viewButton.setText(text[1][24]);
            lblOrFilter.setText(text[1][25]);
            lblNewLabel.setText(text[1][26]);
            createChart.setText(text[1][27]);
            chartsButton.setText(text[1][28]);
        }
        else{
            setTitle(text[2][0]);
            welcomeLabel.setText(text[2][1]);
            createLabel.setText(text[2][2]);
            createButton.setText(text[2][3]);
            nameInsertLabel.setText(text[2][4]);
            typeInsertLabel.setText(text[2][5]);
            categoryInsertLabel.setText(text[2][6]);
            lblYear.setText(text[2][7]);
            readLabel.setText(text[2][8]);
            readNameLabel.setText(text[2][9]);
            readIDLabel.setText(text[2][10]);
            readButton.setText(text[2][11]);
            updateLabel.setText(text[2][12]);
            readIDLabel_1.setText(text[2][13]);
            nameInsertLabel_1.setText(text[2][14]);
            typeInsertLabel_1.setText(text[2][15]);
            categoryInsertLabel_1.setText(text[2][16]);
            lblYear_1.setText(text[2][17]);
            updateButton.setText(text[2][18]);
            deleteLabel.setText(text[2][19]);
            readNameLabel.setText(text[2][20]);
            readIDLabel_2.setText(text[2][21]);
            deleteButton.setText(text[2][22]);
            viewLabel.setText(text[2][23]);
            viewButton.setText(text[2][24]);
            lblOrFilter.setText(text[2][25]);
            lblNewLabel.setText(text[2][26]);
            createChart.setText(text[2][27]);
            chartsButton.setText(text[2][28]);
        }
    }

    public String returnLanguage() {
        return languageComboBox.getSelectedItem().toString();
    }

}
