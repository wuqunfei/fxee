package org.javafxee.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.javafxee.controller.CarController;
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

    protected InputStream getFxmlInputStream(String fileName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        return inputStream;
    }

    @Bean(name = "userFXML")
    public InputStream getUserFxml() throws IOException {
        return this.getFxmlInputStream("fxml/user.fxml");
    }

    //TODO if configured controller as @controller, this step is duplicated
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

    @Bean(name = "carFxml")
    public InputStream getCarFXML() throws IOException{
        return this.getFxmlInputStream("fxml/car.fxml");
    }

    //TODO if configured controller as @controller, this step is duplicated
    @Bean(name = "carController")
    public CarController getCarController() {
        return new CarController();
    }


    @Bean(name = "carNode")
    public Node getCarNode() throws IOException {
        FXMLLoader fxmlLoader = getFXMLLoader();
        fxmlLoader.setController(getCarController());
        return fxmlLoader.load(getCarFXML());
    }



}
