package org.javafxee;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.javafxee.launcher.AbstractFxApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

/**
 * Copyright (C) 2015
 * JavaFxEE project https://github.com/wuqunfei/javafxee
 * All rights reserved.
 *
 * @author Qunfei Wu
 */

@Lazy
@SpringBootApplication
public class MainLauncher extends AbstractFxApplication {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Node node = this.applicationContext.getBean("userNode",Node.class);
        root.getChildren().add(node);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(MainLauncher.class, args);
    }
}
