package com.viii28stw.pensiltikfrontend;

import com.viii28stw.pensiltikfrontend.controller.SplashScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Plamedi L. Lusembo
 */
public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage splashScreenStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/splash_screen.fxml"));
        StackPane splashScreenStackPane = loader.load();
        Scene splashScreenScene = new Scene(splashScreenStackPane);
        splashScreenStage.setResizable(false);
        splashScreenStage.setMaximized(false);
        splashScreenStage.setTitle("Loading...");
        splashScreenStage.setScene(splashScreenScene);
        SplashScreenController splashScreenController = loader.getController();
        splashScreenController.setSplashScreenStage(splashScreenStage);
        splashScreenStage.show();
    }
}
