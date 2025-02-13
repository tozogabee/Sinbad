import org.example.exam.sinbad.sky.Ankaa;
import org.example.exam.sinbad.sky.Bird;
import org.example.sinbad.Adventure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.util.List;

public class AdventureTest {

    private Adventure adventure1;
    private Adventure adventure2;

    @BeforeEach
    public void setUp() {
        this.adventure1 = new Adventure(new Ankaa());
        this.adventure2 = new Adventure(new Ankaa());
    }

    @Test
    @DisplayName("test zero collected diamonds")
    public void testZeroCollectedDiamonds()  {
        Assertions.assertEquals(0,adventure1.getCollectedDiamonds());
        Assertions.assertEquals(0,adventure2.getCollectedDiamonds());
        Assertions.assertEquals(1,this.adventure1.getBirdCount());
        Assertions.assertEquals(1,this.adventure2.getBirdCount());
    }
}
