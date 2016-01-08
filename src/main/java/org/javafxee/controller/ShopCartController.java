package org.javafxee.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Qunfei Wu on 04/01/16.
 */
public class ShopCartController implements Initializable {

    @FXML
    Label label;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("waiting for message");
    }


}
