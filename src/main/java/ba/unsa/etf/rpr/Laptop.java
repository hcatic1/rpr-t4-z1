package ba.unsa.etf.rpr;

import java.io.Serializable;
import java.util.Objects;

public class Laptop implements Serializable {
    private String brend, model, procesor, grafickaKartica;
    private double cijena, velicinaEkrana;
    private int ram, hdd, ssd;


    public Laptop(String brend, String model, String procesor, String grafickaKartica, double cijena, double velicinaEkrana, int ram, int hdd, int ssd) {
        this.brend = brend;
        this.model = model;
        this.procesor = procesor;
        this.grafickaKartica = grafickaKartica;
        this.cijena = cijena;
        this.velicinaEkrana = velicinaEkrana;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
    }

    public Laptop(){};

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brend='" + brend + '\'' +
                ", model='" + model + '\'' +
                ", procesor='" + procesor + '\'' +
                ", grafickaKartica='" + grafickaKartica + '\'' +
                ", cijena=" + cijena +
                ", velicinaEkrana=" + velicinaEkrana +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", ssd=" + ssd +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Laptop laptop = (Laptop) obj;
        return this.toString().equals(laptop.toString());
    }
}