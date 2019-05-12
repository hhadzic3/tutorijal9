package ba.unsa.etf.rs.tutorijal8;

public class Bus {

    private String proizvodjac;
    private String serija;
    private int numberOfSeats;
    private int numberOfDrivers;

    public Bus() {
    }

    public Bus(String proizvodjac, String serija, int numberOfSeats, int numberOfDrivers) {
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDrivers = numberOfDrivers;
    }

    public String getProizvodjac() {
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

    public int getNumberOfSeats() {
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


