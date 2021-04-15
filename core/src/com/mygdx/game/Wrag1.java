package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Random;

public class Wrag1 {
    static int x;
    static int y;

    static int dmgg = 0;
    static boolean SideW;
    static boolean SideA;
    static boolean SideS;
    static boolean SideD;
    static String tip;
    static TextureAtlas wrag1 = new TextureAtlas("wrag1.txt");
    ;
    static TextureAtlas wrag2 = new TextureAtlas("wrag2.txt");
    ;
    static TextureAtlas wrag3 = new TextureAtlas("wrag3.txt");
    ;
    static int spead = (int) ( 650 * Gdx.graphics.getDeltaTime() );

    public Wrag1() {


        SideW = false;
        SideA = false;
        SideS = false;
        SideD = false;

    }

    public static void move(Batch batch, int xx, int yy, int index, int tipTexture) {
        x = xx;
        y = yy;
        tip = String.valueOf(tipTexture);


        WragIntelect(index);

        if (SideW) {

            Screen.WragY.set(index, y + spead);

            if (Screen.WragFlag.get(index) == 1) {

                drawSprite(batch, "w", index);
                Screen.WragFlag.set(index, 2);
            } else if (Screen.WragFlag.get(index) == 2) {

                drawSprite(batch, "w (2)", index);

                Screen.WragFlag.set(index, 3);
            } else if (Screen.WragFlag.get(index) == 3) {


                drawSprite(batch, "w (3)", index);
                Screen.WragFlag.set(index, 4);
            } else if (Screen.WragFlag.get(index) == 4) {

                drawSprite(batch, "w (2)", index);

                Screen.WragFlag.set(index, 1);
            }


        } else if (SideA) {

            Screen.WragX.set(index, x - spead);

            if (Screen.WragFlag.get(index) == 1) {

                drawSprite(batch, "a", index);
                Screen.WragFlag.set(index, 2);
            } else if (Screen.WragFlag.get(index) == 2) {

                drawSprite(batch, "a (2)", index);

                Screen.WragFlag.set(index, 3);
            } else if (Screen.WragFlag.get(index) == 3) {


                drawSprite(batch, "a (3)", index);
                Screen.WragFlag.set(index, 4);
            } else if (Screen.WragFlag.get(index) == 4) {

                drawSprite(batch, "a (2)", index);

                Screen.WragFlag.set(index, 1);
            }


        } else if (SideS) {

            Screen.WragY.set(index, y - spead);


            if (Screen.WragFlag.get(index) == 1) {

                drawSprite(batch, "s", index);
                Screen.WragFlag.set(index, 2);
            } else if (Screen.WragFlag.get(index) == 2) {

                drawSprite(batch, "s (2)", index);

                Screen.WragFlag.set(index, 3);
            } else if (Screen.WragFlag.get(index) == 3) {


                drawSprite(batch, "s (3)", index);
                Screen.WragFlag.set(index, 4);
            } else if (Screen.WragFlag.get(index) == 4) {

                drawSprite(batch, "s (2)", index);

                Screen.WragFlag.set(index, 1);
            }


        } else if (SideD) {

            Screen.WragX.set(index, x + spead);
            if (Screen.WragFlag.get(index) == 1) {

                drawSprite(batch, "d", index);
                Screen.WragFlag.set(index, 2);
            } else if (Screen.WragFlag.get(index) == 2) {

                drawSprite(batch, "d (2)", index);

                Screen.WragFlag.set(index, 3);
            } else if (Screen.WragFlag.get(index) == 3) {


                drawSprite(batch, "d (3)", index);
                Screen.WragFlag.set(index, 4);
            } else if (Screen.WragFlag.get(index) == 4) {

                drawSprite(batch, "d (2)", index);

                Screen.WragFlag.set(index, 1);
            }

        }

        if (Screen.WragLive.get(index) <= 0) {
            Screen.WragLive.remove(index);
            Screen.WragFlag.remove(index);
            Screen.WragY.remove(index);
            Screen.WragX.remove(index);
            if (Screen.WragStrong.get(index) == 1) {
                Screen.sloznost += 2;
                Screen.money += 1;
                Screen.score++;
            } else if (Screen.WragStrong.get(index) == 2) {
                Screen.sloznost += 15;
                Screen.money += 20;
                Screen.score += 5;
            } else if (Screen.WragStrong.get(index) == 3) {
                Screen.sloznost += 25;
                Screen.money += 50;
                Screen.score += 10;
            }
            Screen.WragStrong.remove(index);
            Screen.WragTextureWid.remove(index);


        }


    }

    private static void drawSprite(Batch batch, String name, int index) {

        Sprite sprite = wrag1.createSprite(tip + name);

        if (Screen.WragStrong.get(index) == 1) {
            sprite = wrag1.createSprite(tip + name);
        } else if (Screen.WragStrong.get(index) == 2) {
            sprite = wrag2.createSprite(tip + name);
        } else if (Screen.WragStrong.get(index) == 3) {
            sprite = wrag3.createSprite(tip + name);
        }
       // System.out.println(x+" "+ Screen.xMir+" "+y +" "+Screen.yMir);
        sprite.setPosition(x - Screen.xMir, y - Screen.yMir);

        sprite.setSize(50, 50);
        if (Screen.WragStrong.get(index) == 2) {
            sprite.setSize(50, 80);
        }
        if (Screen.WragStrong.get(index) == 3) {
            sprite.setSize(50, 80);
        }


        sprite.draw(batch);


    }

    static void WragIntelect(int indexx) {
        SideA = false;
        SideW = false;
        SideS = false;
        SideD = false;

        int xR = x - Player.x - Screen.xMir;
        int yR = y - Player.y - Screen.yMir;
        if (( xR < 33 ) && ( xR > -33 ) && ( yR < 33 ) && ( yR > -33 )) {

            Player.life--;

        }

        for (int i = 0; i < Screen.TuretArray.size(); i++) {

            int xRT = x - Screen.TuretArray.get(i).cordX + Screen.xMir;
            int yRT = y - Screen.TuretArray.get(i).cordY + Screen.yMir;
            if (( xRT < 10 ) && ( xRT > -10 ) && ( yRT < 10 ) && ( yRT > -10 )) {

                Screen.TuretArray.get(i).fight(i);


            }
            if (Screen.WragLive.get(indexx) > 0) {
                dmgg = Screen.TuretArray.get(i).shot(x, y);

            }
            if (dmgg > 0) {

                if (( Screen.WragLive.get(indexx) - dmgg ) == 0) {
                    Screen.WragLive.set(indexx, 0);

                } else {
                    Screen.WragLive.set(indexx, ( Screen.WragLive.get(indexx) ) - dmgg);
                }
            }
        }


        Random random = new Random();
        int randNapr = random.nextInt(2);

        if (( xR + 8 <= 23 ) && ( xR - 8 >= -23 ) && ( yR < 0 )) {
            SideW = true;
        } else if (( xR + 8 <= 23 ) && ( xR - 8 >= -23 ) && ( yR > 0 )) {
            SideS = true;
        } else if (( yR + 8 <= 23 ) && ( yR - 8 >= -23 ) && ( xR < 0 )) {
            SideD = true;
        } else if (( yR + 8 <= 23 ) && ( yR - 8 >= -23 ) && ( xR > 0 )) {
            SideA = true;
        } else if (( yR > 0 ) && ( xR > 0 )) {
            if (randNapr == 0) {
                SideA = true;
            } else {
                SideS = true;
            }
        } else if (( yR > 0 ) && ( xR < 0 )) {
            if (randNapr == 0) {
                SideD = true;
            } else {
                SideS = true;
            }

        } else if (( yR <= 0 ) && ( xR > 0 )) {
            if (randNapr == 0) {
                SideW = true;
            } else {
                SideA = true;
            }
        } else if (( yR <= 0 ) && ( xR < 0 )) {
            if (randNapr == 0) {
                SideD = true;
            } else {
                SideW = true;
            }
        }


    }


}




