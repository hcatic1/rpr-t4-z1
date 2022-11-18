package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoXMLfile implements LaptopDao{
    File file;
    ArrayList<Laptop> laptopi;

    public LaptopDaoXMLfile(){
        this.laptopi = new ArrayList<Laptop>();
        this.file = new File(System.getProperty("user.home"),"laptopi.xml");
    }
    @Override
    public Laptop dodajLaptopUListu(Laptop laptop) throws IOException {
        this.laptopi.add(laptop);
        return laptop;
    }

    @Override
    public Laptop dodajLaptopUFile(Laptop laptop) throws IOException {
        dodajLaptopUListu(laptop);
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(this.file, this.laptopi);
        return laptop;
    }

    @Override
    public ArrayList<Laptop> napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = new ArrayList<Laptop>(laptopi);
        return this.laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> newLaptopi = null;
        try{
            XmlMapper mapper = new XmlMapper();
            newLaptopi = mapper.readValue(this.file, new TypeReference<ArrayList<Laptop>>() {});
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return newLaptopi;
    }

    @Override
    public Laptop getLaptop(String procesor) {
        for(Laptop l: this.laptopi){
            if(l.getProcesor().equals(procesor)){
                return l;
            }
        }
        throw new NeodgovarajuciProcesorException("Ne postoji laptop sa datim procesorom.");
    }
}
