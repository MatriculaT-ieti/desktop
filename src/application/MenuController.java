package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MenuController implements Initializable {

	@FXML
	private void handleClose(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	private void handleCyclesScreen(ActionEvent event) {
		AnchorPane root;
		
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("cyclesScreen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.escenario.setScene(scene);
			Main.escenario.setTitle("Cycles Screen");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleAddCyclesScreen(ActionEvent event) {
		AnchorPane root;
		
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("addCyclesScreen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.escenario.setScene(scene);
			Main.escenario.setTitle("Cycles Screen");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
