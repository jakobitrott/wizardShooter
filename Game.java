package com.Jakob;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;


    public Game() {
        new Window(1000, 563, "Wizard Game", this);
        start();

        handler = new Handler();

        handler.addObject(new Box(100,100));
    }

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 100000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                //updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                //updates = 0;
            }
        }
        stop();
    }
    public void tick() {
handler.tick();

    }

    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3); //preloading frames behind the game window
            return;
        }

        Graphics g = bs.getDrawGraphics();
        ///////////////////DRAW TO GAME///////////////////////////

        g.setColor(Color.red);
        g.fillRect(0, 0, 1000, 563);
        handler.render(g);

        //////////////////////////////////////////////////////////
        g.dispose();
        bs.show();

    }
    public static void main(String[] args) {
        // write your code here

        new Game();
    }
}
