/*
 * @author Paulo Roberto Almeida Filho
 * @email palmeidaprogramming@gmail.com
 * @site http://www.github.com/palmeidaprog/compweek
 */


package com.github.palmeidaprog.compweek.main;

import com.github.palmeidaprog.compweek.inscritos.ControllerInscrito;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass()
                .getResource("main.fxml"));
        primaryStage.setTitle("Gerador de Lista da Semana da Computação VII");
        primaryStage.setScene(new Scene(root, 770, 380));
        primaryStage.getIcons().add(new Image(Main.class
                .getResourceAsStream("logo.png")));
        primaryStage.show();
        new ControllerInscrito();
    }

    public static Stage getStage() {
        return stage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
