package com.Jakob;

import java.awt.*;

/**
 * Created by jakob on 18/09/2017.
 */
public class Box extends GameObject {

    public Box(int x, int y) {
        super(x, y);

        velocityX = 1;
    }

    public void tick(){
        x += velocityX;
        y += velocityY;
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x,y,32,32);
    }

    public Rectangle getBounds(){return null;}
}
