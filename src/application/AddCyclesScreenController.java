package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.net.ssl.HttpsURLConnection;

import entity.Cycle;
import entity.Modulo;
import entity.Unit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class AddCyclesScreenController implements Initializable {
	
	private String url = "https://matriculat-ieti.herokuapp.com";
	
	private ArrayList<Cycle> cycles;
	
	@FXML
	private TableView table;
	
	@FXML
	private Button idFolder;

	@FXML
	private Label fileLable;
	
    @FXML
    private TableView<Cycle> tableid;
    
    @FXML
    private TableColumn<Cycle, String> codigoCicloId;

    @FXML
    private TableColumn<Cycle, String> nombreCicloId;

    @FXML
    private TableColumn<Cycle, String> adaptationCurrId;
    
    @FXML
    private TableColumn<Cycle, String> horasTotalId;

    @FXML
    private TableColumn<Cycle, String> startDateId;

    @FXML
    private TableColumn<Cycle, String> finalDateId;

	@FXML
	private void handleClose(ActionEvent event) {
		System.exit(0);
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
	private void searchFolder(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Archivo Cursos");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		// Obtener la imagen seleccionada
		File file = fileChooser.showOpenDialog(null);	
		
		ArrayList<String[]> lines = new ArrayList<>();
		
		cycles = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
			while (br.ready()) {
				lines.add(br.readLine().replaceAll("\"+", "").split(","));
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha seleccionado ningun archivo o bien el archivo seleccionado no tiene un formato correcto.");
		} catch (NullPointerException e) {
			System.out.println("No se ha seleccionado ningun archivo.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		int c = -1;
		int m = -1;
		
		// Recorrer todos los ciclos
		for (int i = 0; i < lines.size() - 1; i++) {
			// Si no se repite el ciclo agregarlo.
			if (!lines.get(i)[0].equals(lines.get(i + 1)[0])) {
				m = -1;
				// Agregar el ciclo y su modulo
				if (i == 0) {
					c += 1;
					m += 1;
					cycles.add(new Cycle(lines.get(i + 1)[0], lines.get(i + 1)[1], lines.get(i + 1)[2], lines.get(i + 1)[3], lines.get(i + 1)[4], lines.get(i + 1)[5], new ArrayList<>()));
					cycles.get(c).getModuleList().add(new Modulo(lines.get(i + 1)[6], lines.get(i + 1)[7], lines.get(i + 1)[8], lines.get(i + 1)[9], lines.get(i + 1)[10], lines.get(i + 1)[11], new ArrayList<>()));
					cycles.get(c).getModuleList().get(m).getUnitList().add(new Unit(lines.get(i + 1)[12], lines.get(i + 1)[13], lines.get(i + 1)[14], lines.get(i + 1)[15], lines.get(i + 1)[16], lines.get(i + 1)[17], lines.get(i + 1)[18]));
				} else {
					c += 1;
					m += 1;
					cycles.add(new Cycle(lines.get(i)[0], lines.get(i)[1], lines.get(i)[2], lines.get(i)[3], lines.get(i)[4], lines.get(i)[5], new ArrayList<>()));
					cycles.get(c).getModuleList().add(new Modulo(lines.get(i)[6], lines.get(i)[7], lines.get(i)[8], lines.get(i)[9], lines.get(i)[10], lines.get(i)[11], new ArrayList<>()));
					cycles.get(c).getModuleList().get(m).getUnitList().add(new Unit(lines.get(i)[12], lines.get(i)[13], lines.get(i)[14], lines.get(i)[15], lines.get(i)[16], lines.get(i)[17], lines.get(i)[18]));
				}
			} else {
				// En caso de que se repita el nombre del ciclo anterior agregar el modulo a la lista de modulos del ciclo actual
				if (cycles.size() > 0) {
					if (!cycles.get(c).getModuleList().get(m).getCode().equals(lines.get(i)[6])) {
						cycles.get(c).getModuleList().add(new Modulo(lines.get(i)[6], lines.get(i)[7], lines.get(i)[8], lines.get(i)[9], lines.get(i)[10], lines.get(i)[11], new ArrayList<>()));
						m += 1;
						cycles.get(c).getModuleList().get(m).getUnitList().add(new Unit(lines.get(i)[12], lines.get(i)[13], lines.get(i)[14], lines.get(i)[15], lines.get(i)[16], lines.get(i)[17], lines.get(i)[18]));
						
					} else {
						cycles.get(c).getModuleList().get(m).getUnitList().add(new Unit(lines.get(i)[12], lines.get(i)[13], lines.get(i)[14], lines.get(i)[15], lines.get(i)[16], lines.get(i)[17], lines.get(i)[18]));
					}
				}
			}
		}
		
		codigoCicloId.setCellValueFactory(new PropertyValueFactory<>("Code"));
		nombreCicloId.setCellValueFactory(new PropertyValueFactory<>("Name"));
		adaptationCurrId.setCellValueFactory(new PropertyValueFactory<>("AdapCurricularAdaptation"));
		horasTotalId.setCellValueFactory(new PropertyValueFactory<>("TotalHours"));
		startDateId.setCellValueFactory(new PropertyValueFactory<>("StartedDate"));
		finalDateId.setCellValueFactory(new PropertyValueFactory<>("FinalDate"));
		
		for (Cycle i : cycles) {
			tableid.getItems().add(i);
		}

	}
	
	@FXML
	private void addCycles(ActionEvent event) {
		URL obj;
		try {
			obj = new URL(url + "/api/db/cycle/import/");
			
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			
			System.out.println(obj);
			
			OutputStream os = con.getOutputStream();
			os.write(tableid.getSelectionModel().getSelectedItems().toString().replaceAll("'", "").getBytes("UTF-8"));
			os.close();
			
			System.out.println(tableid.getSelectionModel().getSelectedItems().toString().replaceAll("'", ""));
			
			con.getInputStream();
		} catch (MalformedURLException e) {
			System.err.println("Error en la URL al importar.");
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tableid.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
}
