package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Random;

public class Wrag1 {
static int x;
static int y;

static int dmgg=0;
    int live;
    static boolean w;
    static boolean a;
    static boolean s;
    static boolean d;
    static boolean W;
    static boolean A;
    static boolean S;
    static boolean D;
    static String tip;
static int spead= (int) (330 * Gdx.graphics.getDeltaTime());
    public Wrag1() {






        w = false;
        a = false;
        s = true;
        d = false;
        W = false;
        A = false;
        S = false;
        D = false;

    }

    public static void move(Batch batch, TextureAtlas character,int xx,int yy,int index,int tipTexture) {
      x=xx;y=yy;tip= String.valueOf(tipTexture);



      boolean onCamera= true;
      if ((x<0)||(y<0)||(x>800)||(y>500)){
          onCamera=false;

      }
ii(index);

        if (W) {

            screen.wragY.set(index,y+spead);
if (onCamera) {
    if (screen.wragFlag.get(index) == 1) {

        drawSprite(batch, character, "w");
        screen.wragFlag.set(index,2);
    } else if (screen.wragFlag.get(index) == 2) {

        drawSprite(batch, character, "w (2)");

        screen.wragFlag.set(index,3);
    } else if (screen.wragFlag.get(index) == 3) {


        drawSprite(batch, character, "w (3)");
        screen.wragFlag.set(index,4);
    } else if (screen.wragFlag.get(index) == 4) {

        drawSprite(batch, character, "w (2)");

        screen.wragFlag.set(index,1);
    }
}

        } else if (A) {

            screen.wragX.set(index,x-spead);

            if (onCamera) {
            if (screen.wragFlag.get(index)==1){

                drawSprite(batch,character,"a");
                screen.wragFlag.set(index,2);
            }else  if (screen.wragFlag.get(index)==2){

                drawSprite(batch,character,"a (2)");

                screen.wragFlag.set(index,3);
            } else if (screen.wragFlag.get(index)==3){


                drawSprite(batch,character,"a (3)");
                screen.wragFlag.set(index,4);
            }else  if (screen.wragFlag.get(index)==4){

                drawSprite(batch,character,"a (2)");

                screen.wragFlag.set(index,1);
            }}


        } else if (S) {

            screen.wragY.set(index,y-spead);

            if (onCamera) {
                if (screen.wragFlag.get(index) == 1) {

                    drawSprite(batch, character, "s");
                    screen.wragFlag.set(index,2);
                } else if (screen.wragFlag.get(index) == 2) {

                    drawSprite(batch, character, "s (2)");

                    screen.wragFlag.set(index,3);
                } else if (screen.wragFlag.get(index) == 3) {


                    drawSprite(batch, character, "s (3)");
                    screen.wragFlag.set(index,4);
                } else if (screen.wragFlag.get(index) == 4) {

                    drawSprite(batch, character, "s (2)");

                    screen.wragFlag.set(index,1);
                }
            }


        } else if (D) {

            screen.wragX.set(index,x+spead);
            if (onCamera) {  if (screen.wragFlag.get(index)==1){

                drawSprite(batch,character,"d");
                screen.wragFlag.set(index,2);
            }else  if (screen.wragFlag.get(index)==2){

                drawSprite(batch,character,"d (2)");

                screen.wragFlag.set(index,3);
            } else if (screen.wragFlag.get(index)==3){


                drawSprite(batch,character,"d (3)");
                screen.wragFlag.set(index,4);
            }else  if (screen.wragFlag.get(index)==4){

                drawSprite(batch,character,"d (2)");

                screen.wragFlag.set(index,1);
            }

        }}

        if (screen.wragLive.get(index)<=0){
            screen.wragLive.remove(index);
            screen.wragFlag.remove(index);
            screen.wragY.remove(index);
            screen.wragX.remove(index);
            screen.wragTexturewid.remove(index);
            screen.sloznost+=2;
            screen.money+=1;
            screen.score++;
        }
    }

    private static void drawSprite(Batch batch, TextureAtlas textureAtlas, String name) {

        Sprite sprite = textureAtlas.createSprite(tip+name);

           sprite.setPosition(x, y);

        sprite.setSize(50, 50);

        sprite.draw(batch);







    }
    static void ii(int indexx){
        A=false;W=false;S=false;D=false;
        
        int xR = x-Player.x;
        int yR = y-Player.y;
        if ((xR<10)&&(xR>-10)&&(yR<10)&&(yR>-10)){
                
Player.life--;
            
        }

        for (int i = 0; i < screen.TuretArray.size(); i++) {
            int xRT = x-screen.TuretArray.get(i).cordX;
            int yRT = y-screen.TuretArray.get(i).cordY;
            if ((xRT<10)&&(xRT>-10)&&(yRT<10)&&(yRT>-10)){

screen.TuretArray.get(i).fight();


            }
             dmgg= screen.TuretArray.get(i).shot(x,y);

        }
        if (dmgg > 0) {

if ((screen.wragLive.get(indexx) - dmgg)==0){
    screen.wragLive.set(indexx,0);

}else {
            screen.wragLive.set(indexx, (screen.wragLive.get(indexx))- dmgg);
        }}


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




