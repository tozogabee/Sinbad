package org.example.exam.sinbad.sky;

public class Ankaa implements Bird{
    @Override
    public boolean isAtHeightRange(int height) {
        return false;
    }

    @Override
    public String getName() {
        return "BigBird";
    }
}
