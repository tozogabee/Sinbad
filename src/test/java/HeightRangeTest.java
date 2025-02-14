import org.example.exam.sinbad.sky.HeightRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightRangeTest {


    @Test
    @DisplayName("test heightAtRange method")
    public void testHeightAtRange() {
        int height = 0;
        HeightRange heightRange = HeightRange.getHeightRange(height);
        Assertions.assertEquals(HeightRange.LOW,heightRange);
        height = 299;
        heightRange = HeightRange.getHeightRange(height);
        Assertions.assertEquals(HeightRange.LOW,heightRange);
        height = 300;
        heightRange = HeightRange.getHeightRange(height);
        Assertions.assertEquals(HeightRange.LOW,heightRange);
        height = 301;
        heightRange = HeightRange.getHeightRange(height);
        Assertions.assertEquals(HeightRange.MEDIUM,heightRange);
        height = 600;
        heightRange = HeightRange.getHeightRange(height);
        Assertions.assertEquals(HeightRange.HIGH,heightRange);
        height = 601;
        heightRange = HeightRange.getHeightRange(height);
        Assertions.assertEquals(HeightRange.HIGH,heightRange);
        height = 900;
        heightRange = HeightRange.getHeightRange(height);
        Assertions.assertEquals(HeightRange.BEYOND,heightRange);
        height = 901;
        heightRange = HeightRange.getHeightRange(height);
        Assertions.assertEquals(HeightRange.BEYOND,heightRange);
    }
}
