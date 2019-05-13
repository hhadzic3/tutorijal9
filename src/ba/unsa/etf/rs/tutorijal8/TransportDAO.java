package ba.unsa.etf.rs.tutorijal8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TransportDAO {
    //konekcija na bazu!!

   private Connection conn;
    private static PreparedStatement dajVozaceUpit,dajBusUpit, addDriver , obrisiBusUpit , dodajBusUpit ,obrisiDriverUpit ,odrediIdBusaUpit;


    private static TransportDAO instance;
    private Driver driver;



    public static TransportDAO getInstance() {
        if(instance == null) instance = new TransportDAO();
        return instance;
    }

    private TransportDAO(){
        try {
            conn = DriverManager.getConnection("jdbc:sqllite:Baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            dajVozaceUpit = conn.prepareStatement("SELECT * FROM Vozac;");
            obrisiBusUpit = conn.prepareStatement("DELETE FROM Bus WHERE bus_id=?");
            obrisiDriverUpit = conn.prepareStatement("DELETE FROM Vozac WHERE vozac_id=?");
            addDriver = conn.prepareStatement("insert into Vozac values(?,?,?,?,?,?)");
            dajBusUpit = conn.prepareStatement("SELECT * FROM Bus");
            dodajBusUpit = conn.prepareStatement("INSERT INTO Bus VALUES(?,?,?,?,?)");
            odrediIdBusaUpit = conn.prepareStatement("SELECT MAX(bus_id)+1 FROM Bus");

        } catch (SQLException e) {
            resetDatabase();
            e.printStackTrace();
        }
    }
    //Rjesavamo slucaj ukoliko baza nije kreirana!
    public void resetDatabase() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("Baza.db.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()){
                sqlUpit += ulaz.nextLine();
                if (sqlUpit.charAt(sqlUpit.length() - 1 ) == ';'){
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ulaz.close();
    }

    public void addDriver(Driver driver){
        int id = 0;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT max(vozac_id)+1 from Vozac");
            if(resultSet.next()){
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {

        }
        this.driver.setId(id);

        try {
            addDriver.setInt(1,id);
            addDriver.setString(2, this.driver.getIme());
            addDriver.setString(3, this.driver.getPrezime());
            addDriver.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public ArrayList<Driver> getDrivers() {
        ArrayList<Driver> drivers = new ArrayList<Driver>();

        ResultSet result = null;
        try {
            result = dajVozaceUpit.executeQuery();
            Driver driver;
            while (  ( driver = dajVozaceUpit(result) ) != null  ){
                drivers.add(driver);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drivers;
    }

    private Driver dajVozaceUpit(ResultSet result) {
        Driver driver = null;
        try {
            if (result.next() ){
                int id = result.getInt("vozac_id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                int jmb = result.getInt("JMB");
                Date rodjendan = result.getDate("datm_rodjenja");
                Date datum_zap = result.getDate("datm_zaposljenja");

                driver = new Driver(id , name , surname , jmb , rodjendan , datum_zap);
                driver.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }


    public void addBus(Bus bus) {
        try {
            ResultSet rs = odrediIdBusaUpit.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            dodajBusUpit.setInt(1, id);
            dodajBusUpit.setString(2, bus.getProizvodjac());
            dodajBusUpit.setString(3, bus.getSerija());
            dodajBusUpit.setInt(4, bus.getNumberOfSeats());
            dodajBusUpit.setInt(5,bus.getNumberOfDrivers());
            dodajBusUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public ArrayList<Bus> getBusses() {
        ArrayList<Bus> busevi = new ArrayList<Bus>();

        ResultSet result = null;
        try {
            result = dajBusUpit.executeQuery();
            Bus bus;
            while (  ( bus = dajBusUpit(result) ) != null  ){
                busevi.add(bus);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return busevi;
    }

    private Bus dajBusUpit(ResultSet result) {
        Bus bus = null;
        try {
            if (result.next() ){
                int id = result.getInt("bus_id");
                String proizvodjac = result.getString("proizvodjac");
                String serija = result.getString("serija");
                int brojSjedista = result.getInt("broj_sjedista");
                int brojVozaca = result.getInt("broj_vozaca");

                bus = new Bus(id , proizvodjac , serija , brojSjedista , brojVozaca);
                bus.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bus;
    }


    public void deleteBus(Bus bus) {
        try {
            obrisiBusUpit.setInt(1, bus.getId());
            obrisiBusUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteDriver(Driver driver) {
        try {
            obrisiDriverUpit.setInt(1, driver.getId());
            obrisiDriverUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
