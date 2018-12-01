package com.ddlab.rnd.ui.pref;

import java.io.File;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UserPrefController {
	
	@FXML
	private JFXToggleButton importJsonId;
	
	@FXML
	private JFXTextField jsonPathId;
	
	@FXML
	private Button switchLogUploadBtnId;
	
	public void onSwitchLogUpload() {
		
	}
	
	public void onValidate() {
		Stage stage = (Stage) importJsonId.getScene().getWindow();
	    stage.close();
	}
	
	public void onPrePopulate() {
		
	}
	
	public void onImport() {
		System.out.println("You clicked....");
	}
	
	public void onJsonUpload() {
		System.out.println("----");
		
		FileChooser fileChooser = new FileChooser();
		
		FileChooser.ExtensionFilter xmlFilter
	    = new FileChooser.ExtensionFilter("XML Files", "*.xml", "*.fxml");
		fileChooser.getExtensionFilters().add(xmlFilter);
		
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(new Stage());
//		System.out.println(file.getAbsolutePath());
		jsonPathId.setText(file.getAbsolutePath());
	}
	
	

}
