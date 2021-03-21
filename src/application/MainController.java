package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	String emailAdmin;
	String passAdmin;
	double x = 0;
	double y = 0;

	@FXML
	private TextField email;
	
	@FXML
	private TextField password;

	@FXML
	private void loginAdmin(ActionEvent event) {
		
		emailAdmin = email.getText();
		passAdmin = password.getText();
		
		if(email.getText().isEmpty() && password.getText().isEmpty()) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("CAMPOS INSUFICIENTES");
			alert.setContentText("Introduce un email y una contraseña");

			alert.showAndWait();
			
		}
		
		getToken(emailAdmin, passAdmin);
		
		AnchorPane root;
		
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("cyclesScreen.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.escenario.setScene(scene);
			Main.escenario.setTitle("Dos escenas--pagina 2");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
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
	
	private void getToken(String email, String password) {
		
		try {
			String url = "https://matriculat-ieti.herokuapp.com/admins";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("email", email);

			BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = bf.readLine()) != null) {
				response.append(inputLine);
			}
			bf.close();
			// print result
			System.out.println(response.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private boolean verifyAdmin(String email, String password) {
		
		boolean verify = false;
		
		return verify;
		
	}
}
