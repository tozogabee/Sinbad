import org.example.exam.sinbad.sky.Ankaa;
import org.example.exam.sinbad.sky.Bird;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AnkaaTest {
    private Bird ankaa1 = new Ankaa(700,"BigBird");
    private Bird ankaa2 = new Ankaa(700,"BigBird");
    private Bird ankaa3 = new Ankaa(10,"Vereb");
    private Bird ankaa4 = new Ankaa(290,"Vereb");
    private Bird ankaa5 = new Ankaa(100,"BigBird");
    private Bird ankaa6 = new Ankaa(100,"Vereb");

    @Test
    public void testAnkaaToString() {
        String expected = "OneDoesNotSimplyFlyOutOfDiamondIsland[flying BEYOND at 700 meters]";
        assertEquals(expected,ankaa1.toString());
    }

    @Test
    public void testAnkaaEqualsWithSameHeightLevel() {
        assertEquals(ankaa1,ankaa2);
    }

    @Test
    public void testAnkaaEqualsWithDifferentHeightLevelAndSameName() {
        assertEquals(ankaa3,ankaa4);
    }

    @Test
    public void testAnkaaEqualsWithDifferentHeightLevelAndDifferentName() {
        assertNotEquals(ankaa5,ankaa6);
    }




}
