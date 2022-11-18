package ba.unsa.etf.rpr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {
        Laptop l1 = new Laptop();
        l1.setBrend("Dell");
        l1.setCijena(1500);

        Laptop l2 = new Laptop();
        l2.setBrend("Apple");
        l2.setCijena(4900);

        LaptopDao dao = new LaptopDaoJSONFile();


        dao.dodajLaptopUListu(l2);
        dao.dodajLaptopUFile(l1);


        LaptopDao daoX = new LaptopDaoXMLfile();

        List<Laptop> lista = dao.vratiPodatkeIzDatoteke();
        for(Laptop l: lista){
            System.out.println(l.getBrend());
        }
        Laptop l3 = new Laptop();
        l3.setBrend("Lenovo");
        l3.setCijena(1890);
        daoX.napuniListu((ArrayList<Laptop>) lista);
        daoX.dodajLaptopUFile(l3);

        lista = daoX.vratiPodatkeIzDatoteke();
        for(Laptop l: lista){
            System.out.println(l.getBrend());
        }

        Laptop l4 = new Laptop();
        l4.setBrend("HP");
        l4.setCijena(1200);
        l4.setRam(8);

        LaptopDao daoBin = new LaptopDaoSerializableFile();
        daoBin.napuniListu((ArrayList<Laptop>) lista);
        daoBin.dodajLaptopUFile(l4);

        lista = daoBin.vratiPodatkeIzDatoteke();
        for(Laptop l: lista){
            System.out.println(l.getBrend());
        }
    }
}
