package ba.unsa.etf.rs.tutorijal9;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class GlavniController {
    public TableView<Driver> tabelaDriver;
    public TableColumn imeDrivera;
    public TableColumn prezimeDrivera;
    public TableView<Bus> tabelaBus;
    public TableColumn makerBus;
    public TableColumn serijaBus;
    private TransportDAO dao;
    private ObservableList<Driver> listDrivera;
    private ObservableList<Bus> listBusses;


    public GlavniController() {
        dao = TransportDAO.getInstance();
        listDrivera = FXCollections.observableArrayList(dao.getDrivers());
        listBusses = FXCollections.observableArrayList(dao.getBusses());
    }

    @FXML
    public void initialize() {
        tabelaDriver.setItems(listDrivera);
        tabelaBus.setItems(listBusses);
        //idDrivera.setCellValueFactory(new PropertyValueFactory("id"));
        imeDrivera.setCellValueFactory(new PropertyValueFactory("ime"));
        prezimeDrivera.setCellValueFactory(new PropertyValueFactory("prezime"));
        makerBus.setCellValueFactory(new PropertyValueFactory("proizvodjac"));
        serijaBus.setCellValueFactory(new PropertyValueFactory("serija"));
    }



    // Metoda za potrebe testova, vraća bazu u polazno stanje
    public void resetujBazu() {
        TransportDAO.removeInstance();
        File dbfile = new File("Baza.db");
        dbfile.delete();
        dao = TransportDAO.getInstance();
    }


    public void dodajVozaca(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/driver.fxml"));
            DriverController driverController = new DriverController();
            loader.setController(driverController);
            root = loader.load();
            stage.setTitle("Drivers");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Driver driva = driverController.getDriver();
                if (driva != null) {
                    dao.addDriver(driva);
                    listDrivera.setAll(dao.getDrivers());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void dodajBus(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/drzava.fxml"));
            BusController busController = new BusController();
            loader.setController(busController);
            root = loader.load();
            stage.setTitle("Bus");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Bus bus = busController.getBus();
                if (bus != null) {
                    dao.addBus(bus);
                    listBusses.setAll(dao.getBusses());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void obrisiVozaca(ActionEvent actionEvent) {
        Driver vozac = tabelaDriver.getSelectionModel().getSelectedItem();
        if (vozac == null) return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrda brisanja");
        alert.setHeaderText("Brisanje vozaca "+vozac.getName());
        alert.setContentText("Da li ste sigurni da želite obrisati vozaca " +vozac.getName()+"?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dao.deleteDriver(vozac);
            listDrivera.setAll(dao.getDrivers());
        }
    }

    public void obrisiBus(ActionEvent actionEvent) {
        Bus bus = tabelaBus.getSelectionModel().getSelectedItem();
        if (bus == null) return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrda brisanja");
        alert.setHeaderText("Brisanje grada "+bus.getMaker());
        alert.setContentText("Da li ste sigurni da želite obrisati bus " +bus.getMaker()+"?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dao.deleteBus(bus);
            listBusses.setAll(dao.getBusses());
        }
    }

}
