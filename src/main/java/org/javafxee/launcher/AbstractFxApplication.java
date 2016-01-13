package org.javafxee.launcher;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Copyright (C) 2015
 * JavaFxEE project https://github.com/wuqunfei/javafxee
 * All rights reserved.
 *
 * @author Qunfei Wu
 */
public abstract class AbstractFxApplication extends Application {
    private static String[] args;
    protected ConfigurableApplicationContext applicationContext;

    public AbstractFxApplication() {
        super();
    }

    @Override
    public void init() throws Exception {
        applicationContext = SpringApplication.run(getClass(), args);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        applicationContext.close();
    }

    protected static void launchApp(Class<? extends AbstractFxApplication> clazz, String[] args) {
        AbstractFxApplication.args = args;
        Application.launch(clazz, args);
    }
}
