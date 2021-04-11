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
    static TextureAtlas wrag2=new TextureAtlas("wrag2.txt");;
    static TextureAtlas wrag3=new TextureAtlas("wrag3.txt");;
static int spead= (int) (650 * Gdx.graphics.getDeltaTime());
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




ii(index);

        if (W) {

            screen.wragY.set(index,y+spead);

    if (screen.wragFlag.get(index) == 1) {

        drawSprite(batch, character, "w",index);
        screen.wragFlag.set(index,2);
    } else if (screen.wragFlag.get(index) == 2) {

        drawSprite(batch, character, "w (2)",index);

        screen.wragFlag.set(index,3);
    } else if (screen.wragFlag.get(index) == 3) {


        drawSprite(batch, character, "w (3)",index);
        screen.wragFlag.set(index,4);
    } else if (screen.wragFlag.get(index) == 4) {

        drawSprite(batch, character, "w (2)",index);

        screen.wragFlag.set(index,1);
    }


        } else if (A) {

            screen.wragX.set(index,x-spead);

            if (screen.wragFlag.get(index)==1){

                drawSprite(batch,character,"a",index);
                screen.wragFlag.set(index,2);
            }else  if (screen.wragFlag.get(index)==2){

                drawSprite(batch,character,"a (2)",index);

                screen.wragFlag.set(index,3);
            } else if (screen.wragFlag.get(index)==3){


                drawSprite(batch,character,"a (3)",index);
                screen.wragFlag.set(index,4);
            }else  if (screen.wragFlag.get(index)==4){

                drawSprite(batch,character,"a (2)",index);

                screen.wragFlag.set(index,1);
            }


        } else if (S) {

            screen.wragY.set(index,y-spead);


                if (screen.wragFlag.get(index) == 1) {

                    drawSprite(batch, character, "s",index);
                    screen.wragFlag.set(index,2);
                } else if (screen.wragFlag.get(index) == 2) {

                    drawSprite(batch, character, "s (2)",index);

                    screen.wragFlag.set(index,3);
                } else if (screen.wragFlag.get(index) == 3) {


                    drawSprite(batch, character, "s (3)",index);
                    screen.wragFlag.set(index,4);
                } else if (screen.wragFlag.get(index) == 4) {

                    drawSprite(batch, character, "s (2)",index);

                    screen.wragFlag.set(index,1);
                }



        } else if (D) {

            screen.wragX.set(index,x+spead);
             if (screen.wragFlag.get(index)==1){

                drawSprite(batch,character,"d",index);
                screen.wragFlag.set(index,2);
            }else  if (screen.wragFlag.get(index)==2){

                drawSprite(batch,character,"d (2)",index);

                screen.wragFlag.set(index,3);
            } else if (screen.wragFlag.get(index)==3){


                drawSprite(batch,character,"d (3)",index);
                screen.wragFlag.set(index,4);
            }else  if (screen.wragFlag.get(index)==4){

                drawSprite(batch,character,"d (2)",index);

                screen.wragFlag.set(index,1);
            }

        }

        if (screen.wragLive.get(index)<=0){
            screen.wragLive.remove(index);
            screen.wragFlag.remove(index);
            screen.wragY.remove(index);
            screen.wragX.remove(index);
            if (screen.wragStrong.get(index)==1){
                screen.sloznost+=2;
                screen.money+=1;
                screen.score++;}else
            if (screen.wragStrong.get(index)==2){
                screen.sloznost+=15;
                screen.money+=20;
                screen.score+=5;}else
            if (screen.wragStrong.get(index)==3){
                screen.sloznost+=25;
                screen.money+=50;
                screen.score+=10;}
            screen.wragStrong.remove(index);
            screen.wragTexturewid.remove(index);


        }


    }

    private static void drawSprite(Batch batch, TextureAtlas textureAtlas, String name,int index) {

        Sprite sprite= textureAtlas.createSprite(tip + name);

        if(screen.wragStrong.get(index)==1) {
     sprite = textureAtlas.createSprite(tip + name);
}else  if(screen.wragStrong.get(index)==2) {
            sprite = wrag2.createSprite(tip + name);
        }else  if(screen.wragStrong.get(index)==3) {
            sprite = wrag3.createSprite(tip + name);
        }
           sprite.setPosition(x-screen.xMir, y-screen.yMir);

        sprite.setSize(50, 50);
        if(screen.wragStrong.get(index)==2) {
            sprite.setSize(50, 80);
        } if(screen.wragStrong.get(index)==3) {
            sprite.setSize(50, 80);
        }


        sprite.draw(batch);







    }
    static void ii(int indexx){
        A=false;W=false;S=false;D=false;
        
        int xR = x-Player.x-screen.xMir;
        int yR = y-Player.y-screen.yMir;
        if ((xR<10)&&(xR>-10)&&(yR<10)&&(yR>-10)){
                
Player.life--;
            
        }

        for (int i = 0; i < screen.TuretArray.size(); i++) {

            int xRT = x - screen.TuretArray.get(i).cordX+screen.xMir;
            int yRT = y - screen.TuretArray.get(i).cordY+screen.yMir;
            if (( xRT < 10 ) && ( xRT > -10 ) && ( yRT < 10 ) && ( yRT > -10 )) {

                screen.TuretArray.get(i).fight(i);


            }
            if (screen.wragLive.get(indexx) > 0) {
                dmgg = screen.TuretArray.get(i).shot(x, y);

            }
            if (dmgg > 0) {

                if (( screen.wragLive.get(indexx) - dmgg ) == 0) {
                    screen.wragLive.set(indexx, 0);

                } else {
                    screen.wragLive.set(indexx, ( screen.wragLive.get(indexx) ) - dmgg);
                }
            }
        }






Random random = new Random();
        int randNapr = random.nextInt(2);
        System.out.println(randNapr);
        if((yR>0)&&(xR>0)){
               if(randNapr==0){ A=true;}
               else { S=true;}
       }else
                if((yR>0)&&(xR<0)){
                    if(randNapr==0){ D=true;}
                    else { S=true;}

         }else

        if( (yR<=0)&&(xR>0)){
            if(randNapr==0){ W=true;}
            else { A=true;}
               }else
        if((yR<=0)&&(xR<0)){
            if(randNapr==0){ D=true;}
            else { W=true;}   }


    }




}




