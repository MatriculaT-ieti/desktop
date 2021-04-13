package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;
import entity.Cycle;
import entity.Modulo;
import entity.RequirementProfile;
import entity.Student;
import entity.StudentImport;
import entity.Unit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class AddStudentsScreenController implements Initializable {
	
	private String url = "https://matriculat-ieti.herokuapp.com";
	
	private static ArrayList<StudentImport> studentsList;
	private static ArrayList<String> studentListJSON;
	
	 @FXML
	 private TableView<StudentImport> tableid;
	 
	 @FXML
	 private TableColumn<StudentImport, String> idConvocatoria;
	 @FXML
	 private TableColumn<StudentImport, String> idCodiSolicitud;
	 @FXML
	 private TableColumn<StudentImport, String> idTipusSolicitud;
	 @FXML
	 private TableColumn<StudentImport, String> idEstatSolicitud;
	 @FXML
	 private TableColumn<StudentImport, String> idNom;
	 @FXML
	 private TableColumn<StudentImport, String> idPrimerCognom;
	 @FXML
	 private TableColumn<StudentImport, String> idSegonCognom;
	 @FXML
	 private TableColumn<StudentImport, String> idIdentificadorRalc;
	 @FXML
	 private TableColumn<StudentImport, String> idTipusAlumne;
	 @FXML
	 private TableColumn<StudentImport, String> idCodiCentreP1;
	 @FXML
	 private TableColumn<StudentImport, String> idNomCentreP1;
	 @FXML
	 private TableColumn<StudentImport, String> idNaturalesaCentreP1;
	 @FXML
	 private TableColumn<StudentImport, String> idMunicipiCentreP1;
	 @FXML
	 private TableColumn<StudentImport, String> idSsttCentreP1;
	 @FXML
	 private TableColumn<StudentImport, String> idCodiEnsenyamentP1;
	 @FXML
	 private TableColumn<StudentImport, String> idNomEnsenyament;
	 @FXML
	 private TableColumn<StudentImport, String> idCodiModalitat;
	 @FXML
	 private TableColumn<StudentImport, String> idModalitat;
	 @FXML
	 private TableColumn<StudentImport, String> idCursP1;
	 @FXML
	 private TableColumn<StudentImport, String> idRegimP1;
	 @FXML
	 private TableColumn<StudentImport, String> idTornP1;
	 @FXML
	 private TableColumn<StudentImport, String> idDni;
	 @FXML
	 private TableColumn<StudentImport, String> idNie;
	 @FXML
	 private TableColumn<StudentImport, String> idPass;
	 @FXML
	 private TableColumn<StudentImport, String> idTis;
	 @FXML
	 private TableColumn<StudentImport, String> idDataNaixement;
	 @FXML
	 private TableColumn<StudentImport, String> idSexe;
	 @FXML
	 private TableColumn<StudentImport, String> idNacionalitat;
	 @FXML
	 private TableColumn<StudentImport, String> idPaisNaixement;
	 @FXML
	 private TableColumn<StudentImport, String> idMunicipiNaixement;
	 @FXML
	 private TableColumn<StudentImport, String> idTipusVia;
	 @FXML
	 private TableColumn<StudentImport, String> idNomVia;
	 @FXML
	 private TableColumn<StudentImport, String> idNumeroVia;
	 @FXML
	 private TableColumn<StudentImport, String> idAltresDades; 
	 @FXML
	 private TableColumn<StudentImport, String> idProvinciaResidencia;
	 @FXML
	 private TableColumn<StudentImport, String> idMunicipiResidencia;
	 @FXML
	 private TableColumn<StudentImport, String> idLocalitatResidencia;
	 @FXML
	 private TableColumn<StudentImport, String> idCp;
	 @FXML
	 private TableColumn<StudentImport, String> idPaisResidencia; 
	 @FXML
	 private TableColumn<StudentImport, String> idTelefon;
	 @FXML
	 private TableColumn<StudentImport, String> idCorreuElectronic;
	 @FXML
	 private TableColumn<StudentImport, String> idTipusDocTutor1;
	 @FXML
	 private TableColumn<StudentImport, String> idNumDocTutor1;
	 @FXML
	 private TableColumn<StudentImport, String> idNomTutor1;
	 @FXML
	 private TableColumn<StudentImport, String> idPrimerCognomTutor1;
	 @FXML
	 private TableColumn<StudentImport, String> idSegonCognomTutor1;
	 @FXML
	 private TableColumn<StudentImport, String> idTipusDocTutor2;
	 @FXML
	 private TableColumn<StudentImport, String> idNumDocTutor2;
	 @FXML
	 private TableColumn<StudentImport, String> idNomTutor2;
	 @FXML
	 private TableColumn<StudentImport, String> idPrimerCognomTutor2;
	 @FXML
	 private TableColumn<StudentImport, String> idSegonCognomTutor2;
	 @FXML
	 private TableColumn<StudentImport, String> idCodiCentreProc;
	 @FXML
	 private TableColumn<StudentImport, String> idNomCentreProc;
	 @FXML
	 private TableColumn<StudentImport, String> idCodiEnsenyamentProc;
	 @FXML
	 private TableColumn<StudentImport, String> idNomEnsenyamentProc;
	 @FXML
	 private TableColumn<StudentImport, String> idCursProc;
	 @FXML
	 private TableColumn<StudentImport, String> idLlenguaEnten;
	 @FXML
	 private TableColumn<StudentImport, String> idReligio;
	 @FXML
	 private TableColumn<StudentImport, String> idCentreAssignat;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tableid.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));
		
		studentsList = new ArrayList<StudentImport>();

		// Obtener la imagen seleccionada
		File file = fileChooser.showOpenDialog(null);	
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
			
			String line = null;
			int lines = (int) br.lines().count();
			for (int i = 1; i < lines; i++) {
				line = Files.readAllLines(Paths.get(file.getAbsolutePath())).get(i);
				String[] content = line.split(",");
			
				studentsList.add(new StudentImport(content[0],content[1],content[2],content[3],content[4],content[5],
						content[6],content[7],content[8],content[9],content[10],content[11],
						content[12],content[13],content[14],content[15],content[16],content[17],
						content[18],content[19],content[20],content[21],content[22],content[23],
						content[24],content[25],content[26],content[27],content[28],content[29],
						content[30],content[31],content[32],content[33],content[34],content[35],
						content[36],content[37],content[38],content[39],content[40],content[41],
						content[42],content[43],content[44],content[45],content[46],content[47],
						content[48],content[49],content[50],content[51],content[52],content[53],
						content[54],content[55],content[56],"",""));	
			}		
			br.close();
			
			idConvocatoria.setCellValueFactory(new PropertyValueFactory<>("Convocatioria"));
			idCodiSolicitud.setCellValueFactory(new PropertyValueFactory<>("Codi_solicitud"));
			idTipusSolicitud.setCellValueFactory(new PropertyValueFactory<>("Tipus_solicitud"));
			idEstatSolicitud.setCellValueFactory(new PropertyValueFactory<>("Estat_solicitud"));
			idNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
			idPrimerCognom.setCellValueFactory(new PropertyValueFactory<>("Primer_cognom"));
			idSegonCognom.setCellValueFactory(new PropertyValueFactory<>("Segon_cognom"));		
			idIdentificadorRalc.setCellValueFactory(new PropertyValueFactory<>("Identificador_RALC"));
			idTipusAlumne.setCellValueFactory(new PropertyValueFactory<>("Tipus_alumne"));
			idCodiCentreP1.setCellValueFactory(new PropertyValueFactory<>("Codi_centre_p1"));
			idNomCentreP1.setCellValueFactory(new PropertyValueFactory<>("nom_centre_p1"));
			idNaturalesaCentreP1.setCellValueFactory(new PropertyValueFactory<>("naturalesa_centre_p1"));
			idMunicipiCentreP1.setCellValueFactory(new PropertyValueFactory<>("municipi_centre_p1"));
			idSsttCentreP1.setCellValueFactory(new PropertyValueFactory<>("SSTT_centre_p1"));
			idCodiEnsenyamentP1.setCellValueFactory(new PropertyValueFactory<>("codi_ensenyament"));
			idNomEnsenyament.setCellValueFactory(new PropertyValueFactory<>("nom_ensenyament"));
			idCodiModalitat.setCellValueFactory(new PropertyValueFactory<>("codi_modalitat"));
			idModalitat.setCellValueFactory(new PropertyValueFactory<>("modalitat"));
			idCursP1.setCellValueFactory(new PropertyValueFactory<>("curs_p1"));
			idRegimP1.setCellValueFactory(new PropertyValueFactory<>("regim_p1"));
			idTornP1.setCellValueFactory(new PropertyValueFactory<>("torn_p1"));
			idDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
			idNie.setCellValueFactory(new PropertyValueFactory<>("nie"));
			idPass.setCellValueFactory(new PropertyValueFactory<>("pass"));
			idTis.setCellValueFactory(new PropertyValueFactory<>("tis"));
			idDataNaixement.setCellValueFactory(new PropertyValueFactory<>("data_naixament"));
			idSexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
			idNacionalitat.setCellValueFactory(new PropertyValueFactory<>("nacionalitat"));
			idPaisNaixement.setCellValueFactory(new PropertyValueFactory<>("pais_naixament"));
			idMunicipiNaixement.setCellValueFactory(new PropertyValueFactory<>("municipi_naixament"));
			idTipusVia.setCellValueFactory(new PropertyValueFactory<>("tipus_via"));
			idNomVia.setCellValueFactory(new PropertyValueFactory<>("nom_via"));
			idNumeroVia.setCellValueFactory(new PropertyValueFactory<>("numeros_via"));
			idAltresDades.setCellValueFactory(new PropertyValueFactory<>("altres_dades"));
			idProvinciaResidencia.setCellValueFactory(new PropertyValueFactory<>("provincia_residencia"));
			idMunicipiResidencia.setCellValueFactory(new PropertyValueFactory<>("municipi_residencia"));
			idLocalitatResidencia.setCellValueFactory(new PropertyValueFactory<>("localitat_residencia"));
			idCp.setCellValueFactory(new PropertyValueFactory<>("cp"));
			idPaisResidencia.setCellValueFactory(new PropertyValueFactory<>("pais_residencia"));
			idTelefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
			idCorreuElectronic.setCellValueFactory(new PropertyValueFactory<>("correu_electronic"));
			idTipusDocTutor1.setCellValueFactory(new PropertyValueFactory<>("tipus_doc_tutor1"));
			idNumDocTutor1.setCellValueFactory(new PropertyValueFactory<>("num_doc_tutor1"));
			idNomTutor1.setCellValueFactory(new PropertyValueFactory<>("nom_tutor1"));
			idPrimerCognomTutor1.setCellValueFactory(new PropertyValueFactory<>("primer_cognom_tutor1"));
			idSegonCognomTutor1.setCellValueFactory(new PropertyValueFactory<>("segon_cognom_tutor1"));
			idTipusDocTutor2.setCellValueFactory(new PropertyValueFactory<>("tipus_doc_tutor2"));
			idNumDocTutor2.setCellValueFactory(new PropertyValueFactory<>("num_doc_tutor2"));
			idNomTutor2.setCellValueFactory(new PropertyValueFactory<>("nom_tutor2"));
			idPrimerCognomTutor2.setCellValueFactory(new PropertyValueFactory<>("primer_cognom_tutor2"));
			idSegonCognomTutor2.setCellValueFactory(new PropertyValueFactory<>("segon_cognom_tutor2"));
			idCodiCentreProc.setCellValueFactory(new PropertyValueFactory<>("codi_centre_proc"));
			idNomCentreProc.setCellValueFactory(new PropertyValueFactory<>("nom_centre_proc"));
			idCodiEnsenyamentProc.setCellValueFactory(new PropertyValueFactory<>("codi_ensenyament_proc"));		
			idNomEnsenyamentProc.setCellValueFactory(new PropertyValueFactory<>("nom_ensenyament_proc"));
			idCursProc.setCellValueFactory(new PropertyValueFactory<>("curs_proc"));
			idLlenguaEnten.setCellValueFactory(new PropertyValueFactory<>("llengua_enten"));
			idReligio.setCellValueFactory(new PropertyValueFactory<>("religio"));
			idCentreAssignat.setCellValueFactory(new PropertyValueFactory<>("centre_asignat"));
			
			
			
			for (StudentImport studentImport : studentsList) {
				
				tableid.getItems().add(studentImport);
				

				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha seleccionado ningun archivo o bien el archivo seleccionado no tiene un formato correcto.");
		} catch (NullPointerException e) {
			System.out.println("No se ha seleccionado ningun archivo.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}	
	
	@FXML
	private void addStudent(ActionEvent event) {
		URL obj;
		try {
			obj = new URL(url + "/api/db/student/create");
			
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
						
			OutputStream os = con.getOutputStream();
			
			studentListJSON = new ArrayList<String>();
			
			for (StudentImport student : tableid.getSelectionModel().getSelectedItems()) {
				
				Gson gson = new Gson();
				String JSON = gson.toJson(student);
				studentListJSON.add(JSON);
				
			}
			
			System.out.println(studentListJSON.toString());
			
			os.write(studentListJSON.toString().getBytes("UTF-8"));
			os.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CORRECT");
			alert.setHeaderText("PERFIL CREADO");
			alert.setContentText("Perfil ha sido creado correctamente en la BBDD");

			alert.showAndWait();
			
			con.getInputStream();
		} catch (MalformedURLException e) {
			System.err.println("Error en la URL al importar.");
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}
