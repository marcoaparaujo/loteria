package loteriaV5;

import loteriaV4.*;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SorteioTest {
    
    @Test
    public void testGetNumeros_sorteioValido() {
        Sorteio sorteio = new Sorteio(0);
        assertEquals(new ArrayList<>(), sorteio.getNumeros());
    }
    
}
