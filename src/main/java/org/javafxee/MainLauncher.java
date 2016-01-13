package org.javafxee;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.javafxee.launcher.AbstractFxApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Copyright (C) 2015
 * JavaFxEE project https://github.com/wuqunfei/javafxee
 * All rights reserved.
 *
 * @author Qunfei Wu
 */

@Lazy
@EnableAsync(proxyTargetClass = true)
@SpringBootApplication
public class MainLauncher extends AbstractFxApplication {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Node nodeLeft = this.applicationContext.getBean("userNode",Node.class);
        Node nodeRight = this.applicationContext.getBean("carNode",Node.class);

        root.setLeft(nodeLeft);
        root.setRight(nodeRight);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(MainLauncher.class, args);
    }
}
