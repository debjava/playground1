package com.ddlab.rnd;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ddlab.rnd.ui.system.SystemController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class LeftNavigation {

	@FXML
	private Hyperlink systemLinkId;

	@FXML
	private Hyperlink managmentLinkId;
	
	@FXML
	private AnchorPane contenPaneId;
	
	@FXML
	private ScrollPane scrollPaneId;
	
	AnchorPane systemViewPane = null;
	
	private AnchorPane getSystemViewPane() {
		FXMLLoader loader = new FXMLLoader(SystemController.class.getResource("system.fxml"));
		try {
			systemViewPane = loader.load();
			SystemController sysController = (SystemController) loader.getController();
			sysController.initData(managmentLinkId);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return systemViewPane;
	}
	
	public void invokeSystemLink() {
		systemLinkId.fire();
	}
	
	private void makeOtherLinksNormalExcept( Hyperlink link ) {
		link.getStyleClass().clear();
		link.getStyleClass().add("leftNavHyperLink");
//		link.getStyleClass().add("leftNavHyperLink");
	}



	public void onClickSystem() {
		System.out.println("You clicked Link 1");
		
		AnchorPane systemViewPane = getSystemViewPane();
		
		
		
		
		
//		AnchorPane link1Pane = getAnchorPane();
		setNode(systemViewPane);
//		link1Id.setStyle("-fx-focus-color: #0093ff;");
//		systemLinkId.setStyle("-fx-text-fill: blue;");
		
//		systemLinkId.setStyle("-fx-text-fill: blue;-fx-font-size: 14pt;");
		systemLinkId.getStyleClass().add("hyperlinkSelection");
		makeOtherLinksNormalExcept(managmentLinkId);
	}

	public void onClickmanagment() {
		System.out.println("You clicked Link 2");
		
		AnchorPane link1Pane = getDeepakAnchorPane();
		setNode(link1Pane);
		
		managmentLinkId.getStyleClass().add("hyperlinkSelection");
		makeOtherLinksNormalExcept(systemLinkId);
		
//		Image image1 = new Image(new File("c1.png").toURI().toString(), 0, 100, false, false);
//        hpl.setFont(Font.font("Arial", 14));
//		link2Id.setGraphic(new ImageView (image1));
//        root.getChildren().addAll(hpl);
		
//		link2Id.set
	}
	
	
	private AnchorPane getDeepakAnchorPane() {
		AnchorPane link1Pane = null;
        try {
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("deepak.fxml"));
        	
//        	FXMLLoader loader = FXMLLoader.load(getClass().getResource("deepak.fxml"));
        	
        	link1Pane = loader.load();
        	
//        	link1Pane = FXMLLoader.load(getClass().getResource("deepak.fxml"));
        	
//        	link1Pane.getC
        	
        	DeepakController dc = (DeepakController)loader.getController();
//        	dc.initData("Some value to pass......");
        	dc.initData(managmentLinkId);
        	
        	
        	
        	
        } catch (IOException ex) {
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return link1Pane;
    }
	
	
	private void setNode(Node node) {
//		System.out.println("-----contenPanetId------->"+contenPaneId);
//		System.out.println("-----contenPanetId.getChildren()------->"+contenPaneId.getChildren());
		
//		ScrollPane s = null;
//		s.getContent().get
		
		if(contenPaneId.getChildren().contains(node)) {
			
		}
		else {
			contenPaneId.getChildren().clear();
			contenPaneId.getChildren().add((Node) node);
		}
		
		
	}
	
	AnchorPane link1Pane = null;
	
	private AnchorPane getAnchorPane() {
        try {
        	if( link1Pane == null )
        		link1Pane = FXMLLoader.load(getClass().getResource("link1.fxml"));
        } catch (IOException ex) {
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return link1Pane;
    }

}
