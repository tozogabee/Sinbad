import org.example.exam.sinbad.sky.Ankaa;
import org.example.sinbad.Adventure;
import org.example.sinbad.ValuableAdventure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValuableAdventureTest {

    private ValuableAdventure valuableAdventure;

    @BeforeEach
    public void setUp() {
        this.valuableAdventure = new ValuableAdventure("/Users/tozogabee/repositories/Sinbad/Birds.txt",new Ankaa(700,"Vereb"), new Ankaa(780,"Seregely"));
    }

    @Test
    public void doEscapeTest() {
        this.valuableAdventure.callBird(710);
    }
}
