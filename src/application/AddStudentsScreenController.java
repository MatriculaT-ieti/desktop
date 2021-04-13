package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Cycle;
import entity.Modulo;
import entity.RequirementProfile;
import entity.Student;
import entity.Unit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class AddStudentsScreenController implements Initializable {
	
	private ArrayList<RequirementProfile> cycles;
	
	 @FXML
	 private TableView<Student> tableid;
	 
	 @FXML
	 private TableColumn<Student, String> idConvocatoria, idCodiSolicitud, idTipusSolicitud, idEstatSolicitud, idNom, idPrimerCognom, idSegonCognom, idIdentificadorRalc, idTipusAlumne, 
	 idCodiCentreP1, idNomCentreP1, idNaturalesaCentreP1, idMunicipiCentreP1, idSsttCentreP1, idCodiEnsenyamentP1, idNomEnsenyament, idCodiModalitat, idModalitat, idCursP1, idRegimP1,
	 idTornP1, idDni, idNie, idPass, idTis, idDataNaixement, idSexe, idNacionalitat, idPaisNaixement, idMunicipiNaixement, idTipusVia, idNomVia, idNumeroVia, idAltresDades, idProvinciaResidencia,
	 idMunicipiResidencia, idLocalitatResidencia, idCp, idPaisResidencia, idTelefon, idCorreuElectronic, idTipusDocTutor1, idNumDocTutor1, idNomTutor1, idPrimerCognomTutor1, idSegonCognomTutor1,
	 idTipusDocTutor2, idNumDocTutor2, idNomTutor2, idPrimerCognomTutor2, idSegonCognomTutor2, idCodiCentreProc, idNomCentreProc, idCodiEnsenyamentProc, idNomEnsenyamentProc, idCursProc, idLlenguaEnten,
	 idReligio, idCentreAssignat;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
	private void searchFolder(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Archivo Cursos");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		// Obtener la imagen seleccionada
		File file = fileChooser.showOpenDialog(null);	
		
		ArrayList<String[]> lines = new ArrayList<>();
		
		cycles = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
			while (br.ready()) {
				lines.add(br.readLine().replaceAll("\"+", "").split(","));
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha seleccionado ningun archivo o bien el archivo seleccionado no tiene un formato correcto.");
		} catch (NullPointerException e) {
			System.out.println("No se ha seleccionado ningun archivo.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}	
}
