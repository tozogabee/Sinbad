package org.example.exam.sinbad.sky;

public enum HeightRange {
    LOW(0,300),
    MEDIUM(301,600),
    HIGH(600,601),
    BEYOND;

   private int min,max;

    HeightRange(int min, int max){
        this.min = min;
        this.max = max;
    }

    HeightRange(){
        this(0,0);
    }

    public static HeightRange getHeightRange(int height){
        HeightRange act = HeightRange.BEYOND;
        for(HeightRange range : HeightRange.values()) {
            if(range.min == 0 && range.max == 0) {
                continue;
            } else if(height >= range.min && height <= range.max) {
                act = range;
            }
        }
        return act;
    }
}
