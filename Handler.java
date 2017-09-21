package com.Jakob;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by jakob on 18/09/2017.
 */
public class Handler { //handles all our gameobjects

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for (int i = 0; i <object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }


    }

    public void render(Graphics g){
        for (int i = 0; i <object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }


    public void addObject(GameObject tempObject){

        object.add((tempObject));
    }

    public void removeObject(GameObject tempObject){

        object.remove(tempObject);
    }

}
