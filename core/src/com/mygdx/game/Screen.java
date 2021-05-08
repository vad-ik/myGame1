package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.net.GameSerwer;

import java.util.ArrayList;

import java.util.Random;

public class Screen {
    static int turetColVo;
    static int TuretLimit;
    static ProgressBar lifeBar;
    static TextField socerText;

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
    static int money;
    static boolean UpDateMenFlag;
    static int score;
    static Stage stage;
    static boolean StartFlag = true;
    static Player player;
    static int sloznost = 10;
    static TextButton newgame;
    static Table table = new Table();
    static Table table2Levl = new Table();


    static UpdateMenu updateMenu;


    static Texture backgraund = new Texture("back.jpg");
    static int TotalMoney;
    static boolean skinsFlag = false;
    static boolean skinsFlagws = true;
    static Skins Skins = new Skins();
    public static TextField name;
    static boolean multiplayerRender = false;

    public Screen() {

        skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        name = new TextField("player", skin);
        player = new Player();
        updateMenu = new UpdateMenu();
        score = 0;
        money = 60;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setPosition(0, -Gdx.graphics.getWidth() / 15);
        table.setFillParent(true);
        table2Levl.setPosition(0, -Gdx.graphics.getWidth() / 15 - 120);
        table2Levl.setFillParent(true);

        newgame = new TextButton("New Game", skin);


        TextButton out = new TextButton("Exit", skin);
        final TextButton multiplayer = new TextButton("multiplayer", skin);

        TextButton skins = new TextButton("Skins", skin);
        final TextButton musicOff = new TextButton("Music off", skin);


        tableStats.setPosition(-Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 80 * 15);
        tableStats.setFillParent(true);
        tableName.setPosition(0, 0);
        tableName.setFillParent(true);
        tableControl.setPosition(0, -Gdx.graphics.getHeight() / 3);
        tableControl.setFillParent(true);

        skinText = new Skin(Gdx.files.internal("terra-mother/skin/terra-mother-ui.json"));
        lifeBar = new ProgressBar(0, 100, 1, false, skin);

        touchpad = new Touchpad(6, skin);
        turetButon = new ImageButton(skin);


        tableControl.add(touchpad).fillX().pad(0, 0, 0, Gdx.graphics.getWidth() / 8 * 5);
        tableControl.add(turetButon).fillX();


        turetButon.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (( Screen.money > 0 ) && ( turetColVo < TuretLimit )) {
                    player.TuretArray.add(new Turet(player.x + player.xMir, player.y + player.yMir));
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
        player.nameText = new TextField(Screen.name.getText(), skinText);
        String turetlimText = ( "Turret " + turetColVo + "/" + TuretLimit );
        turetLImitText = new TextField(turetlimText, skinText);
        tableName.add(player.nameText).fillX();
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

        Screen.lifeBar.setValue(100);

        table.add(newgame).fillX();

        table.add(multiplayer).fillX();
        table.row().pad(10, 0, 10, 0);
        table2Levl.add(musicOff);
        table2Levl.add(out);
        table2Levl.add(skins);
        table2Levl.add(name).fillY();
        stage.addActor(table);
        stage.addActor(table2Levl);

        musicOff.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (MyGdxGame.Music.getVolume() != 0) {
                    MyGdxGame.Music.setVolume(0);
                    musicOff.setText("Music on");
                } else {
                    MyGdxGame.Music.setVolume(0.5f);
                    musicOff.setText("Music off");
                }
            }
        });
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

                stage.addActor(tableStats);
                stage.addActor(tableControl);
                stage.addActor(tableName);
                StartFlag = false;
                MyGdxGame.red = 1f;
                MyGdxGame.green = 0.5f;
                MyGdxGame.blue = 0f;
                player.nameText.setText(name.getText());
                multiplayerRender = false;
            }
        });
        skins.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                skinsFlag = true;
            }
        });
        multiplayer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                multiplayerRender = true;

                stage.clear();

                stage.addActor(tableStats);
                stage.addActor(tableControl);
                stage.addActor(tableName);
                StartFlag = false;
                MyGdxGame.red = 1f;
                MyGdxGame.green = 0.5f;
                MyGdxGame.blue = 0f;
                player.nameText.setText(name.getText());


            }
        });


    }


    void render(Batch batch, Texture load) {

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
                if (( sloznost < 30 ) && ( player.WragX.size() < 10 )) {
                    WragGenerate();
                } else if (( ( sloznost < 100 ) && ( player.WragX.size() < 50 ) )) {
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
                Play(batch);
            }
        }


    }

    private static void dead() {
        TotalMoney += money;
        stage.clear();
        StartFlag = true;
        newgame.setText("new game");
        MyGdxGame.blue = 0f;
        MyGdxGame.green = 0f;
        MyGdxGame.red = 0f;
        player.life = 100;
        player.x = 380;
        player.y = 200;
        sloznost = 10;
        player.WragStrong.clear();
        player.WragX.clear();
        player.WragY.clear();
        player.WragFlag.clear();
        player.WragTextureWid.clear();
        player.WragLive.clear();
        player.TuretArray.clear();
        stage.addActor(table);
        stage.addActor(table2Levl);
        player.TuretHP.clear();
        player.xMir = 0;
        player.yMir = 0;
        money = 60;
        turetColVo = 0;
        updateMenu = new UpdateMenu();


    }

    void Play(Batch batch) {


        batch.draw(backgraund, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        for (int i = 0; i < player.WragX.size(); i++) {

            Wrag1.move(batch, player.WragX.get(i), player.WragY.get(i), i, player.WragTextureWid.get(i));
        }

        for (int i = 0; i < player.TuretArray.size(); i++) {

            player.TuretArray.get(i).Drav(batch, i);
        }


        player.Play();
        try {
            Thread.sleep(( 100 ));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


        if (multiplayerRender) {
            for (Player player : MyGdxGame.client.players) {
                player.drawSprite(batch);
            }
        } else {
            player.drawSprite(batch);
        }


    }

    static void StartMenu(Batch batch, Texture load) {
        batch.draw(load, Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 15 * 2, Gdx.graphics.getHeight() / 9 * 5, Gdx.graphics.getWidth() / 15 * 4, Gdx.graphics.getWidth() / 15 * 4);
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
            position_x = -80 - position_x + player.xMir;
        } else {
            position_x = Gdx.graphics.getHeight() + position_x + player.xMir;
        }
        if (position_y < 100) {
            position_y = -60 - position_y + player.yMir;
        } else {
            position_y = Gdx.graphics.getWidth() + position_y + player.yMir;
        }
        player.WragTextureWid.add(wragTextur);
        player.WragFlag.add(1);
        player.WragX.add(position_x);
        player.WragY.add(position_y);
        player.WragLive.add(1);
        player.WragStrong.add(1);

    }

    static void Wrag2Generator() {

        sloznost -= 10;
        Random random = new Random();
        int position_x = random.nextInt(200);
        int position_y = random.nextInt(200);
        int wragTextur = random.nextInt(2) + 1;
        if (position_x < 100) {
            position_x = -80 - position_x + player.xMir;
        } else {
            position_x = Gdx.graphics.getHeight() + position_x + player.xMir;
        }
        if (position_y < 100) {
            position_y = -60 - position_y + player.yMir;
        } else {
            position_y = Gdx.graphics.getWidth() + position_y + player.yMir;
        }

        player.WragTextureWid.add(wragTextur);
        player.WragFlag.add(1);
        player.WragX.add(position_x);
        player.WragY.add(position_y);
        player.WragLive.add(10);
        player.WragStrong.add(2);


    }

    static void Wrag3Generator() {

        sloznost -= 100;
        Random random = new Random();
        int position_x = random.nextInt(200);
        int position_y = random.nextInt(200);
        int wragTextur = random.nextInt(8) + 1;
        if (position_x < 100) {
            position_x = -80 - position_x + player.xMir;
        } else {
            position_x = Gdx.graphics.getHeight() + position_x + player.xMir;
        }
        if (position_y < 100) {
            position_y = -60 - position_y + player.yMir;
        } else {
            position_y = Gdx.graphics.getWidth() + position_y + player.yMir;
        }

        player.WragTextureWid.add(wragTextur);
        player.WragFlag.add(1);
        player.WragX.add(position_x);
        player.WragY.add(position_y);
        player.WragLive.add(10);
        player.WragStrong.add(3);


    }

    static void SkinsChangeMenu(Batch batch) {

        if (skinsFlagws) {
            stage.clear();
            skinsFlagws = false;
            stage.addActor(Skins.table);
        }

        Skins.render(batch);

    }

}
