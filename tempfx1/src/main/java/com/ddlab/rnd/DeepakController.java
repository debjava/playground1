package com.ddlab.rnd;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;

public class DeepakController {
	
	private Object obj;
	
	@FXML
	private CheckBox checkId;
	
	private Hyperlink link2Id;
	
//	@FXML
//	public void checkClick1() {
//		
//	}
	
	@FXML
	private void checkClick1() {
		System.out.println("=======================DEEPAK CLICKED ========================");
		System.out.println("Now------------>"+obj);
		
		link2Id.setText("ABCD");
		link2Id.setAccessibleText("ABCD");
		
//		link2Id.set
		
		
	}
	
	
	
	public void initData(Object obj) {
//		this.obj = obj;
//		System.out.println(obj);
		
		this.link2Id = (Hyperlink) obj;
	}

}
