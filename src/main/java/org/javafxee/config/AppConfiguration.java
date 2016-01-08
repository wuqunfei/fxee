package org.javafxee.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.javafxee.controller.ShopCartController;
import org.javafxee.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Qunfei Wu on 04/01/16.
 */
@Configuration
public class AppConfiguration {
    @Bean(name = "userFXML")
    public InputStream getUserFxml() throws IOException {
        return this.getFxmlInputStream("fxml/user.fxml");
    }

    @Bean(name = "userController")
    public UserController getUserController() {
        return new UserController();
    }

    @Bean(name = "userNode")
    public Node getUserNode() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(getUserController());
        Node node = loader.load(getUserFxml());
        return node;
    }


    @Bean(name = "shopCarFXML")
    public InputStream getShopCarFxml() throws IOException {
        return this.getFxmlInputStream("fxml/shopcar.fxml");
    }

    @Bean(name = "shopCarController")
    public ShopCartController getShopCharController() {
        return new ShopCartController();
    }

    @Bean(name = "shopNode")
    public Node getShopNode() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(getShopCharController());
        Node node = loader.load(getShopCarFxml());
        return node;
    }

    protected InputStream getFxmlInputStream(String fileName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        return inputStream;
    }


}
