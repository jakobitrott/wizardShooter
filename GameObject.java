package com.Jakob;

import java.awt.*;

/**
 * Created by jakob on 18/09/2017.
 */
public abstract class GameObject {

    protected int x,y;
    protected float velocityX = 0, velocityY = 0;

    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
}
