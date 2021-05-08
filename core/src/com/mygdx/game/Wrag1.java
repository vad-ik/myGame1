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

            Screen.player.WragY.set(index, y + spead);

            if (Screen.player.WragFlag.get(index) == 1) {

                drawSprite(batch, "w", index);
                Screen.player.WragFlag.set(index, 2);
            } else if (Screen.player.WragFlag.get(index) == 2) {

                drawSprite(batch, "w (2)", index);

                Screen.player.WragFlag.set(index, 3);
            } else if (Screen.player.WragFlag.get(index) == 3) {


                drawSprite(batch, "w (3)", index);
                Screen.player.WragFlag.set(index, 4);
            } else if (Screen.player.WragFlag.get(index) == 4) {

                drawSprite(batch, "w (2)", index);

                Screen.player.WragFlag.set(index, 1);
            }


        } else if (SideA) {

            Screen.player.WragX.set(index, x - spead);

            if (Screen.player.WragFlag.get(index) == 1) {

                drawSprite(batch, "a", index);
                Screen.player.WragFlag.set(index, 2);
            } else if (Screen.player.WragFlag.get(index) == 2) {

                drawSprite(batch, "a (2)", index);

                Screen.player.WragFlag.set(index, 3);
            } else if (Screen.player.WragFlag.get(index) == 3) {


                drawSprite(batch, "a (3)", index);
                Screen.player.WragFlag.set(index, 4);
            } else if (Screen.player.WragFlag.get(index) == 4) {

                drawSprite(batch, "a (2)", index);

                Screen.player.WragFlag.set(index, 1);
            }


        } else if (SideS) {

            Screen.player.WragY.set(index, y - spead);


            if (Screen.player.WragFlag.get(index) == 1) {

                drawSprite(batch, "s", index);
                Screen.player.WragFlag.set(index, 2);
            } else if (Screen.player.WragFlag.get(index) == 2) {

                drawSprite(batch, "s (2)", index);

                Screen.player.WragFlag.set(index, 3);
            } else if (Screen.player.WragFlag.get(index) == 3) {


                drawSprite(batch, "s (3)", index);
                Screen.player.WragFlag.set(index, 4);
            } else if (Screen.player.WragFlag.get(index) == 4) {

                drawSprite(batch, "s (2)", index);

                Screen.player.WragFlag.set(index, 1);
            }


        } else if (SideD) {

            Screen.player.WragX.set(index, x + spead);
            if (Screen.player.WragFlag.get(index) == 1) {

                drawSprite(batch, "d", index);
                Screen.player.WragFlag.set(index, 2);
            } else if (Screen.player.WragFlag.get(index) == 2) {

                drawSprite(batch, "d (2)", index);

                Screen.player.WragFlag.set(index, 3);
            } else if (Screen.player.WragFlag.get(index) == 3) {


                drawSprite(batch, "d (3)", index);
                Screen.player.WragFlag.set(index, 4);
            } else if (Screen.player.WragFlag.get(index) == 4) {

                drawSprite(batch, "d (2)", index);

                Screen.player.WragFlag.set(index, 1);
            }

        }

        if (Screen.player.WragLive.get(index) <= 0) {
            Screen.player.WragLive.remove(index);
            Screen.player.WragFlag.remove(index);
            Screen.player.WragY.remove(index);
            Screen.player.WragX.remove(index);
            if (Screen.player.WragStrong.get(index) == 1) {
                Screen.sloznost += 2;
                Screen.money += 1;
                Screen.score++;
            } else if (Screen.player.WragStrong.get(index) == 2) {
                Screen.sloznost += 15;
                Screen.money += 20;
                Screen.score += 5;
            } else if (Screen.player.WragStrong.get(index) == 3) {
                Screen.sloznost += 25;
                Screen.money += 50;
                Screen.score += 10;
            }
            Screen.player.WragStrong.remove(index);
            Screen.player.WragTextureWid.remove(index);


        }


    }

    private static void drawSprite(Batch batch, String name, int index) {
        if(Screen.multiplayerRender){
            for(Player player:MyGdxGame.client.players) {


                Sprite sprite = wrag1.createSprite(tip);
                if (player.WragStrong.get(index) == 1) {
                    sprite = wrag1.createSprite(tip + name);
                } else if (player.WragStrong.get(index) == 2) {
                    sprite = wrag2.createSprite(tip + name);
                } else if (player.WragStrong.get(index) == 3) {
                    sprite = wrag3.createSprite(tip + name);
                }
                sprite.setPosition(x - player.xMir, y - player.yMir);
                sprite.setSize(Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/12);
                if (player.WragStrong.get(index) == 2) {
                    sprite.setSize(Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);
                }
                if (player.WragStrong.get(index) == 3) {
                    sprite.setSize(Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);
                }
                sprite.draw(batch);


            }
        }else {

            Sprite sprite = wrag1.createSprite(tip);
            if (Screen.player.WragStrong.get(index) == 1) {
                sprite = wrag1.createSprite(tip + name);
            } else if (Screen.player.WragStrong.get(index) == 2) {
                sprite = wrag2.createSprite(tip + name);
            } else if (Screen.player.WragStrong.get(index) == 3) {
                sprite = wrag3.createSprite(tip + name);
            }
            sprite.setPosition(x - Screen.player.xMir, y - Screen.player.yMir);
            sprite.setSize(Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/12);
            if (Screen.player.WragStrong.get(index) == 2) {
                sprite.setSize(Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);
            }
            if (Screen.player.WragStrong.get(index) == 3) {
                sprite.setSize(Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);
            }
            sprite.draw(batch);

        }






    }

     static void WragIntelect(int indexx) {
        SideA = false;
        SideW = false;
        SideS = false;
        SideD = false;
         int xR = x - Screen.player.x - Screen.player.xMir;
         int yR = y - Screen.player.y - Screen.player.yMir;
        if(Screen.multiplayerRender){
            for(Player player:MyGdxGame.client.players) {


                 xR = x -player.x - Screen.player.xMir;
              yR = y - player.y - Screen.player.yMir;
                if (( xR < 33 ) && ( xR > -33 ) && ( yR < 33 ) && ( yR > -33 )) {

                    player.life--;

                }

            }
        }else {

             xR = x - Screen.player.x - Screen.player.xMir;
             yR = y - Screen.player.y - Screen.player.yMir;
            if (( xR < 33 ) && ( xR > -33 ) && ( yR < 33 ) && ( yR > -33 )) {

                Screen.player.life--;

            }


        }

         if(Screen.multiplayerRender){
             for(Player player:MyGdxGame.client.players) {

                 for (int i = 0; i < player.TuretArray.size(); i++) {

                     int xRT = x - player.TuretArray.get(i).cordX + player.xMir;
                     int yRT = y - player.TuretArray.get(i).cordY + player.yMir;
                     if (( xRT < 10 ) && ( xRT > -10 ) && ( yRT < 10 ) && ( yRT > -10 )) {

                         player.TuretArray.get(i).fight(i);


                     }
                     if (player.WragLive.get(indexx) > 0) {
                         dmgg = player.TuretArray.get(i).shot(x, y);

                     }
                     if (dmgg > 0) {

                         if (( player.WragLive.get(indexx) - dmgg ) == 0) {
                            player.WragLive.set(indexx, 0);

                         } else {
                            player.WragLive.set(indexx, ( player.WragLive.get(indexx) ) - dmgg);
                         }
                     }
                 }

             }}else {

             for (int i = 0; i < Screen.player.TuretArray.size(); i++) {

                 int xRT = x - Screen.player.TuretArray.get(i).cordX + Screen.player.xMir;
                 int yRT = y - Screen.player.TuretArray.get(i).cordY + Screen.player.yMir;
                 if (( xRT < 10 ) && ( xRT > -10 ) && ( yRT < 10 ) && ( yRT > -10 )) {

                     Screen.player.TuretArray.get(i).fight(i);


                 }
                 if (Screen.player.WragLive.get(indexx) > 0) {
                     dmgg = Screen.player.TuretArray.get(i).shot(x, y);

                 }
                 if (dmgg > 0) {

                     if (( Screen.player.WragLive.get(indexx) - dmgg ) == 0) {
                         Screen.player.WragLive.set(indexx, 0);

                     } else {
                         Screen.player.WragLive.set(indexx, ( Screen.player.WragLive.get(indexx) ) - dmgg);
                     }
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




