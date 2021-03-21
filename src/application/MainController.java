package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	double x = 0;
	double y = 0;
		
	@FXML
	private void dragged(MouseEvent event) {	
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		
		stage.setX(event.getSceneX() - x);
		stage.setY(event.getSceneY() - y);
	}
	
	@FXML
	private void pressed(MouseEvent event) {
		x = event.getSceneX();
		y = event.getSceneY();
	}
	
	@FXML
	private void handleClose(ActionEvent event) {
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
