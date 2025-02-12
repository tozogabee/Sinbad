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

    static HeightRange getHeightRange(int height){

        for(HeightRange range : HeightRange.values()) {
            //int max =
            if(height > range.min && height < range.max) return range;
        }
        return HeightRange.BEYOND;
    }
}
