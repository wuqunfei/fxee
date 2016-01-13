package org.javafxee.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.javafxee.util.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Qunfei Wu on 04/01/16.
 */
@Controller
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
            MyMessage myMessage = new MyMessage();
            myMessage.setId(getClass().getName());
            myMessage.setMessage("Got Message,Hello World");
            myMessage.setUsed(true);
            this.publisher.publishEvent(myMessage);
            System.out.println("Send Message finished, do other things");
        });
    }
}
