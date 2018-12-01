package com.ddlab.rnd.anabana;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class ProgressDemo extends Application {
 
    @Override
    public void start(Stage stage) throws Exception {
 
//        ProgressBar progressBar = new ProgressBar();
        ProgressIndicator progressIndicator = new ProgressIndicator();
 
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(50));
//        root.setHgap(30);
//        root.getChildren().addAll(progressBar, progressIndicator);
        
        root.getChildren().addAll(progressIndicator);
 
        Scene scene = new Scene(root, 400, 300);
 
        stage.setTitle("JavaFX ProgressBar & ProgressIndicator (o7planning.org)");
        
        TimeUnit.SECONDS.sleep(3);
        
//        progressIndicator.progressProperty().unbind();
        
//        root.getChildren().remove(progressIndicator);
        
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}