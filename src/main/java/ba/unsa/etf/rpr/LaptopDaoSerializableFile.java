package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile() {
        this.file = new File(System.getProperty("user.home"), "laptopi.txt");
        this.laptopi = new ArrayList<Laptop>();
    }

    @Override
    public Laptop dodajLaptopUListu(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        return laptop;
    }

    @Override
    public Laptop dodajLaptopUFile(Laptop laptop) throws IOException {
        dodajLaptopUListu(laptop);
        ObjectOutputStream izlaz = new ObjectOutputStream(new FileOutputStream(this.file));
        izlaz.writeObject(this.laptopi);
        return laptop;
    }

    @Override
    public ArrayList<Laptop> napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = new ArrayList<Laptop>(laptopi);
        return this.laptopi; //ili treba vratiti this.laptopi
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> newLaptopi = null;
        try {
            ObjectInputStream ulaz = new ObjectInputStream(new FileInputStream(this.file));
            newLaptopi = (ArrayList<Laptop>) ulaz.readObject();
        }catch(Exception e){
            //this.laptopi = new ArrayList<Laptop>();
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
