package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Player {
    int xp;
    String Name;
    int lvl;
    int live;

    static boolean w;
    static boolean a;
    static boolean s;
    static boolean d;

    public Player(String name) {
        this.xp = 0;
        Name = name;
        this.lvl = 1;
        this.live = 100;
        w=false;
        a=false;
        s=true;
        d=false;



    }

    public static void move(Batch batch, TextureAtlas character) {
        Sprite w1 = character.createSprite("вверх лево");
        Sprite w2 = character.createSprite("вверх");
        Sprite w3 = character.createSprite("вверх право");
        Sprite s1 = character.createSprite("вниз лево");
        Sprite s2 = character.createSprite("вниз");
        Sprite s3 = character.createSprite("вниз право");
        Sprite a1 = character.createSprite("лево лево");
        Sprite a2 = character.createSprite("лево");
        Sprite a3 = character.createSprite("лево право");
        Sprite d1 = character.createSprite("право лево");
        Sprite d2 = character.createSprite("право");
        Sprite d3 = character.createSprite("право право");






        if(Gdx.input.isKeyPressed(Input.Keys.W)){
         w=true;
            a=false;
            s=false;
            d=false;


w1.draw(batch);
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
w2.draw(batch);
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
w3.draw(batch);
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }





        }else
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                w=false;
                a=true;
                s=false;
                d=false;


                a1.draw(batch);
                try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                a2.draw(batch);
                try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                a3.draw(batch);
                try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }




            }else
            if(Gdx.input.isKeyPressed(Input.Keys.S)){
                    w=false;
                    a=false;
                    s=true;
                    d=false;


                    s1.draw(batch);
                    try {
                        Thread.sleep(1000);                 //1000 milliseconds is one second.
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    s2.draw(batch);
                    try {
                        Thread.sleep(1000);                 //1000 milliseconds is one second.
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    s3.draw(batch);
                    try {
                        Thread.sleep(1000);                 //1000 milliseconds is one second.
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }





                }else
            if(Gdx.input.isKeyPressed(Input.Keys.D)){
                        w=false;
                        a=false;
                        s=false;
                        d=true;
                        d1.draw(batch);
                        try {
                            Thread.sleep(1000);                 //1000 milliseconds is one second.
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        d2.draw(batch);
                        try {
                            Thread.sleep(1000);                 //1000 milliseconds is one second.
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        d3.draw(batch);
                        try {
                            Thread.sleep(1000);                 //1000 milliseconds is one second.
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }



                    }else if (s==true){
                s2.draw(batch);
            }else if (w==true){
                w2.draw(batch);
            }else if (a==true){
                a2.draw(batch);
            }else if (d==true){
                d2.draw(batch);
            }








    }
}
