package com.ddlab.rnd;

import java.io.IOException;

import com.ddlab.rnd.ui.pref.UserPrefController;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class FXMainApp extends Application {
	
	private void showPrefDialog(Stage stage, final LeftNavigation leftNavController) throws Exception {
		Stage dialog = new Stage();
		FXMLLoader loader = new FXMLLoader(UserPrefController.class.getResource("user-preference.fxml"));
//		AnchorPane prefAnchorPane = null;
		TitledPane prefAnchorPane = null;
		try {
			prefAnchorPane = loader.load();
//			SystemController sysController = (SystemController) loader.getController();
//			sysController.initData(link2Id);
			
			 
			
			Scene scene1 = new Scene(prefAnchorPane);
			dialog.setScene(scene1);
			
			dialog.initStyle(StageStyle.UTILITY);
			dialog.initOwner(stage);
			dialog.initModality(Modality.APPLICATION_MODAL);
			
			dialog.setTitle("Network Validation Tool");
			
//			dialog.showAndWait();
			
			dialog.show();
			
			dialog.setOnCloseRequest(new EventHandler<WindowEvent>() {
		          public void handle(WindowEvent we) {
		              System.out.println("Stage is closing");
		              leftNavController.invokeSystemLink();
		          }
		      });  
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		
//		Parent root = FXMLLoader.load(getClass().getResource("fxMain.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxMain.fxml"));
		
//		FXMLLoader loader = FXMLLoader.load(getClass().getResource("fxMain.fxml"));
		VBox vBox = (VBox) loader.load();
		
//		Pane root = loader.load();
		
		LeftNavigation leftNavController = (LeftNavigation) loader.getController();
		
		
//		root.

//		Scene scene = new Scene(root);
		Scene scene = new Scene(vBox);
		stage.setScene(scene);
		stage.show();
		
		showPrefDialog(stage,leftNavController);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
