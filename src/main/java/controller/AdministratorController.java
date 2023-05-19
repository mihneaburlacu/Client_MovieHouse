package controller;

import client.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import view.AdministratorView;
import view.AllView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdministratorController {
    private User administrator;
    private AdministratorView administratorView;
    private AllView allView;
    private Client client;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public AdministratorController(User user, String lang, Client client) {
        this.administrator = user;
        this.client = client;
        this.administratorView = new AdministratorView(administrator, lang);
        this.administratorView.setVisible(true);

        administratorView.addCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = administratorView.getUserFromCreateTable();

                String userString = "";
                try {
                    userString = objectMapper.writeValueAsString(user);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }

                String response = client.sendMessage("addUser/" + userString);
                if(response.equals("")){
                    JOptionPane.showMessageDialog(null, "Cannot add this user");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The user was added");
                }
            }
        });

        administratorView.addReadListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = administratorView.getUsernameFromReadTextField();

                String response = "";

                if(!username.equals("")) {
                    response = client.sendMessage("readUserByUsername/" + username);
                }
                else {
                    String id = administratorView.getIDFromReadTextField();

                    if(!id.equals("")) {
                        try {
                            response = client.sendMessage("readUserByID/" + id);
                        }catch(Exception exp) {
                            administratorView.showMessage("Cannot find this user");
                        }
                    }
                    else {
                        administratorView.showMessage("Please enter a valid ID or username");
                    }
                }

                User user = new User();
                try {
                    user = objectMapper.reader().forType(User.class).readValue(response);
                    administratorView.setReadTable(user);
                } catch (JsonMappingException ex) {
                    ex.printStackTrace();
                    administratorView.showMessage("Cannot find this user");
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                    administratorView.showMessage("Cannot find this user");
                }
            }
        });

        administratorView.addUpdateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = administratorView.getIDFromTextFieldUpdate();

                String info = id + "," + administratorView.getNameFromUpdateTable(0) + "," + administratorView.getUsernameFromUpdateTable(0) + "," + administratorView.getPasswordFromUpdateTable(0) + "," + administratorView.getRoleFromUpdateTable(0);
                String response = client.sendMessage("updateUser/" + info);

                if(response.equals("")){
                    JOptionPane.showMessageDialog(null, "Cannot update this user");
                }
                else if(response.equals("no email")){
                    JOptionPane.showMessageDialog(null, "Cannot send the email");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The user was updated");
                }
            }
        });

        administratorView.addDeleteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = administratorView.getUsernameFromDeleteTextField();

                String response = "";

                if(!username.equals("")) {
                    response = client.sendMessage("deleteUserByUsername/" + username);
                }
                else {
                    String id = administratorView.getIDFromDeleteTextField();

                    if(!id.equals("")) {
                        try {
                            response = client.sendMessage("deleteUserByID/" + id);
                        }catch(Exception exp) {
                            administratorView.showMessage("Cannot delete this user");
                        }
                    }
                    else {
                        administratorView.showMessage("Please enter a valid ID or username");
                    }
                }

                if(!response.equals("")){
                    administratorView.showMessage("The user was deleted");
                }
                else {
                    administratorView.showMessage("The user was not deleted");
                }
            }
        });

        administratorView.addViewAllListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lang = administratorView.returnLanguage();

                allView = new AllView(lang);
                allView.setVisible(true);

                String response = client.sendMessage("viewAllUsers/list");

                List<User> list = new ArrayList<>();
                try {
                    list = objectMapper.readValue(response, new TypeReference<List<User>>() {});
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }

                int nr = 1;
                for(User u : list) {
                    allView.setUserInTable(nr, u);
                    nr++;
                }

                allView.designTables();

                allView.addFilterListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String role = allView.getRoleFilter();
                        String response = client.sendMessage("filterAllUsers/" + role);

                        List<User> list = new ArrayList<>();
                        try {
                            list = objectMapper.readValue(response, new TypeReference<List<User>>() {});
                        } catch (JsonProcessingException ex) {
                            ex.printStackTrace();
                        }

                        allView.resetTable(lang);

                        int nr = 1;
                        for(User user : list) {
                            allView.setUserInTable(nr, user);
                            nr++;
                        }

                        allView.designTables();
                    }
                });


            }
        });


    }
}
