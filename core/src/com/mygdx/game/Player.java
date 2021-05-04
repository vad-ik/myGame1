package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Player {
    static boolean SideW;
    static boolean SideA;
    static boolean SideS;
    static boolean SideD;

    static int life;
    static int Falg = 1;
    static boolean LastSideW;
    static boolean LastSideA;
    static boolean LastSideS;
    static boolean LastSideD;
    static int turetColVo;
    static public int x;
    static public int y;
    static int TuretLimit;
    static ProgressBar lifeBar;
    static TextField socerText;
    static TextField nameText;
    static TextField moneyText;
    static TextField turetLImitText;
    static Table tableStats = new Table();
    static Table tableName = new Table();
    static Table tableControl = new Table();
    static Skin skin;
    static Skin skinText;
    static String socerForInt;
    static String moneyForInt;
    TextButton Update;
    static ImageButton turetButon;
    static Touchpad touchpad;

    public Player() {

        tableStats.setPosition(-Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/80*15);
        tableStats.setFillParent(true);
        tableName.setPosition(0, 0);
        tableName.setFillParent(true);
        tableControl.setPosition(0, -Gdx.graphics.getHeight()/3);
        tableControl.setFillParent(true);
        skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        skinText = new Skin(Gdx.files.internal("terra-mother/skin/terra-mother-ui.json"));
        lifeBar = new ProgressBar(0, 100, 1, false, skin);

        touchpad = new Touchpad(6, skin);
        turetButon = new ImageButton(skin);


        tableControl.add(touchpad).fillX().pad(0, 0, 0, Gdx.graphics.getWidth()/8*5);
        tableControl.add(turetButon).fillX();


        turetButon.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (( Screen.money > 0 ) && ( turetColVo < TuretLimit )) {
                    Screen.TuretArray.add(new Turet(x + Screen.xMir, y + Screen.yMir));
                    Screen.money--;
                    turetColVo++;
                }

            }
        });

        socerForInt = ( "socer: " + Screen.score );
        moneyForInt = ( "money: " + Screen.money );

        Update = new TextButton("Update", skin);
        socerText = new TextField(socerForInt, skinText);
        moneyText = new TextField(moneyForInt, skinText);
        nameText = new TextField(Screen.name.getText(),skinText);
        String turetlimText = ( "Turret " + turetColVo + "/" + TuretLimit );
        turetLImitText = new TextField(turetlimText, skinText);
        tableName.add(nameText).fillX();
        tableStats.add(Update).fillX();
        tableStats.row().pad(0, 0, 10, 0);
        tableStats.add(lifeBar).fillX();
        tableStats.row().pad(0, 0, 10, 0);
        tableStats.add(socerText).fillX();
        tableStats.row().pad(0, 0, 10, 0);
        tableStats.add(moneyText).fillX();
        tableStats.row().pad(0, 0, 10, 0);
        tableStats.add(turetLImitText).fillX();
        tableStats.row().pad(0, 0, 10, 0);

        Update.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {


                Screen.stage.clear();
                Screen.stage.addActor(Screen.updateMenu.table);

                Screen.UpDateMenFlag = true;
            }
        });

        turetColVo = 0;
        TuretLimit = 10;
        life = 100;
        lifeBar.setValue(100);
        x = Gdx.graphics.getWidth()/2;
        y = Gdx.graphics.getHeight()/2;
        LastSideW = false;
        LastSideA = false;
        LastSideS = true;
        LastSideD = false;

    }

    public static void Play(Batch batch, TextureAtlas character) {
        PlayerController();





        changeStats(life);
        Screen.stage.act();
        Screen.stage.draw();
        Move(batch, character);


    }

    private static void PlayerController() {

        double Xthis = ( ( touchpad.getKnobX() - touchpad.getKnobY() ) / Math.sqrt(2) );
        double Ythis = ( ( touchpad.getKnobX() + touchpad.getKnobY() - 162 ) / Math.sqrt(2) );
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

    static void Move(Batch batch, TextureAtlas character) {





        if (SideW) {
            LastSideW = true;
            LastSideA = false;
            LastSideS = false;
            LastSideD = false;
            if (y < Gdx.graphics.getHeight()-MyGdxGame.Playerheight) {
                y = y + 10;
            } else {
                Screen.yMir += 10;

            }
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


        } else if (SideA) {
            LastSideW = false;
            LastSideA = true;
            LastSideS = false;
            LastSideD = false;
            if (x > 0) {
                x = x - 10;
            } else {
                Screen.xMir -= 10;
            }
            if (Falg == 1) {

                drawSprite(batch, character, "aa");
                Falg = 2;
            } else if (Falg == 2) {

                drawSprite(batch, character, "a");

                Falg = 3;
            } else if (Falg == 3) {


                drawSprite(batch, character, "ad");
                Falg = 4;
            } else if (Falg == 4) {

                drawSprite(batch, character, "a");

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

                Screen.yMir -= 10;
            }
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


        } else if (SideD) {

            LastSideW = false;
            LastSideA = false;
            LastSideS = false;
            LastSideD = true;
            if (x < Gdx.graphics.getWidth()-MyGdxGame.PlayerWith) {
                x = x + 10;
            } else {
                Screen.xMir += 10;
            }
            if (Falg == 1) {

                drawSprite(batch, character, "da");
                Falg = 2;
            } else if (Falg == 2) {

                drawSprite(batch, character, "d");

                Falg = 3;
            } else if (Falg == 3) {


                drawSprite(batch, character, "dd");
                Falg = 4;
            } else if (Falg == 4) {

                drawSprite(batch, character, "d");

                Falg = 1;
            }

        } else if (LastSideS) {
            drawSprite(batch, character, "s");
        } else if (LastSideW) {
            drawSprite(batch, character, "w");
        } else if (LastSideA) {
            drawSprite(batch, character, "a");
        } else if (LastSideD) {
            drawSprite(batch, character, "d");
        }

    }

    private static void drawSprite(Batch batch, TextureAtlas textureAtlas, String name) {
        Sprite sprite = textureAtlas.createSprite(name);

        sprite.setPosition(x - MyGdxGame.PlayerCdvig, y);
        sprite.setSize(MyGdxGame.PlayerWith, MyGdxGame.Playerheight);
        sprite.draw(batch);
        tableName.setPosition((Gdx.graphics.getWidth()/-2)+x- MyGdxGame.PlayerCdvig+80 ,y-Gdx.graphics.getHeight()/2-10);

    }


    static void changeStats(int life) {
        TuretLimit = Screen.updateMenu.turetLimit;
        String turetlimText = ( "Turret " + turetColVo + "/" + TuretLimit );
        turetLImitText.setText(turetlimText);


            socerForInt = ( "socer: " + String.valueOf(Screen.score) );
            socerText.setText(socerForInt);
            moneyForInt = ( "money: " + String.valueOf(Screen.money) );
            moneyText.setText(moneyForInt);

        lifeBar.setValue(life);
    }
}
