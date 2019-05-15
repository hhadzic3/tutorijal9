package ba.unsa.etf.rs.tutorijal8;

public class Bus {
    private int id;
    private String proizvodjac;
    private String serija;
    private int numberOfSeats;
    private int numberOfDrivers;

    public Bus(String iveco, String serija, int i) {
    }

    public Bus(String proizvodjac, String serija, int numberOfSeats, int numberOfDrivers) {
        this.id = id;
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDrivers = numberOfDrivers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getSerija() {
        return serija;
    }

    public void setSerija(String serija) {
        this.serija = serija;
    }

    public int getSeatNumber() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfDrivers() {
        return numberOfDrivers;
    }

    public void setNumberOfDrivers(int numberOfDrivers) {
        this.numberOfDrivers = numberOfDrivers;
    }

}


