package controller;

import client.Client;
import model.User;
import view.ManagerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerController {
    private ManagerView managerView;
    private User manager;
    private Client client;

    public ManagerController(User user, String language, Client client) {
        this.manager = user;
        this.managerView = new ManagerView(user, language);
        managerView.setVisible(true);
        this.client = client;

        managerView.addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = managerView.returnLanguage();
                FilterAndViewController filterAndViewController = new FilterAndViewController(language, client);
            }
        });
    }
}
