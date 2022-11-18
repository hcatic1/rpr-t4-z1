package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class LaptopDaoJSONTest {
    private LaptopDao dao = new LaptopDaoJSONFile();
    /**
     * Rigorous Test :-)
     */
    @BeforeEach
    private void SetUp() throws IOException {
        Laptop l1 = new Laptop();
        l1.setBrend("Dell");
        l1.setCijena(1500);

        Laptop l2 = new Laptop();
        l2.setBrend("Apple");
        l2.setCijena(4900);

        dao.dodajLaptopUListu(l1);
        dao.dodajLaptopUFile(l2);
    }
    @Test
    public void LaptopDaoJSONBasicTest() throws IOException {
        List<Laptop> lista = dao.vratiPodatkeIzDatoteke();

        assertEquals(2, lista.size());

        Laptop l3 = new Laptop();
        l3.setBrend("Lenovo");
        l3.setCijena(1890);
        lista.add(l3);

        dao.napuniListu((ArrayList<Laptop>) lista);
        dao.dodajLaptopUFile(l3);
        lista = dao.vratiPodatkeIzDatoteke();

        assertEquals(4, lista.size());
    }
}
