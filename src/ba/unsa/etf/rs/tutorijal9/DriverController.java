package ba.unsa.etf.rs.tutorijal9;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DriverController {
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldJMBG;
    private Driver driver;

    public DriverController() { }

    @FXML
    public void initialize() {
        if (driver != null) {
            fldIme.setText(driver.getName());
            fldPrezime.setText(driver.getPrezime());
            fldJMBG.setText(driver.getJMB());
        }
    }

    public void akcijaCancel(ActionEvent actionEvent) {
        driver = null;
        Stage stage = (Stage) fldIme.getScene().getWindow();
        stage.close();
    }

    public void akcijaOk(ActionEvent actionEvent) {
        if (driver == null) driver = new Driver();
        driver.setIme(fldIme.getText());
        driver.setPrezime(fldPrezime.getText());
        Stage stage = (Stage) fldIme.getScene().getWindow();
        stage.close();
    }

    public Driver getDriver() {
        return driver;
    }
}
