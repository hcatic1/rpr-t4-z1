package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoSerializableFile implements LaptopDao{
    File file;
    ArrayList<Laptop> laptopi;

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
        this.laptopi.addAll(laptopi);
        return laptopi; //ili treba vratiti this.laptopi
    }

    @Override
    public List<Laptop> vratiPodatkeIzDatoteke() {
        try {
            ObjectInputStream ulaz = new ObjectInputStream(new FileInputStream(this.file));
            this.laptopi = (ArrayList<Laptop>) ulaz.readObject();
        }catch(Exception e){
            this.laptopi = new ArrayList<Laptop>();
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Laptop getLaptop(Integer id) {
        for(Laptop l: this.laptopi){
            if(l.getId().equals(id)){
                return l;
            }
        }
        return null;
    }
}
