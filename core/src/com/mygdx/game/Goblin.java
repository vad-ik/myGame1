package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Random;

public class Goblin {
static int x;
static int y;
    private static int Falg=1;

    int live;
    static boolean w;
    static boolean a;
    static boolean s;
    static boolean d;
    static boolean W;
    static boolean A;
    static boolean S;
    static boolean D;
static int spead= (int) (130 * Gdx.graphics.getDeltaTime());
    public Goblin() {




        this.live = 100;

        w = false;
        a = false;
        s = true;
        d = false;
        W = false;
        A = false;
        S = false;
        D = false;

    }

    public static void move(Batch batch, TextureAtlas character,int xx,int yy,int index) {
      x=xx;y=yy;
      boolean onCamera= true;
      if ((x<0)||(y<0)||(x>800)||(y>500)){
          onCamera=false;

      }
ii();

        if (W) {

            screen.wragY.set(index,y+spead);
if (onCamera) {
    if (Falg == 1) {

        drawSprite(batch, character, "wa");
        Falg = 2;
    } else if (Falg == 2) {

        drawSprite(batch, character, "w");

        Falg = 3;
    } else if (Falg == 3) {


        drawSprite(batch, character, "wd");
        Falg = 4;
    } else if (Falg == 4) {

        drawSprite(batch, character, "w");

        Falg = 1;
    }
}

        } else if (A) {

            screen.wragX.set(index,x-spead);

            if (onCamera) {
            if (Falg==1){

                drawSprite(batch,character,"aa");
                Falg=2;
            }else  if (Falg==2){

                drawSprite(batch,character,"a");

                Falg=3;
            } else if (Falg==3){


                drawSprite(batch,character,"ad");
                Falg=4;
            }else  if (Falg==4){

                drawSprite(batch,character,"a");

                Falg=1;
            }}


        } else if (S) {

            screen.wragY.set(index,y-spead);

            if (onCamera) {
                if (Falg == 1) {

                    drawSprite(batch, character, "sa");
                    Falg = 2;
                } else if (Falg == 2) {

                    drawSprite(batch, character, "s");

                    Falg = 3;
                } else if (Falg == 3) {


                    drawSprite(batch, character, "sd");
                    Falg = 4;
                } else if (Falg == 4) {

                    drawSprite(batch, character, "s");

                    Falg = 1;
                }
            }


        } else if (D) {

            screen.wragX.set(index,x+spead);
            if (onCamera) {  if (Falg==1){

                drawSprite(batch,character,"da");
                Falg=2;
            }else  if (Falg==2){

                drawSprite(batch,character,"d");

                Falg=3;
            } else if (Falg==3){


                drawSprite(batch,character,"dd");
                Falg=4;
            }else  if (Falg==4){

                drawSprite(batch,character,"d");

                Falg=1;
            }

        }}


    }

    private static void drawSprite(Batch batch, TextureAtlas textureAtlas, String name) {

        Sprite sprite = textureAtlas.createSprite(name);

           sprite.setPosition(x, y);

        sprite.setSize(60, 80);

        sprite.draw(batch);







    }
    static void ii(){
        A=false;W=false;S=false;D=false;
        int xR = x-Player.x;
        int yR = y-Player.y;

        int xB;
        if (xR<0){
           xB=-1*xR;
        }else {
            xB=xR;
        }
        if (yR<0){
            xB=-(-1*yR);
        }else {
            xB=xB-yR;
        }




        if((xB>0)&&(xR>0)){
                A=true;
       }else
                if((xB>0)&&(xR<0)){
                        D=true;
         }else

        if( (xB<=0)&&(yR>0)){
                S=true;
               }else
        if((xB<=0)&&(yR<0)){
      W=true;      }


    }




}




