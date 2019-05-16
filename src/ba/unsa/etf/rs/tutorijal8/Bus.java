package ba.unsa.etf.rs.tutorijal8;

public class Bus {
    private int id;
    private String proizvodjac;
    private String serija;
    private int numberOfSeats;
    private int numberOfDrivers;
    private Driver FirstDriver = null;
    private Driver SecondDriver = null;

    public void setFirstDriver(Driver firstDriver) {
        FirstDriver = firstDriver;
    }

    public void setSecondDriver(Driver secondDriver) {
        SecondDriver = secondDriver;
    }

    public Bus(){ }

    public Bus(String proizvodjac, String serija, int numberOfSeats) {
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
    }

    public Bus( int Id, String proizvodjac, String serija, int numberOfSeats, int numberOfDrivers) {
        id = Id;
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDrivers = numberOfDrivers;
    }
   public Bus( int Id, String proizvodjac, String serija, int numberOfSeats, int numberOfDrivers , Driver firstDriver , Driver secondDriver) {
        id = Id;
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDrivers = numberOfDrivers;
        FirstDriver = firstDriver;
        SecondDriver = secondDriver;
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

    public Driver getDriverOne() {
       return FirstDriver;
    }

    public Driver getDriverTwo() {
        return SecondDriver;
    }

    @Override
    public String toString() {
        String ispisBusa = "";
        ispisBusa += this.proizvodjac + " " + this.serija + " ( seats: " + this.getSeatNumber() + " )";
        if (FirstDriver != null) {
            ispisBusa += FirstDriver.toString();
        }
        if (SecondDriver != null) {
            ispisBusa += SecondDriver.toString();
        }
        return ispisBusa;
    }
}


