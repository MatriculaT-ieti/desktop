package application;

import org.json.JSONException;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateModulesScreenController {

    @FXML
    private TextField codi_modul;
    
    @FXML
    private TextField nom_modul;

    @FXML
    private TextField durada_minima_modul;
    
    @FXML
    private TextField durada_maxima_modul;

    @FXML
    private TextField data_inici_modul;
    
    @FXML
    private TextField data_fi_modul;
	
	@FXML
	private void handleClose(ActionEvent event) {
		CreateCyclesScreenController.modules.close();
	}
	
	@FXML
    void handleCreateModule(ActionEvent event) {
		JSONObject module = new JSONObject();
		
		try {
			module.put("codi_modul", checkEntry(codi_modul));
			module.put("nom_modul", checkEntry(nom_modul));
			module.put("durada_minima_modul", checkEntry(durada_minima_modul));
			module.put("durada_maxima_modul", checkEntry(durada_maxima_modul));
			module.put("data_inici_modul", checkEntry(data_inici_modul));
			module.put("data_fi_modul", checkEntry(data_fi_modul));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		if (CreateCyclesScreenController.getListView() != null) {
			CreateCyclesScreenController.getListView().getItems().add(checkEntry(nom_modul));

		}
		CreateCyclesScreenController.modules.close();
		
    }
	
	
	private String checkEntry(TextField input) {
		return input == null ? "" : input.getText();
	}
	
}
