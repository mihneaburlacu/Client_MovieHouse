package controller;

import client.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Movie;
import model.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import view.EmployeeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeController {
    private EmployeeView employeeView;
    private User employee;
    private Client client;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public EmployeeController(User user, String language, Client client) {
        this.client = client;
        this.employee = user;
        this.employeeView = new EmployeeView(employee, language);
        this.employeeView.setVisible(true);

        employeeView.addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = employeeView.returnLanguage();
                FilterAndViewController filterAndViewController = new FilterAndViewController(language, client);
            }
        });

        employeeView.addChartButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String responseAllMovies = client.sendMessage("viewAllMovies/list");
                List<Movie> movies = new ArrayList<>();
                try {
                    movies = objectMapper.readValue(responseAllMovies, new TypeReference<List<Movie>>() {});
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }

                // count the number of movies released each year
                Map<Integer, Integer> yearCounts = new HashMap<>();
                for (Movie movie : movies) {
                    int year = movie.getYear();
                    yearCounts.put(year, yearCounts.getOrDefault(year, 0) + 1);
                }

                // create a dataset for the chart
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (int year : yearCounts.keySet()) {
                    int count = yearCounts.get(year);
                    dataset.addValue(count, "Movies", Integer.toString(year));
                }

                // create the chart
                JFreeChart chart = ChartFactory.createBarChart(
                        "Movies Released by Year",
                        "Year",
                        "Movies",
                        dataset
                );

                // display the chart in a window
                ChartFrame frame = new ChartFrame("Movies Released by Year", chart);
                frame.pack();
                frame.setVisible(true);

                Map<String, Integer> categoryCounts2 = new HashMap<>();
                for (Movie movie : movies) {
                    String category = movie.getCategory();
                    categoryCounts2.put(category, categoryCounts2.getOrDefault(category, 0) + 1);
                }

                DefaultPieDataset dataset2 = new DefaultPieDataset();
                for (String category : categoryCounts2.keySet()) {
                    int count = categoryCounts2.get(category);
                    dataset2.setValue(category, count);
                }

                JFreeChart chart2 = ChartFactory.createPieChart(
                        "Movie Categories",
                        dataset2,
                        true, // legend
                        true, // tooltips
                        false // urls
                );

                ChartFrame frame2 = new ChartFrame("Movie Categories", chart2);
                frame2.pack();
                frame2.setVisible(true);
            }
        });

        employeeView.addCreateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie movie = employeeView.getMovieFromCreateTable(employee.getID());

                String movieString = "";
                try {
                    movieString = objectMapper.writeValueAsString(movie);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }

                String response = client.sendMessage("addMovie/" + movieString);
                if(response.equals("")){
                    JOptionPane.showMessageDialog(null, "Cannot add this movie");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The movie was added");
                }
            }
        });

        employeeView.addReadButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = employeeView.getNameFromReadTextField();

                String response = "";

                if(!name.equals("")) {
                    response = client.sendMessage("readMovieByName/" + name);
                }
                else {
                    String id = employeeView.getIDFromReadTextField();

                    if(!id.equals("")) {
                        try {
                            response = client.sendMessage("readMovieByID/" + id);
                        }catch(Exception exp) {
                            JOptionPane.showMessageDialog(null, "Cannot find this movie");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID or name");
                    }
                }

                Movie movie = new Movie();
                try {
                    movie = objectMapper.reader().forType(Movie.class).readValue(response);
                    employeeView.setMovieToReadTable(movie);
                } catch (JsonMappingException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot find this movie");
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot find this movie");
                }
            }
        });

        employeeView.addUpdateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = employeeView.getIDFromUpdateTextField();

                String info = id + "," + employeeView.getNameFromUpdateTable() + "," + employeeView.getTypeFromUpdateTable() + "," + employeeView.getCategoryFromUpdateTable() + "," + employeeView.getYearFromUpdateTable();
                String response = client.sendMessage("updateMovie/" + info);

                if(response.equals("")){
                    JOptionPane.showMessageDialog(null, "Cannot update this movie");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The movie was updated");

                    Movie movie = new Movie();

                    try {
                        movie = objectMapper.reader().forType(Movie.class).readValue(response);
                    } catch (JsonProcessingException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Cannot notify the observers");
                    }

                    movie.addObserver(employee);
                    movie.setUpdate();
                }
            }
        });

        employeeView.addDeleteButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = employeeView.getNameFromDeleteTextField();

                String response = "";

                if(!name.equals("")) {
                    response = client.sendMessage("deleteMovieByName/" + name);
                }
                else {
                    String id = employeeView.getIDFromDeleteTextField();

                    if(!id.equals("")) {
                        try {
                            response = client.sendMessage("deleteMovieByID/" + id);
                        }catch(Exception exp) {
                            employeeView.showMessage("Cannot delete this movie");
                        }
                    }
                    else {
                        employeeView.showMessage("Please enter a valid ID or username");
                    }
                }

                if(!response.equals("")){
                    employeeView.showMessage("The user was deleted");
                }
                else {
                    employeeView.showMessage("The user was not deleted");
                }
            }
        });
    }
}
