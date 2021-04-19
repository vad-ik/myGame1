package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

import java.util.Random;

public class Screen {
    static int money;
    static boolean UpDateMenFlag;
    static int score;
    static Stage stage;
    static boolean StartFlag = true;
    static Player player = new Player();
    static int sloznost = 10;
    static TextButton newgame;
    static Table table = new Table();
    static Table table2Levl = new Table();
    static ArrayList<Integer> WragX = new ArrayList<>();
    static ArrayList<Integer> WragY = new ArrayList<>();
    static ArrayList<Integer> WragTextureWid = new ArrayList<>();
    static ArrayList<Integer> WragFlag = new ArrayList<>();
    static ArrayList<Integer> TuretHP = new ArrayList<>();
    static int xMir;
    static int yMir;
    static ArrayList<Integer> WragLive = new ArrayList<>();
    static ArrayList<Integer> WragStrong = new ArrayList<>();

    static UpdateMenu updateMenu;

    static ArrayList<Turet> TuretArray = new ArrayList<>();
    static Skin skin;
    static Texture backgraund = new Texture("back.jpg");
    static int TotalMoney;
    static boolean skinsFlag = false;
    static boolean skinsFlagws = true;
    static Skins Skins = new Skins();

    public Screen() {

        updateMenu = new UpdateMenu();
        score = 0;
        money = 60;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table.setPosition(0, -Gdx.graphics.getWidth()/15);
        table.setFillParent(true);
        table2Levl.setPosition(0, -Gdx.graphics.getWidth()/15-120);
        table2Levl.setFillParent(true);

        skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        newgame = new TextButton("New Game", skin);


        TextButton out = new TextButton("Exit", skin);

        TextButton skins = new TextButton("Skins", skin);


        table.add(newgame).fillX();
        table.row().pad(10, 0, 10, 0);
        table2Levl.add(out).pad(0, 0, 0, 5);

        table2Levl.add(skins);
        stage.addActor(table);
        stage.addActor(table2Levl);


        out.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        newgame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                stage.clear();

                stage.addActor(player.tableStats);
               stage.addActor(player.tableControl);
                StartFlag = false;
                MyGdxGame.red = 1f;
                MyGdxGame.green = 0.5f;
                MyGdxGame.blue = 0f;
            }
        });
        skins.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                skinsFlag = true;
            }
        });
    }


    static void render(Batch batch, TextureAtlas character, Texture load) {
        if (skinsFlag) {
            SkinsChangeMenu(batch);
        }
        if (player.life <= 0) {
           dead();
        }

        if (( StartFlag ) && ( !skinsFlag )) {
            StartMenu(batch, load);
        } else if (( !skinsFlag )) {
            if (sloznost > 0) {
                if (( sloznost < 30 ) && ( WragX.size() < 10 )) {
                    WragGenerate();
                } else if (( ( sloznost < 100 ) && ( WragX.size() < 50 ) )) {
                    WragGenerate();
                    Wrag2Generator();
                } else if (( ( sloznost < 300 ) )) {
                    WragGenerate();
                    Wrag2Generator();
                    Wrag3Generator();
                }

            }
            if (UpDateMenFlag) {
                updateMenu.render();
            } else {
                Play(batch, character);
            }
        }


    }

    private static void dead() {
        TotalMoney += money;
        stage.clear();
        StartFlag = true;
        newgame.setText("you died. start a new game?");
        MyGdxGame.blue = 0f;
        MyGdxGame.green = 0f;
        MyGdxGame.red = 0f;
        player.life = 100;
        player.x = 380;
        player.y = 200;
        sloznost = 10;
        WragStrong.clear();
        WragX.clear();
        WragY.clear();
        WragFlag.clear();
        WragTextureWid.clear();
        WragLive.clear();
        TuretArray.clear();
        stage.addActor(table);
        stage.addActor(table2Levl);
        TuretHP.clear();
        xMir = 0;
        yMir = 0;
        money = 60;
        player.turetColVo = 0;
        updateMenu= new UpdateMenu();


        }

    static void Play(Batch batch, TextureAtlas character) {





        batch.draw(backgraund, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        for (int i = 0; i < WragX.size(); i++) {

            Wrag1.move(batch, WragX.get(i), WragY.get(i), i, WragTextureWid.get(i));
        }

        for (int i = 0; i < TuretArray.size(); i++) {

            TuretArray.get(i).Drav(batch, i);
        }



        player.Play(batch, character);
        try {
            Thread.sleep(( 100 ));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    static void StartMenu(Batch batch, Texture load) {
        batch.draw(load, Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/15*2, Gdx.graphics.getHeight()/9*5, Gdx.graphics.getWidth()/15*4, Gdx.graphics.getWidth()/15*4);
        stage.act();
        stage.draw();

    }


    static void WragGenerate() {

        sloznost -= 1;
        Random random = new Random();
        int position_x = random.nextInt(200);
        int position_y = random.nextInt(200);
        int wragTextur = random.nextInt(8) + 1;
        if (position_x < 100) {
            position_x = -80 - position_x + xMir;
        } else {
            position_x = Gdx.graphics.getHeight() + position_x + xMir;
        }
        if (position_y < 100) {
            position_y = -60 - position_y + yMir;
        } else {
            position_y = Gdx.graphics.getWidth() + position_y + yMir;
        }
        WragTextureWid.add(wragTextur);
        WragFlag.add(1);
        WragX.add(position_x);
        WragY.add(position_y);
        WragLive.add(1);
        WragStrong.add(1);

    }

    static void Wrag2Generator() {

        sloznost -= 10;
        Random random = new Random();
        int position_x = random.nextInt(200);
        int position_y = random.nextInt(200);
        int wragTextur = random.nextInt(2) + 1;
        if (position_x < 100) {
            position_x = -80 - position_x + xMir;
        } else {
            position_x = Gdx.graphics.getHeight() + position_x + xMir;
        }
        if (position_y < 100) {
            position_y = -60 - position_y + yMir;
        } else {
            position_y = Gdx.graphics.getWidth() + position_y + yMir;
        }

        WragTextureWid.add(wragTextur);
        WragFlag.add(1);
        WragX.add(position_x);
        WragY.add(position_y);
        WragLive.add(10);
        WragStrong.add(2);


    }

    static void Wrag3Generator() {

        sloznost -= 100;
        Random random = new Random();
        int position_x = random.nextInt(200);
        int position_y = random.nextInt(200);
        int wragTextur = random.nextInt(8) + 1;
        if (position_x < 100) {
            position_x = -80 - position_x + xMir;
        } else {
            position_x = Gdx.graphics.getHeight() + position_x + xMir;
        }
        if (position_y < 100) {
            position_y = -60 - position_y + yMir;
        } else {
            position_y = Gdx.graphics.getWidth() + position_y + yMir;
        }

        WragTextureWid.add(wragTextur);
        WragFlag.add(1);
        WragX.add(position_x);
        WragY.add(position_y);
        WragLive.add(10);
        WragStrong.add(3);


    }

    static void SkinsChangeMenu(Batch batch) {

            if (skinsFlagws) {
                stage.clear();
                skinsFlagws = false;
                stage.addActor(Skins.table);
            }
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            Skins.render(batch);

    }

}
