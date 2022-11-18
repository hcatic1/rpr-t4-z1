package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LaptopDaoXMLTest {
    private LaptopDao xml= new LaptopDaoXMLfile();
    @Test
    public void mockTest() throws IOException {
        LaptopDaoXMLfile mockXML = Mockito.mock(LaptopDaoXMLfile.class);
        Laptop l1 = new Laptop();
        l1.setBrend("Dell");
        l1.setCijena(1500);

        Laptop l2 = new Laptop();
        l2.setBrend("Apple");
        l2.setCijena(4900);

        mockXML.dodajLaptopUListu(l1);
        mockXML.dodajLaptopUFile(l2);

        Mockito.when(mockXML.vratiPodatkeIzDatoteke()).thenReturn(new ArrayList<Laptop>());

        assertNotEquals(2, mockXML.vratiPodatkeIzDatoteke().size());
    }
}
