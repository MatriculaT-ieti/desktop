package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class CyclesScreenController implements Initializable {

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
	private void searchFolder(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Archivo Cursos");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		// Obtener la imagen seleccionada
		File file = fileChooser.showOpenDialog(null);

		// Mostar la imagen
		if (file != null) {
			
			fileLable.setText(file.getName());
			
			// Image image = new Image("file:" + imgFile.getAbsolutePath());
			// ivImagen.setImage(image);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
