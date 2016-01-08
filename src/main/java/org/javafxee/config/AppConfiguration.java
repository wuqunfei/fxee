package org.javafxee.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.javafxee.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Qunfei Wu on 04/01/16.
 */
@Configuration
public class AppConfiguration {

    @Bean
    @Scope(value = "prototype")
    public FXMLLoader getFXMLLoader() {
        return new FXMLLoader();
    }

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
        FXMLLoader fxmlLoader = getFXMLLoader();
        fxmlLoader.setController(getUserController());
        return fxmlLoader.load(getUserFxml());
    }

    protected InputStream getFxmlInputStream(String fileName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        return inputStream;
    }


}
