package ba.unsa.etf.rpr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoJSONFile implements LaptopDao{
    File file;
    ArrayList<Laptop> laptopi;
    public LaptopDaoJSONFile(){
        this.file = new File(System.getProperty("user.home"),"laptopi.json");

    }
    @Override
    public Laptop dodajLaptopUListu(Laptop laptop) throws IOException {
        return null;
    }

    @Override
    public Laptop dodajLaptopUFile(Laptop laptop) throws IOException {
        return null;
    }

    @Override
    public ArrayList<Laptop> napuniListu(ArrayList<Laptop> laptopi) {
        return null;
    }

    @Override
    public List<Laptop> vratiPodatkeIzDatoteke() {
        return null;
    }

    @Override
    public Laptop getLaptop(String procesor) {
        for(Laptop l: laptopi){
            if(l.getProcesor().equals(procesor)){
                return l;
            }
        }
        throw new NeodgovarajuciProcesorException("Ne postoji laptop sa proslijedjenim procesorom.");
    }
}
