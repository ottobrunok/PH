package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
/*
    @Override
    public void start(Stage peaLava) throws Exception{
        VBox kiht1 = new VBox();
        Button nupp = new Button("Vajuta mind");
        kiht1.getChildren().add(nupp);
        HBox kiht2 = new HBox();
        kiht2.getChildren().add(nupp);
        Scene stseen = new Scene(kiht1,200,150);
        peaLava.setScene(stseen);
        peaLava.show();
    }
    */
    @Override
    public void start(Stage peaLava){
        VBox juur = new VBox();
        Button nupp = new Button("Vajuta mind");
        juur.getChildren().add(nupp);
        Scene stseen = new Scene(juur,200,150);
        juur.getChildren().add(nupp);
        peaLava.setScene(stseen);
        peaLava.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
