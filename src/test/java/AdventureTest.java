import org.example.exam.sinbad.sky.Ankaa;
import org.example.sinbad.Adventure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdventureTest {

    private Adventure adventure1;
    private Adventure adventure2;
    private Adventure adventure3;
    private Adventure adventureSuccessFullOneDay;
    private Adventure adventureFailFullThreeDays;

    @BeforeEach
    public void setUp() {
        this.adventure1 = new Adventure(new Ankaa(700,"BigBird"));
        this.adventure2 = new Adventure(new Ankaa(700,"BigBird"));
        this.adventure3 = new Adventure(new Ankaa(400,"Vereb"));
        this.adventureSuccessFullOneDay = new Adventure(new Ankaa(301,"Ize"), new Ankaa(510,"Seregely"),new Ankaa(400,"Papi"));
        this.adventureFailFullThreeDays = new Adventure(new Ankaa(600,"Seri"),new Ankaa(601,"Veri"));
    }

    @Test
    @DisplayName("test zero collected diamonds")
    public void testZeroCollectedDiamonds()  {
        assertEquals(0,adventure1.getCollectedDiamonds());
        assertEquals(0,adventure2.getCollectedDiamonds());
        assertEquals(1,this.adventure1.getBirdCount());
        assertEquals(1,this.adventure2.getBirdCount());
    }

    @Test
    public void testCallBirdOneBird() {
        assertFalse(this.adventure3.callBird(290));
        assertEquals(1, this.adventure3.getDay());
    }

    @Test
    public void testCallBirdSuccessFullOneDay() {
        this.adventureSuccessFullOneDay.collectDiamonds(10);
        assertEquals(10, this.adventureSuccessFullOneDay.getCollectedDiamonds());
        assertTrue(this.adventureSuccessFullOneDay.callBird(423));
        assertEquals(2, this.adventureSuccessFullOneDay.getDay());
        assertEquals(3, this.adventureSuccessFullOneDay.getBirdCount());
        assertEquals(0, this.adventureSuccessFullOneDay.getCollectedDiamonds());
        assertEquals(10, Adventure.getStoreDiamonds());
    }

    @Test
    public void testCallBirdFailFullThreeDays() {
        this.adventureFailFullThreeDays.collectDiamonds(100);
        assertEquals(100, this.adventureFailFullThreeDays.getCollectedDiamonds());
        assertTrue(this.adventureFailFullThreeDays.callBird(600));
        assertEquals(2, this.adventureFailFullThreeDays.getDay());
        assertEquals(2, this.adventureFailFullThreeDays.getBirdCount());
        assertEquals(0, this.adventureFailFullThreeDays.getCollectedDiamonds());
        assertEquals(100, Adventure.getStoreDiamonds());
        this.adventureFailFullThreeDays.clearStoredDiamonds();
        this.adventureFailFullThreeDays.collectDiamonds(200);
        assertEquals(200, this.adventureFailFullThreeDays.getCollectedDiamonds());
        assertTrue(this.adventureFailFullThreeDays.callBird(601));
        assertEquals(3, this.adventureFailFullThreeDays.getDay());
        assertEquals(2, this.adventureFailFullThreeDays.getBirdCount());
        assertEquals(0, this.adventureFailFullThreeDays.getCollectedDiamonds());
        assertEquals(200, Adventure.getStoreDiamonds());
        this.adventureFailFullThreeDays.clearStoredDiamonds();
        this.adventureFailFullThreeDays.collectDiamonds(300);
        assertEquals(300, this.adventureFailFullThreeDays.getCollectedDiamonds());
        assertTrue(this.adventureFailFullThreeDays.callBird(600));
        assertEquals(4, this.adventureFailFullThreeDays.getDay());
        assertEquals(2, this.adventureFailFullThreeDays.getBirdCount());
        assertEquals(0, this.adventureFailFullThreeDays.getCollectedDiamonds());
        assertEquals(300, Adventure.getStoreDiamonds());
    }
}
