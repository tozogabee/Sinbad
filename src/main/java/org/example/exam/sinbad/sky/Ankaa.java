package org.example.exam.sinbad.sky;

public class Ankaa implements Bird{

    private int height;
    private String name;
    HeightRange heightRange;

    public Ankaa(int height, String name) {
        this.height = height;
        this.name = name;
        this.heightRange = HeightRange.getHeightRange(height);
    }
    
    @Override
    public boolean isAtHeightRange(int height) {
        return this.heightRange == HeightRange.getHeightRange(height);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeightRange getHeightRange() {
        return this.heightRange;
    }
    
    @Override
    public String toString() {
        return "OneDoesNotSimplyFlyOutOfDiamondIsland[flying "+this.getHeightRange()+" at "+this.getHeight()+" meters]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ankaa a) {
            return this.getHeightRange() == a.getHeightRange() && this.getName().equals(a.getName());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = Integer.hashCode(height);
        result = 31 * result + name.hashCode();
        result = 31 * result + heightRange.hashCode();
        return result;
    }
}
