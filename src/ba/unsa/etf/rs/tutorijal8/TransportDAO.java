package ba.unsa.etf.rs.tutorijal8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.BitSet;
import java.util.Scanner;

public class TransportDAO {
    //konekcija na bazu!!
    private Connection conn;
    private PreparedStatement vozacUpit;

    private static TransportDAO instance;
    public static TransportDAO getInstance() {
        if(instance == null) instance = new TransportDAO();
        return instance;
    }

    private TransportDAO(){
        try {
            conn = DriverManager.getConnection("jdbc:sqllite:baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            vozacUpit = conn.prepareStatement("SELECT * FROM Vozac;");
        } catch (SQLException e) {
            regenerisiBazu();
            try {
                vozacUpit = conn.prepareStatement("SELECT * FROM Vozac;");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    //Rjesavamo slucaj ukoliko baza nije kreirana!
    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
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

    public void addDriver(){}

    public void getDrivers() {
    }

    public void addBus(Bus bus) {
    }

    public BitSet getBusses() {
    }

    public void deleteBus(Bus bus) {
    }

    public void resetDatabase() {
    }
}
