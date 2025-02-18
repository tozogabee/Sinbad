package org.example.sinbad;

import org.example.exam.sinbad.sky.Ankaa;
import org.example.exam.sinbad.sky.Bird;
import org.example.exam.sinbad.sky.HeightRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Adventure {
    protected static int STORE_DIAMONDS = 0;
    protected int collectedDiamonds = 0;
    protected List<Bird> birds = new ArrayList<>();
    protected int day = 1;


    public Adventure(Bird... birds) {
        if(birds.length > 3) {
            throw new IllegalArgumentException("You can not add more than three birds to the constructor");
        }
        this.birds.addAll(Arrays.asList(birds));
    }

    public Adventure(){
        this(new Bird[]{ new Ankaa(700,"BigBird") });
    }


    public int getBirdCount() {
        return this.birds.size();
    }

    public void clearStoredDiamonds() {
        STORE_DIAMONDS = 0;
    }

    public void collectDiamonds(int diamondCount) {
        this.collectedDiamonds += diamondCount;
    }

    protected void storeDiamonds(int diamondCount) {
        STORE_DIAMONDS += diamondCount;
    }

    public static int getStoreDiamonds() {
        return STORE_DIAMONDS;
    }

    public int getCollectedDiamonds() {
        return collectedDiamonds;
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public int getDay() {
        return day;
    }

    public boolean callBird(int height) {
        Optional<Bird> ankaOpt = birds.stream()
                .filter(bird -> bird.isAtHeightRange(height))
                .filter(bird -> bird instanceof Ankaa)
                .findFirst();
        if(ankaOpt.isPresent() && birds.size() > 1) {
            this.doEscape(ankaOpt.get());
            return true;
        }
        return false;
    }

    protected void doEscape(Bird bird) {
        this.storeDiamonds(this.collectedDiamonds);
        this.collectedDiamonds = 0;
        this.day++;
    }
}
