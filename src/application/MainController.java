package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javax.net.ssl.HttpsURLConnection;
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
	
	private String url = "https://matriculat-ieti.herokuapp.com";
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
			alert.setContentText("Introduce un email y una contrase" + 	"\u00f1" + "a");

			alert.showAndWait();
			
		}else {

			if(getToken(emailAdmin, passAdmin) != false) {
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
			}else {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("CAMPOS ERRONEOS");
				alert.setContentText("Email o contrase" + "\u00f1" +"a incorrectos");

				alert.showAndWait();
				
			}
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
	
	private boolean getToken(String email, String password) {
		
		boolean verify = false;
		String endPoint = "/api/login/admins";
		
		try {
			
			MessageDigest passEncrypt = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = passEncrypt.digest(password.getBytes(StandardCharsets.UTF_8));
			
			URL obj = new URL(url+endPoint+"?email="+email+"&password="+bytesToHex(encodedhash));
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			
			System.out.println(obj);

			BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();
			
			if (!(inputLine = bf.readLine()).equalsIgnoreCase("{\"token\":null}")) {
				
				System.out.println(inputLine);
				
				response.append(inputLine);
				verify = true;
			}
			
			bf.close();
			// print result
			//System.out.println(response.toString());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verify;
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	private boolean verifyAdmin(String email, String password) {
		
		boolean verify = false;
		
		return verify;
		
	}
}
