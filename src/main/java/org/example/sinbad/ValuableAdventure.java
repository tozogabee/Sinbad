package org.example.sinbad;

import org.example.exam.sinbad.sky.Ankaa;
import org.example.exam.sinbad.sky.Bird;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class ValuableAdventure extends Adventure {
    Map<Bird,Integer> birdDiamonds = new HashMap<>();


    public ValuableAdventure(String diamondFileName, Bird... birds){
        super(birds);
        try(BufferedReader br = new BufferedReader(new FileReader(diamondFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] birdParts = line.split(" ");
                Bird bird = new Ankaa(0,birdParts[0]);
                birdDiamonds.put(bird,Integer.parseInt(birdParts[1]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    }

    @Override
    protected void doEscape(Bird bird){
        super.doEscape(bird);
        int diamondCount = this.birdDiamonds.get(bird);
        if(diamondCount > 0) {
            this.storeDiamonds(diamondCount);
            this.birdDiamonds.remove(bird);
        }
    }
}
