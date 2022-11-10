package ba.unsa.etf.rpr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface LaptopDao {

    public Laptop dodajLaptopUListu(Laptop laptop) throws IOException;
    public Laptop dodajLaptopUFile(Laptop laptop) throws IOException;
    public ArrayList<Laptop> napuniListu(ArrayList<Laptop> laptopi);
    public List<Laptop> vratiPodatkeIzDatoteke();

    public Laptop getLaptop(String procesor);


}
