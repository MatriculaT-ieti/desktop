package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import entity.RequirementProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class createRequerimentProfileCrontroller implements Initializable {
	
	private static boolean addRequest;
	
	@FXML
	private TextField idName, idRequest1, idRequest2, idRequest3, idRequest4, idRequest5, idRequest6;
	
	@FXML
	private TextArea idDescription;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		addRequest = false;
		
	}
	
	@FXML
	private void handleClose(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	private void handleReturnMenu(ActionEvent event) {
		AnchorPane root;

		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.escenario.setScene(scene);
			Main.escenario.setTitle("Menu");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleAddNewProfile(ActionEvent event) {
		
		if(!idName.getText().isEmpty() && !idDescription.getText().isEmpty() && 
				(!idRequest1.getText().isEmpty() || !idRequest2.getText().isEmpty() || !idRequest3.getText().isEmpty())) {
			
			RequirementProfile profile = new RequirementProfile();
			
			System.out.println(idName.getText());
			String name = idName.getText().toString();
			profile.setName(name);
			String description = idDescription.getText();
			profile.setDescription(description);
			ArrayList<String> requirements = new ArrayList<String>();
			
			if(!addRequest) {
				if(!idRequest1.getText().isEmpty()) {requirements.add(idRequest1.getText());}
				if(!idRequest2.getText().isEmpty()) {requirements.add(idRequest2.getText());}
				if(!idRequest3.getText().isEmpty()) {requirements.add(idRequest3.getText());}
			}else {
				if(!idRequest1.getText().isEmpty()) {requirements.add(idRequest1.getText());}
				if(!idRequest2.getText().isEmpty()) {requirements.add(idRequest2.getText());}
				if(!idRequest3.getText().isEmpty()) {requirements.add(idRequest3.getText());}
				if(!idRequest4.getText().isEmpty()) {requirements.add(idRequest4.getText());}
				if(!idRequest5.getText().isEmpty()) {requirements.add(idRequest5.getText());}
				if(!idRequest6.getText().isEmpty()) {requirements.add(idRequest6.getText());}
			}
			profile.setRequiriment(requirements);
			
			Gson gson = new Gson();
			String JSON = gson.toJson(profile);
			System.out.println(profile);
			System.out.println(JSON);
			
		}else {
		
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("CAMPOS INSUFICIENTES");
			alert.setContentText("No has introducido datos suficientes. (TITULO, DESCRIPCION y MINIMO UN REQUISITO, OBLIGATORIO) ");

			alert.showAndWait();
			
		}
	}
	
	@FXML
	private void handleUnlockRequirements(ActionEvent event) {
		
		addRequest = true;
		
		idRequest4.setDisable(false);
		idRequest5.setDisable(false);
		idRequest6.setDisable(false);
		
	}
}
