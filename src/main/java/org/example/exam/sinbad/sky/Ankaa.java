package org.example.exam.sinbad.sky;

public class Ankaa implements Bird{

    private int height;
    private String name;

    public Ankaa(int height, String name) {
        this.height = height;
        this.name = name;
    }

    @Override
    public boolean isAtHeightRange(int height) {
        return false;
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
}
