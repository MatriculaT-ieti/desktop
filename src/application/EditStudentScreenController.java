package application;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import entity.StudentImport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class EditStudentScreenController implements Initializable {
	
	@FXML
	private TextField idName;
	@FXML
	private TextField idPrimerApellido;
	@FXML
	private TextField idSegundoApellido;
	@FXML
	private TextField idTelefono;
	@FXML
	private TextField idCiclo;	
	
	public static StudentImport student;

	private String url = "https://matriculat-ieti.herokuapp.com";
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ViewStudensScreenController controllerViewStudent = new ViewStudensScreenController();
		JSONObject studentJSON = controllerViewStudent.studentSelected;
		
		student = new StudentImport();
		
		try {
			student.setConvocatioria(studentJSON.get("Convocatioria").toString());
			student.setCodi_solicitud(studentJSON.get("Codi_solicitud").toString());
			student.setTipus_solicitud(studentJSON.get("Tipus_solicitud").toString());
			student.setEstat_solicitud(studentJSON.get("Estat_solicitud").toString());
			student.setNom(studentJSON.get("Nom").toString());
			student.setPrimer_cognom(studentJSON.get("Primer Cognom").toString());
			student.setSegon_cognom(studentJSON.get("Segon Cognom").toString());
			student.setIdentificador_RALC(studentJSON.get("Identificador_RALC").toString());
			student.setTipus_alumne(studentJSON.get("Tipus_alumne").toString());
			student.setCodi_centre_p1(studentJSON.get("Codi_centre_p1").toString());
			student.setNom_centre_p1(studentJSON.get("nom_centre_p1").toString());
			student.setNaturalesa_centre_p1(studentJSON.get("naturalesa_centre_p1").toString());
			student.setMunicipi_centre_p1(studentJSON.get("municipi_centre_p1").toString());
			student.setSSTT_centre_p1(studentJSON.get("SSTT_centre_p1").toString());
			student.setCodi_ensenyament(studentJSON.get("codi_ensenyament").toString());
			student.setNom_ensenyament(studentJSON.get("cicle_formatiu").toString());
			student.setCodi_modalitat(studentJSON.get("codi_modalitat").toString());
			student.setModalitat(studentJSON.get("modalitat").toString());
			student.setCurs_p1(studentJSON.get("curs_p1").toString());
			student.setRegim_p1(studentJSON.get("regim_p1").toString());
			student.setTorn_p1(studentJSON.get("torn_p1").toString());
			student.setDni(studentJSON.get("DNI").toString());
			student.setNie(studentJSON.get("nie").toString());
			student.setPass(studentJSON.get("pass").toString());
			student.setTis(studentJSON.get("tis").toString());
			student.setData_naixament(studentJSON.get("data_naixament").toString());
			student.setSexe(studentJSON.get("sexe").toString());
			student.setNacionalitat(studentJSON.get("nacionalitat").toString());
			student.setPais_naixament(studentJSON.get("Pais Naixament").toString());
			student.setMunicipi_naixament(studentJSON.get("municipi_naixament").toString());
			student.setTipus_via(studentJSON.get("Tipus via").toString());
			student.setNom_via(studentJSON.get("Nom via").toString());
			student.setNumeros_via(studentJSON.get("Número via").toString());
			student.setAltres_dades(studentJSON.get("altres_dades").toString());
			student.setProvincia_residencia(studentJSON.get("provincia_residencia").toString());
			student.setMunicipi_residencia(studentJSON.get("Municipi residència").toString());
			student.setLocalitat_residencia(studentJSON.get("localitat_residencia").toString());
			student.setCp(studentJSON.get("cp").toString());
			student.setPais_residencia(studentJSON.get("pais_residencia").toString());
			student.setTelefon(studentJSON.get("Telèfon").toString());
			student.setCorreu_electronic(studentJSON.get("Correu electrònic").toString());
			student.setTipus_doc_tutor1(studentJSON.get("tipus_doc_tutor1").toString());
			student.setNum_doc_tutor1(studentJSON.get("num_doc_tutor1").toString());
			student.setNom_tutor1(studentJSON.get("nom_tutor1").toString());
			student.setPrimer_cognom_tutor1(studentJSON.get("primer_cognom_tutor1").toString());
			student.setSegon_cognom_tutor1(studentJSON.get("segon_cognom_tutor1").toString());
			student.setTipus_doc_tutor2(studentJSON.get("tipus_doc_tutor2").toString());
			student.setNum_doc_tutor2(studentJSON.get("num_doc_tutor2").toString());
			student.setNom_tutor2(studentJSON.get("nom_tutor2").toString());
			student.setPrimer_cognom_tutor2(studentJSON.get("primer_cognom_tutor2").toString());
			student.setSegon_cognom_tutor2(studentJSON.get("segon_cognom_tutor2").toString());
			student.setCodi_centre_proc(studentJSON.get("codi_centre_proc").toString());
			student.setNom_centre_proc(studentJSON.get("nom_centre_proc").toString());
			student.setCodi_ensenyament_proc(studentJSON.get("codi_ensenyament_proc").toString());
			student.setNom_ensenyament_proc(studentJSON.get("nom_ensenyament_proc").toString());
			student.setCurs_proc(studentJSON.get("curs_proc").toString());
			student.setLlengua_enten(studentJSON.get("llengua_enten").toString());
			student.setReligio(studentJSON.get("religio").toString());
			student.setCentre_asignat(studentJSON.get("centre_asignat").toString());
			
			idName.setText(student.getNom());
			idPrimerApellido.setText(student.getPrimer_cognom());
			idSegundoApellido.setText(student.getSegon_cognom());
			idTelefono.setText(student.getTelefon());
			idCiclo.setText(student.getNom_ensenyament());
			
			
		} catch (JSONException e) {	
			e.printStackTrace();
		}		
	}
	
	@FXML
	private void editStudent(ActionEvent event) {
		
		System.out.println("hola");
		
		student.setNom(idName.getText());
		student.setPrimer_cognom(idPrimerApellido.getText());
		student.setSegon_cognom(idSegundoApellido.getText());
		student.setTelefon(idTelefono.getText());
		student.setNom_ensenyament(idCiclo.getText());
		
		Gson gson = new Gson();
		String JSON = gson.toJson(student);
		System.out.println(JSON);
		
		URL obj;
		try {
			obj = new URL("https://matriculat-ieti.herokuapp.com/api/db/student/update?email="+student.getCorreu_electronic());
			
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
						
			OutputStream os = con.getOutputStream();
			
			os.write(JSON.getBytes("UTF-8"));
			os.close();
			
			con.getInputStream();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CORRECTO");
			alert.setHeaderText("ALUMNO EDITADO");
			alert.setContentText("Alumno editado con exito en la BBDD");

			alert.showAndWait();
			
		} catch (MalformedURLException e) {
			System.err.println("Error en la URL al importar.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
