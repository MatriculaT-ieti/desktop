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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class CyclesScreenController implements Initializable {

	private String url = "https://matriculat-ieti.herokuapp.com";

	@FXML
	private Button idFolder;

	@FXML
	private ChoiceBox<Cycle> cycleList;

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

	/*
	 * @FXML private void searchFolder(ActionEvent event) { FileChooser fileChooser
	 * = new FileChooser(); fileChooser.setTitle("Buscar Archivo Cursos");
	 * 
	 * // Agregar filtros para facilitar la busqueda
	 * fileChooser.getExtensionFilters().addAll(new
	 * FileChooser.ExtensionFilter("CSV", "*.csv"));
	 * 
	 * // Obtener la imagen seleccionada File file =
	 * fileChooser.showOpenDialog(null);
	 * 
	 * // Mostar la imagen if (file != null) {
	 * 
	 * fileLable.setText(file.getName());
	 * 
	 * // Image image = new Image("file:" + imgFile.getAbsolutePath()); //
	 * ivImagen.setImage(image); } }
	 */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		String endPoint = "/api/db/cycles/read?filter={}";

		try {
			// InputStream con = new
			// URL("https://matriculat-ieti.herokuapp.com/api/db/cycles/read?range={%22from%22:0,%20%22to%22:1}").openStream();

			URL obj = new URL("https://matriculat-ieti.herokuapp.com/api/db/cycles/read?filter={}");
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// System.out.println(obj);

			//BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));

			BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	       	        
	        //Read JSON response and print
	        JSONArray array = new JSONArray(response.toString());

	        System.out.println(array.length());
	        
	        //JSONObject object = (JSONObject) array.get(1);
	        //System.out.println(object.get("codi_cicle_formatiu"));
        	//System.out.println(object);
	        
	        ArrayList<Cycle> cycleList = new ArrayList<Cycle>();
	        
	        for(int i = 0; i < array.length(); i ++) {
	        	
	        	JSONObject object = (JSONObject) array.get(i);
	        	
	        	Cycle cycle = new Cycle();
	        	cycle.setName(object.get("codi_cicle_formatiu").toString());
	        	
	        	ArrayList<Modulo> moduleList = new ArrayList<Modulo>();
	        	
	        	String inputLineModuls = object.get("moduls").toString();
		        StringBuffer responseModuls = new StringBuffer();
		        responseModuls.append(inputLineModuls);
	        	
	        	JSONArray arrayModuls = new JSONArray(response.toString());
	        	
	        	for(int j = 0; j < arrayModuls.length(); j ++) {
	        		
	        		JSONObject objectModule = (JSONObject) arrayModuls.get(j);
	        		
	        		System.out.println(objectModule);
	        		
	        		Modulo modulo = new Modulo();
	        		modulo.setName(objectModule.get("nom_modul").toString());
	        		
	        		ArrayList<Unit> unityList = new ArrayList<Unit>();
	        		
	        		String inputLineUnit = objectModule.get("unitats").toString();
			        StringBuffer responseUnit = new StringBuffer();
			        responseUnit.append(inputLineUnit);
	        		
	        		JSONArray arrayUnity = new JSONArray(responseUnit.toString());
	        		
	        		/*for(int x = 0; x < arrayUnity.length(); x ++) {
	        			
	        			JSONObject objectUnity = (JSONObject) arrayModuls.get(x);
	        			
	        			Unit unit = new Unit();
	        			unit.setName((objectUnity.get("nom_unitat_formativa").toString()));
	        			
	        			unityList.add(unit);
	        			
	        		}	*/
	        		moduleList.add(modulo);
	        	}
	        
	        	cycle.setModuleList(moduleList);
	        	cycleList.add(cycle); 
	        }
	        
	        System.out.println(cycleList.size());
	        
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

}
