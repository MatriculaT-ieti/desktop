package application;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateCyclesScreenController {
	
	public static Stage modules;

    @FXML
    private TextField codi_cicle_formatiu;
    
    @FXML
    private TextField nom_cicle_formatiu;
    
    @FXML
    private TextField codi_adaptacio_curricular;
    
    @FXML
    private TextField hores_cicle_formatiu;
    
    @FXML
    private TextField data_inici_cicle_formatiu;
    
    @FXML
    private TextField data_fi_cicle_formatiu;
       
    @FXML
    private static ListView<String> module_list;
            
	@FXML
	private void handleClose(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	private void handleReturnMenu(ActionEvent event) {
		AnchorPane root;

		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("createCyclesScreen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.escenario.setScene(scene);
			Main.escenario.setTitle("Menu");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void handleCreateCycle(ActionEvent event) {
		JSONObject cycle = new JSONObject();
		
		try {
			cycle.put("codi_cicle_formatiu", codi_cicle_formatiu.getText());
			cycle.put("nom_cicle_formatiu", nom_cicle_formatiu.getText());
			cycle.put("codi_adaptacio_curricular", codi_adaptacio_curricular.getText());
			cycle.put("hores_cicle_formatiu", hores_cicle_formatiu.getText());
			cycle.put("data_inici_cicle_formatiu", data_inici_cicle_formatiu.getText());
			cycle.put("data_fi_cicle_formatiu", data_fi_cicle_formatiu.getText());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println(cycle.toString());
		
    }
	
    @FXML
    void handleCreateModuleScreen(ActionEvent event) {
    	AnchorPane root;

		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("createModulesScreen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			modules = new Stage();
			modules.setScene(scene);
			modules.initStyle(StageStyle.TRANSPARENT);

			modules.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static ListView<String> getListView() {
    	return module_list;
    }
    
}
