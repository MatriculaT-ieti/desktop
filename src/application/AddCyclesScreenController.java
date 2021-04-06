package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import entity.Cycle;
import entity.Modulo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class AddCyclesScreenController implements Initializable {
	
	@FXML
	private TableView table;
	
	@FXML
	private Button idFolder;

	@FXML
	private Label fileLable;

	@FXML
	private void handleClose(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	private void handleReturnMenu(ActionEvent event) {
		AnchorPane root;
		
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("menu.fxml"));
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
	private void searchFolder(ActionEvent event) throws IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Archivo Cursos");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		// Obtener la imagen seleccionada
		File file = fileChooser.showOpenDialog(null);		

		// Mostar la imagen
		if (file != null) {
			
			fileLable.setText(file.getName());
			
			BufferedReader input = new BufferedReader(new FileReader(file));
			
			String line;
			String field;
			
			ArrayList<Cycle> cyclesList = new ArrayList<Cycle>();
			
			ArrayList<String> columnas = new ArrayList<String>();
			
			input.readLine();
			
			while((line = input.readLine()) != null) {
				
				Cycle cycle = new Cycle();
				
				int lineLength = line.length();
				int intAux = 0;
				
				String[] cycleString = line.split(",");
				
				for(int i = 0; i < cycleString.length; i ++) {
					if(i < 6) {
						if(i == 0) {cycle.setCode(cycleString[i]);}
						if(i == 1) {cycle.setName(cycleString[i]);}
						if(i == 2) {cycle.setAdapCurricularAdaptation(cycleString[i]);}
						if(i == 3) {cycle.setTotalHours(cycleString[i]);}
						if(i == 4) {cycle.setStartedDate(cycleString[i]);}
						if(i == 5) {cycle.setFinalDate(cycleString[i]);}
					}
					if(i >= 6 && i < 12) {
						//if(i == 6) {Modulo.setCode(cycleString[i]);}
						if(i == 7) {cycle.setName(cycleString[i]);}
						if(i == 8) {cycle.setAdapCurricularAdaptation(cycleString[i]);}
						if(i == 9) {cycle.setTotalHours(cycleString[i]);}
						if(i == 10) {cycle.setStartedDate(cycleString[i]);}
						if(i == 11) {cycle.setFinalDate(cycleString[i]);}
					}
				}			
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
