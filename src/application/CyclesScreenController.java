package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.internal.$Gson$Types;

import java.util.*;

import ca.fuzzlesoft.JsonParse;
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
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

public class CyclesScreenController implements Initializable {

	private String url = "https://matriculat-ieti.herokuapp.com";
	
	private static ArrayList<Cycle> cycleArray;

	@FXML
	private Button idFolder;

	@FXML
	private ChoiceBox<String> cycleList;

	@FXML
	private Label fileLable;

	@FXML
	private Accordion accordionId;

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
	private void handleSelectCyle() {
		
		accordionId.getPanes().clear();
		
		String nameCycleSelected = cycleList.getValue();
		
		if(nameCycleSelected.length() > 0) {
			
			Cycle cycle = getCycle(nameCycleSelected);
			
			if(cycle != null) {
				
				for (int i = 0; i < cycle.getModuleList().size(); i++) {
					
					Modulo module = cycle.getModuleList().get(i);
					
					AnchorPane anchorPane = new AnchorPane();
					
					TitledPane nameModul = new TitledPane();
					nameModul.setText(module.getName());
					
					ListView<String> unitList = new ListView<String>();
					
					for (int j = 0; j < module.getUnitList().size(); j++) {
						
						Unit unit = module.getUnitList().get(j);
						
						unitList.getItems().add(unit.getName());
						
					}

					AnchorPane.setTopAnchor(unitList, 00.0);
				    AnchorPane.setLeftAnchor(unitList, 00.0);
				    AnchorPane.setRightAnchor(unitList, 00.0);
				    //Cambiar esto si hay muchos
				    AnchorPane.setBottomAnchor(unitList, 00.0);
					anchorPane.getChildren().add(unitList);
					nameModul.setContent(anchorPane);
					accordionId.getPanes().add(nameModul);
					
				}
				
			}else {
				System.out.println("No se ha encontrado");
			}
			
		}else {
			System.out.println("No ha seleccionado ninguno");
		}
		
	}

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
	
	public Cycle getCycle(String cycleName) {
		
		Cycle cycle = null;
		
		for (Cycle c : cycleArray) {
			
			if(c.getName().equalsIgnoreCase(cycleName)) {
				
				cycle = c;
				
			}			
		}		
		return cycle;		
	}
	
}
