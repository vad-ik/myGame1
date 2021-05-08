package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.ArrayList;

public class Player {
    static ArrayList<Turet> TuretArray = new ArrayList<>();
    static ArrayList<Integer> WragX = new ArrayList<>();
    static ArrayList<Integer> WragY = new ArrayList<>();
    static ArrayList<Integer> WragTextureWid = new ArrayList<>();
    static ArrayList<Integer> WragFlag = new ArrayList<>();
    static ArrayList<Integer> TuretHP = new ArrayList<>();
    static int xMir;
    static int yMir;
    static ArrayList<Integer> WragLive = new ArrayList<>();
    static ArrayList<Integer> WragStrong = new ArrayList<>();


    public static TextField nameText;
    TextureAtlas character;
    static boolean SideW;
    static boolean SideA;
    static boolean SideS;
    static boolean SideD;
    static int Falg = 1;
    static boolean LastSideW;
    static boolean LastSideA;
    static boolean LastSideS;
    static boolean LastSideD;
    static public int x;
    static public int y;

   static int life;
    String dravPosition;
    public Player() {
        character=MyGdxGame.character;
dravPosition="w";

        Screen.turetColVo = 0;
        Screen.TuretLimit = 10;
        life = 100;

        x = Gdx.graphics.getWidth()/2;
        y = Gdx.graphics.getHeight()/2;
        LastSideW = false;
        LastSideA = false;
        LastSideS = true;
        LastSideD = false;

    }

    public void Play() {
        PlayerController();





        changeStats(life);
        Screen.stage.act();
        Screen.stage.draw();
        Move();


    }

    private static void PlayerController() {

        double Xthis = ( (  Screen.touchpad.getKnobX() -  Screen.touchpad.getKnobY() ) / Math.sqrt(2) );
        double Ythis = ( (  Screen.touchpad.getKnobX() +  Screen.touchpad.getKnobY() - 162 ) / Math.sqrt(2) );
        if (( Xthis == 0 ) && ( Ythis == 0 )) {
            SideA = false;
            SideS = false;
            SideD = false;
            SideW = false;
        } else if (( Xthis > 0 ) && ( Ythis > 0 )) {
            SideA = false;
            SideS = false;
            SideD = true;
            SideW = false;
        } else if (( Xthis > 0 ) && ( Ythis < 0 )) {
            SideA = false;
            SideS = true;
            SideD = false;
            SideW = false;
        } else if (( Xthis < 0 ) && ( Ythis < 0 )) {
            SideA = true;
            SideS = false;
            SideD = false;
            SideW = false;
        } else if (( Xthis < 0 ) && ( Ythis > 0 )) {
            SideA = false;
            SideS = false;
            SideD = false;
            SideW = true;
        }

    }

    void Move() {





        if (SideW) {
            LastSideW = true;
            LastSideA = false;
            LastSideS = false;
            LastSideD = false;
            if (y < Gdx.graphics.getHeight()-MyGdxGame.Playerheight) {
                y = y + 10;
            } else {
                yMir += 10;

            }
            if (Falg == 1) {

                dravPosition=( "wa");
                Falg = 2;
            } else if (Falg == 2) {

                dravPosition=( "w");

                Falg = 3;
            } else if (Falg == 3) {


                dravPosition=( "wd");
                Falg = 4;
            } else if (Falg == 4) {

                dravPosition=( "w");

                Falg = 1;
            }


        } else if (SideA) {
            LastSideW = false;
            LastSideA = true;
            LastSideS = false;
            LastSideD = false;
            if (x > 0) {
                x = x - 10;
            } else {
                xMir -= 10;
            }
            if (Falg == 1) {

                dravPosition=("aa");
                Falg = 2;
            } else if (Falg == 2) {

                dravPosition=( "a");

                Falg = 3;
            } else if (Falg == 3) {


                dravPosition=( "ad");
                Falg = 4;
            } else if (Falg == 4) {

                dravPosition=( "a");

                Falg = 1;
            }


        } else if (SideS) {
            LastSideW = false;
            LastSideA = false;
            LastSideS = true;
            LastSideD = false;
            if (y > 0) {
                y = y - 10;
            } else {

                yMir -= 10;
            }
            if (Falg == 1) {

                dravPosition=( "sa");
                Falg = 2;
            } else if (Falg == 2) {

                dravPosition=( "s");

                Falg = 3;
            } else if (Falg == 3) {


                dravPosition=("sd");
                Falg = 4;
            } else if (Falg == 4) {

                dravPosition=( "s");

                Falg = 1;
            }


        } else if (SideD) {

            LastSideW = false;
            LastSideA = false;
            LastSideS = false;
            LastSideD = true;
            if (x < Gdx.graphics.getWidth()-MyGdxGame.PlayerWith) {
                x = x + 10;
            } else {
                xMir += 10;
            }
            if (Falg == 1) {

                dravPosition=( "da");
                Falg = 2;
            } else if (Falg == 2) {

                dravPosition=( "d");

                Falg = 3;
            } else if (Falg == 3) {


                dravPosition=( "dd");
                Falg = 4;
            } else if (Falg == 4) {

                dravPosition=( "d");

                Falg = 1;
            }

        } else if (LastSideS) {
            dravPosition=( "s");
        } else if (LastSideW) {
            dravPosition=( "w");
        } else if (LastSideA) {
            dravPosition=( "a");
        } else if (LastSideD) {
            dravPosition=("d");
        }

    }

     void drawSprite(Batch batch ) {
         TextureAtlas textureAtlas=character;
         String name=dravPosition;

        Sprite sprite = textureAtlas.createSprite(name);
        sprite.setPosition(x - MyGdxGame.PlayerCdvig, y);
        sprite.setSize(MyGdxGame.PlayerWith, MyGdxGame.Playerheight);
        sprite.draw(batch);
      //   System.out.println(name+" "+MyGdxGame.PlayerWith+" "+ MyGdxGame.Playerheight+" "+x+" "+y+" ");
         Screen.tableName.setPosition((Gdx.graphics.getWidth()/-2)+x- MyGdxGame.PlayerCdvig+80 ,y-Gdx.graphics.getHeight()/2-10);

    }

    static void changeStats(int life) {
        Screen.TuretLimit = Screen.updateMenu.turetLimit;
        String turetlimText = ( "Turret " +  Screen.turetColVo + "/" +  Screen.TuretLimit );
        Screen.turetLImitText.setText(turetlimText);


        Screen.socerForInt = ( "socer: " + String.valueOf(Screen.score) );
        Screen.socerText.setText( Screen.socerForInt);
        Screen.moneyForInt = ( "money: " + String.valueOf(Screen.money) );
        Screen.moneyText.setText( Screen.moneyForInt);

        Screen.lifeBar.setValue(life);
    }



}
