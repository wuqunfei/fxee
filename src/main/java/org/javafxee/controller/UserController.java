package org.javafxee.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Qunfei Wu on 04/01/16.
 */

public class UserController implements Initializable{

    @Autowired
    ApplicationEventPublisher publisher;

    public UserController() {

    }

    @FXML
    Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(e -> {
            System.out.println("clicked");
        });
    }
}
