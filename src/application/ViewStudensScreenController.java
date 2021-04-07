package application;

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
import javafx.scene.layout.AnchorPane;

public class ViewStudensScreenController implements Initializable {
	
	private static ArrayList<Cycle> cycleArray;
	
	@FXML
	private ChoiceBox<String> cycleList;
	
	@FXML
	private ListView<String> idListView;
	
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
			
			ObservableList<String> cycleArrayList = FXCollections.observableList(new ArrayList<String>());

			for (Cycle cycle2 : cycleArray) {

				cycleList.getItems().add(cycle2.getName());

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
	public void handleSelectCycle(ActionEvent event) {
		
		idListView.getItems().clear();
		
		String cyleName = cycleList.getValue();

		try {
			
			URL obj = new URL("https://matriculat-ieti.herokuapp.com/api/db/student/import/cicle_formatiu="+cyleName);
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
			
			ObservableList<String> cycleArrayList = FXCollections.observableList(new ArrayList<String>());

			for (Cycle cycle2 : cycleArray) {

				cycleList.getItems().add(cycle2.getName());

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
	private void handleClose(ActionEvent event) {
		System.exit(0);
	}
}
