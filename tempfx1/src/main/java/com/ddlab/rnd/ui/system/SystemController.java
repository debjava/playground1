package com.ddlab.rnd.ui.system;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;

public class SystemController {
	
	@FXML
	private JFXTextField ntpServerIpId;
	
//	@FXML
//	private TextField ntpServerIpId;
	
//	@FXML
//	private Button ipAddBtnId;
	
	@FXML
	private JFXButton ipAddBtnId;
	
	@FXML
	private ComboBox vendorComboId;
	
	@FXML
	private AnchorPane ntpServerIpAnchorPaneId;
	
	@FXML
	private JFXToggleButton esrsIpToggleId;
	
	@FXML
	private Button nextBtnId;
	
	private Hyperlink link2Id;
	
	public void initData(Object obj) {
		this.link2Id = (Hyperlink) obj;
	}
	
	
	@FXML
	public void onNTPServerAddition() {
		System.out.println("You clicked NTP + Button ....");
//		nextBtnId.setDisable(true);
	}
	
	public void onClickESRSToggleBtn() {
		
	}
	
	public void onNextAction() {
		//Invoke the secondLink
		link2Id.fire();
	}
	

}
