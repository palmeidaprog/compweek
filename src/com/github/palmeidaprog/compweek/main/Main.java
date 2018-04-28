/*
 * @author Paulo Roberto Almeida Filho
 * @email palmeidaprogramming@gmail.com
 * @site http://www.github.com/palmeidaprog/compweek
 */


package com.github.palmeidaprog.compweek.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass()
                .getResource("main.fxml"));
        primaryStage.setTitle("Gerador de Lista da Semana da Computação VII");
        primaryStage.setScene(new Scene(root, 770, 380));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
