package ba.unsa.etf.rs.tutorijal8;

import java.util.Date;

public class Driver {
    private String Ime;
    private String Prezime;
    private String JMB;
    private Date BirthDate;
    private Date WorkDate;


    public Driver() {
    }

    public Driver(String ime, String prezime, String JMB, Date birthDate, Date workDate) {
        Ime = ime;
        Prezime = prezime;
        this.JMB = JMB;
        BirthDate = birthDate;
        WorkDate = workDate;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public String getJMB() {
        return JMB;
    }

    public void setJMB(String JMB) {
        this.JMB = JMB;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public Date getWorkDate() {
        return WorkDate;
    }

    public void setWorkDate(Date workDate) {
        WorkDate = workDate;
    }
}
