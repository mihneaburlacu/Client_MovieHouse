package view;

import model.Movie;

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

public class ViewAndFilterView extends JFrame implements ItemListener {

    private JPanel contentPane;
    private JTable table;
    private JButton viewButton;
    private JComboBox filterComboBox;
    private JTextField filterTextField;
    private JTextField textField;
    private JButton filterButton;
    private JButton txtButton;
    private JButton xmlButton;
    private JButton csvButton;
    private JButton jsonButton;
    private JLabel lblNewLabel;
    private JLabel viewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblFilterAllMovies;
    private String[][] text;
    private JComboBox languageComboBox;

    public ViewAndFilterView(String language) {
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
        setBounds(100, 100, 890, 586);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel(text[nrLanguage][1]);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(300, 10, 400, 32);
        contentPane.add(lblNewLabel);

        viewLabel = new JLabel(text[nrLanguage][2]);
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 50, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton(text[nrLanguage][3]);
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(527, 50, 115, 29);
        contentPane.add(viewButton);

        lblFilterAllMovies = new JLabel(text[nrLanguage][4]);
        lblFilterAllMovies.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblFilterAllMovies.setBounds(10, 124, 164, 22);
        contentPane.add(lblFilterAllMovies);

        String[] stringChoices = new String[]{text[nrLanguage][8], text[nrLanguage][9], text[nrLanguage][10], text[nrLanguage][7]};
        filterComboBox = new JComboBox<String>(stringChoices);
        //filterComboBox = new JComboBox<String>();
        filterComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterComboBox.setBounds(184, 126, 143, 21);
        contentPane.add(filterComboBox);

        filterButton = new JButton(text[nrLanguage][5]);
        filterButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        filterButton.setBounds(527, 121, 115, 29);
        contentPane.add(filterButton);

        filterTextField = new JTextField();
        filterTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterTextField.setBounds(356, 126, 161, 19);
        contentPane.add(filterTextField);
        filterTextField.setColumns(10);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", text[nrLanguage][7], text[nrLanguage][8], text[nrLanguage][9], text[nrLanguage][10], "ID_CREATOR"},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"
                }
        ));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 192, 761, 347);
        contentPane.add(table);

        txtButton = new JButton("TXT");
        txtButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtButton.setBounds(114, 82, 96, 21);
        contentPane.add(txtButton);

        xmlButton = new JButton("XML");
        xmlButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        xmlButton.setBounds(220, 82, 96, 21);
        contentPane.add(xmlButton);

        csvButton = new JButton("CSV");
        csvButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        csvButton.setBounds(326, 82, 96, 21);
        contentPane.add(csvButton);

        jsonButton = new JButton("JSON");
        jsonButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        jsonButton.setBounds(432, 82, 96, 21);
        contentPane.add(jsonButton);

        lblNewLabel_1 = new JLabel(text[nrLanguage][6]);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 82, 102, 22);
        contentPane.add(lblNewLabel_1);

        languageComboBox = new JComboBox();
        languageComboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Romanian", "Deutsch"}));
        languageComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        languageComboBox.setBounds(664, 0, 109, 21);
        contentPane.add(languageComboBox);
        languageComboBox.addItemListener(this);
    }

    public void resetTable() {

        if(returnLanguage().equalsIgnoreCase("English")) {
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {"ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                    },
                    new String[]{
                            "ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"
                    }
            ));
        }
        else if(returnLanguage().equalsIgnoreCase("English")) {
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {"ID", "NUME", "TIP", "CATEGORIE", "AN", "ID_CREATOR"},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                    },
                    new String[]{
                            "ID", "NUME", "TIP", "CATEGORIE", "AN", "ID_CREATOR"
                    }
            ));
        }
        else {
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {"ID", "NAME", "TYP", "KATEGORIE", "JAHR", "ID_CREATOR"},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                    },
                    new String[]{
                            "ID", "NAME", "TYP", "KATEGORIE", "JAHR", "ID_CREATOR"
                    }
            ));
        }
    }


    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void addFilterButton(ActionListener actionListener) {
        filterButton.addActionListener(actionListener);
    }

    public void addTxtButton(ActionListener actionListener) {
        txtButton.addActionListener(actionListener);
    }

    public void addXmlButton(ActionListener actionListener) {
        xmlButton.addActionListener(actionListener);
    }

    public void addCSVButton(ActionListener actionListener) {
        csvButton.addActionListener(actionListener);
    }

    public void addJSONButton(ActionListener actionListener) {
        jsonButton.addActionListener(actionListener);
    }

    public void designTables(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    public void setMovieInTable(int row, Movie movie) {
        this.table.getModel().setValueAt(movie.getID(), row, 0);
        this.table.getModel().setValueAt(movie.getName(), row, 1);
        this.table.getModel().setValueAt(movie.getType().toString(), row, 2);
        this.table.getModel().setValueAt(movie.getCategory(), row, 3);
        this.table.getModel().setValueAt(movie.getYear(), row, 4);
        this.table.getModel().setValueAt(movie.getIdCreator(), row, 5);
    }

    public void setStringInTable(int row, int col, String string) {
        this.table.getModel().setValueAt(string, row, col);
    }

    public String getFilterFromComboBox() {
        return filterComboBox.getSelectedItem().toString();
    }

    public String getFilterTextField() {
        return filterTextField.getText();
    }

    public String[][] getTextFromFile() {
        String[][] matrix = new String[3][11];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Files/ViewAndFilter.csv"));
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields;

                fields = line.split(",");
                for (int j = 0; j < 11; j++) {
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
            viewLabel.setText(text[0][2]);
            viewButton.setText(text[0][3]);
            lblFilterAllMovies.setText(text[0][4]);
            filterButton.setText(text[0][5]);
            lblNewLabel.setText(text[0][6]);
            setStringInTable(0, 1, text[0][7]);
            setStringInTable(0, 2, text[0][8]);
            setStringInTable(0, 3, text[0][9]);
            setStringInTable(0, 4, text[0][10]);
            filterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Type", "Category", "Year", "Name"}));
        }
        else if(language.equalsIgnoreCase("Romanian")) {
            setTitle(text[1][0]);
            lblNewLabel.setText(text[1][1]);
            viewLabel.setText(text[1][2]);
            viewButton.setText(text[1][3]);
            lblFilterAllMovies.setText(text[1][4]);
            filterButton.setText(text[1][5]);
            lblNewLabel.setText(text[1][6]);
            setStringInTable(0, 1, text[1][7]);
            setStringInTable(0, 2, text[1][8]);
            setStringInTable(0, 3, text[1][9]);
            setStringInTable(0, 4, text[1][10]);
            filterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Tip", "Categorie", "An", "Nume"}));
        }
        else{
            setTitle(text[2][0]);
            lblNewLabel.setText(text[2][1]);
            viewLabel.setText(text[2][2]);
            viewButton.setText(text[2][3]);
            lblFilterAllMovies.setText(text[2][4]);
            filterButton.setText(text[2][5]);
            lblNewLabel.setText(text[2][6]);
            setStringInTable(0, 1, text[2][7]);
            setStringInTable(0, 2, text[2][8]);
            setStringInTable(0, 3, text[2][9]);
            setStringInTable(0, 4, text[2][10]);
            filterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Typ", "Kategorie", "Jahr", "Name"}));
        }
    }

    public String returnLanguage() {
        return languageComboBox.getSelectedItem().toString();
    }

}
