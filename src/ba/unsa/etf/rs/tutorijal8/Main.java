package ba.unsa.etf.rs.tutorijal8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        TransportDAO dao = TransportDAO.getInstance();
            /*try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace(); }

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqllite:Baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
