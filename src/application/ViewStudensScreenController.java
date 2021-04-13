package application;

import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import entity.Cycle;
import entity.Modulo;
import entity.Student;
import entity.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ViewStudensScreenController implements Initializable {
	
	private static ArrayList<Cycle> cycleArray;
	private static ArrayList<Student> studentArray;
	
	@FXML
	private ChoiceBox<String> cycleList;
	
	@FXML
    private TableView<Student> idTableView;
    
    @FXML
    private TableColumn<Student, String> idColumnDni;

    @FXML
    private TableColumn<Student, String> idColumnName;

    @FXML
    private TableColumn<Student, String> idColumnFirstSurname;
    
    @FXML
    private TableColumn<Student, String> idColumnSecondSurname;

    @FXML
    private TableColumn<Student, String> idPhoneNumber;

    @FXML
    private TableColumn<Student, String> idMail;	
    
    @FXML
    private TableColumn<Student, String> idCountry;

    @FXML
    private TableColumn<Student, String> idDirection;	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String endPoint = "/api/db/cycles/read?filter={}";

		try {
			
			URL obj = new URL("https://matriculat-ieti.herokuapp.com/api/db/cycles/read?filter={}");
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			// Read JSON response and print
			JSONArray listCycles = new JSONArray(response.toString());

			System.out.println(listCycles.length());
			
			cycleArray = new ArrayList<Cycle>();
			
			for(int i = 0; i < listCycles.length(); i ++) {
				
				JSONObject cyle = listCycles.getJSONObject(i);
				
				Cycle cycleEntity = new Cycle();
				
				cycleEntity.setName(cyle.get("nom_cicle_formatiu").toString());
				
				ArrayList<Modulo> moduleList = new ArrayList<Modulo>();
				
				JSONArray listModuls = new JSONArray(cyle.getJSONArray("moduls").toString());
				
				for(int j = 0; j < listModuls.length(); j ++) {
					
					JSONObject modul = listModuls.getJSONObject(j);
					
					Modulo moduleEntity = new Modulo();
					
					moduleEntity.setName(modul.get("nom_modul").toString());
					
					ArrayList<Unit> unitiList = new ArrayList<Unit>();
					
					JSONArray listUnits = new JSONArray(modul.getJSONArray("unitats").toString());
					
					for(int x = 0; x < listUnits.length(); x ++) {
					
						JSONObject unit = listUnits.getJSONObject(x);
						
						Unit unitEntity = new Unit();
						
						unitEntity.setName(unit.get("nom_unitat_formativa").toString());
						
						unitiList.add(unitEntity);
						
					}	
					
					moduleEntity.setUnitList(unitiList);
					
					moduleList.add(moduleEntity);
					
				}			
				
				cycleEntity.setModuleList(moduleList);
				
				cycleArray.add(cycleEntity);
				
			}
			
			for (Cycle cycle2 : cycleArray) {

				cycleList.getItems().add(cycle2.getName());

			}
			in.close();
			con.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleSelectCycleGetStudens(ActionEvent event) {
		
		idTableView.getItems().clear();
		
		String cyleName = cycleList.getValue();

		try {

			String url ="https://matriculat-ieti.herokuapp.com/api/db/student/read?cicle_formatiu=" + cyleName.replaceAll("\\s+","%20");
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			// Read JSON response and print
			JSONArray listStudens = new JSONArray(response.toString());
			
			studentArray = new ArrayList<Student>();
			
			for(int i = 0; i < listStudens.length(); i ++) {
				
				JSONObject student = listStudens.getJSONObject(i);
				
				Student studentEntity = new Student();
				
				studentEntity.setDni(student.get("DNI").toString());
				studentEntity.setName(student.get("Nom").toString());
				studentEntity.setFirstSurname(student.get("Primer Cognom").toString());
				studentEntity.setSecondSurname(student.get("Segon Cognom").toString());
				studentEntity.setPhone(student.get("Telèfon").toString());
				studentEntity.setEmail(student.get("Correu electrònic").toString());
				studentEntity.setCountry(student.get("Pais Naixament").toString());
				
				studentEntity.setFullAdress(student.get("Tipus via").toString() + " " +
											student.get("Nom via").toString() + ", " + 
											student.get("Número via").toString() + ", " + 
											student.get("Municipi residència").toString());
				
				studentArray.add(studentEntity);
				
			}
			
			idColumnDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
			idColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
			idColumnFirstSurname.setCellValueFactory(new PropertyValueFactory<>("firstSurname"));
			idColumnSecondSurname.setCellValueFactory(new PropertyValueFactory<>("secondSurname"));
			idPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
			idMail.setCellValueFactory(new PropertyValueFactory<>("email"));
			idCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
			idDirection.setCellValueFactory(new PropertyValueFactory<>("fullAdress"));

			for (Student s : studentArray) {
				
				idTableView.getItems().add(s);
				
			}			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	private void handleGetStudentInfo(ActionEvent event) {
		
		
		
	}
	
	@FXML
	private void handleClose(ActionEvent event) {
		System.exit(0);
	}
}
