package org.javafxee.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.javafxee.util.MyMessage;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by wuqunfei on 16/1/8.
 */
@Controller
public class CarController implements Initializable {

    @FXML
    Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("init");
    }

    @Async
    @EventListener(condition = "#message.isUsed")
    public void handleContextStart(MyMessage message) throws InterruptedException {
        System.out.println("Got message:" + message.getMessage());
        Thread.sleep(5000);

        //TODO in async, this proxy object don't initialise @FXML, so label is null. If I don't set @EnableAsync(proxyTargetClass = true) in MainLauncher, I can't start container.
        label.setText(message.getMessage());
    }
}