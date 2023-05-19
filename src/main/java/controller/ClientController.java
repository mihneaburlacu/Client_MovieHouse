package controller;

import client.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Enums.Role;
import model.User;
import view.LogInView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ClientController {
    private Client client;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ClientController() {
        client = new Client();
        client.startConnection("127.0.0.1", 6666);

        Client clonedClient = client.clone();

        LogInView logInView = new LogInView();
        logInView.setVisible(true);


        logInView.addLogInListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = logInView.getUsernameTextField();
                String password = logInView.getPasswordTextField();
                String logInResponse = client.sendMessage("login/" + username + "," + password);

                User user = new User();
                try {
                    user = objectMapper.reader().forType(User.class).readValue(logInResponse);
                } catch (JsonMappingException ex) {
                    ex.printStackTrace();
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }

                String lang = logInView.returnLanguage();

                if(user != null) {
                    Role role = user.getRole();

                    if(role == Role.ADMINISTRATOR) {
                        AdministratorController administratorController = new AdministratorController(user, lang, clonedClient);
                    }
                    else if(role == Role.EMPLOYEE) {
                        EmployeeController employeeController = new EmployeeController(user, lang, clonedClient);
                    }
                    else {
                        ManagerController managerController = new ManagerController(user, lang, clonedClient);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again!");
                }
            }
        });
    }

}
