package org.example.sinbad;

import org.example.exam.sinbad.sky.Bird;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ValuableAdventure extends Adventure {
    Map<Bird,Integer> birdDiamonds = new HashMap<>();

    public ValuableAdventure(String diamondFileName, Bird... birds){
        super(birds);
        try(BufferedReader br = new BufferedReader(new FileReader(diamondFileName))) {
            String line;
            for(Bird birdAct : this.birds) {
                while ((line = br.readLine()) != null) {
                    String[] birdParts = line.split(" ");
                    if(birdAct.getName().equals(birdParts[0])) {
                        birdDiamonds.put(birdAct, Integer.parseInt(birdParts[1]));
                        break;
                    }
                }
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
        int diamondCount = 0;
        if(this.birdDiamonds.containsKey(bird)) {
            diamondCount=this.birdDiamonds.get(bird);
        }
        if(diamondCount > 0) {
            this.storeDiamonds(diamondCount);
            this.birdDiamonds.remove(bird);
        }
    }
}
