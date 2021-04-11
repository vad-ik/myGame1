package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
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

public class screen {
static int money;
static boolean UpDateMenFlag;
    static int score;
    static Stage stage;
    static boolean StartFlag = true;
    static Player player = new Player("asd");
   static int sloznost = 10;
    static TextButton newgame;
   static Table table = new Table();
    static ArrayList<Integer>wragX = new ArrayList<>();
    static ArrayList<Integer>wragY = new ArrayList<>();
    static ArrayList<Integer>wragTexturewid = new ArrayList<>();
    static ArrayList<Integer>wragFlag = new ArrayList<>();
    static ArrayList<Integer>TuretHP = new ArrayList<>();
    static int xMir;
    static int yMir;
    static ArrayList<Integer>wragLive = new ArrayList<>();
    static ArrayList<Integer>wragStrong = new ArrayList<>();

   static UpdateMenu updateMenu;

    static ArrayList<Turet>TuretArray = new ArrayList<>();
   static Skin skin;
    static Texture backgraund = new Texture("back.jpg");
    public screen() {
         updateMenu=new UpdateMenu();
        score=0;
        money=60;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table.setPosition(0,-100);
        table.setFillParent(true);

        skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
         newgame = new TextButton("New Game", skin);



        TextButton out = new TextButton("Exit", skin);






        table.add(newgame).fillX();
        table.row().pad(10, 0, 10, 0);
        table.add(out).fillX();
        table.row();
        stage.addActor(table);


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
                StartFlag = false;
                MyGdxGame.red=1f;
                MyGdxGame.green=0.5f;
MyGdxGame.blue=0f;
            }
        });















    }


    static void render(Batch batch, TextureAtlas character, TextureAtlas wrag1Texture,Texture load) {


        if (player.life<=0){
            stage.clear();
            StartFlag=true;
            newgame.setText("you died. start a new game?");
            MyGdxGame.blue=0f;
            MyGdxGame.green=0f;
            MyGdxGame.red=0f;
            player.life=100;
            player.x=380;
            player.y=200;
            sloznost=10;
            wragX.clear();
            wragY.clear();
            wragFlag.clear();
            wragTexturewid.clear();
            wragLive.clear();
            TuretArray.clear();
            stage.addActor(table);
            TuretHP.clear();
            xMir=0;
            yMir=0;
            money=10;
            player.turetColVo=0;
                    updateMenu.xp = 10;
            updateMenu.dmg = 1;
            updateMenu.range = 100;
            updateMenu.timer = 50;
            updateMenu.turetLimit = 10;
        }

        if (StartFlag) {
            startmenu(batch,load);
        } else {
            if (sloznost>0 ) {
                if ((sloznost<30)&&(wragX.size()<10)) {
                    wragGenerate();
                    sloznost--;
                }else if (((sloznost<100)&&(wragX.size()<50))){
                    wragGenerate();
                    sloznost--;
                    wrag2Generator();
                    sloznost-=10;
                }else if (((sloznost<300))){
                    wragGenerate();
                    sloznost--;
                    wrag2Generator();
                    sloznost-=10;
                    wrag3Generator();
                   sloznost-=100;
                }

            }
if(UpDateMenFlag) {




    updateMenu.render();

}else{       play(batch, character, wrag1Texture);}
        }


    }

    static void play(Batch batch, TextureAtlas character, TextureAtlas wrag1Texture) {


        batch.draw(backgraund,0,0,800,480);

        for (int i = 0; i < wragX.size(); i++) {

            Wrag1.move(batch, wrag1Texture,wragX.get(i),wragY.get(i),i,wragTexturewid.get(i));
            }

        for (int i = 0; i < TuretArray.size(); i++) {

            TuretArray.get(i).Drav(batch,i);
        }
        try {
            Thread.sleep( (100));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        player.move(batch, character);

    }

    static void startmenu(Batch batch,Texture load) {
batch.draw(load,300,270,200,200);
        stage.act();
        stage.draw();

    }


static  void wragGenerate(){
    Random random = new Random();
    int position_x = random.nextInt(200);
    int position_y = random.nextInt(200);
    int wragTextur = random.nextInt(8)+1;
    if(position_x<100){position_x=-80-position_x+xMir;}else {
        position_x=870+position_x+xMir;
    }
    if(position_y<100){position_y=-60-position_y+yMir;}else{
        position_y=499+position_y+yMir;
    }
wragTexturewid.add(wragTextur);wragFlag.add(1);
  wragX.add(position_x);wragY.add(position_y);
  wragLive.add(1);wragStrong.add(1);

}
    static  void wrag2Generator(){
        Random random = new Random();
        int position_x = random.nextInt(200);
        int position_y = random.nextInt(200);
        int wragTextur = random.nextInt(2)+1;
        if(position_x<100){position_x=-80-position_x+xMir;}else {
            position_x=870+position_x+xMir;
        }
        if(position_y<100){position_y=-60-position_y+yMir;}else{
            position_y=499+position_y+yMir;
        }

        wragTexturewid.add(wragTextur);wragFlag.add(1);
        wragX.add(position_x);wragY.add(position_y);
        wragLive.add(10);wragStrong.add(2);


    }
    static  void wrag3Generator(){
        Random random = new Random();
        int position_x = random.nextInt(200);
        int position_y = random.nextInt(200);
        int wragTextur = random.nextInt(8)+1;
        if(position_x<100){position_x=-80-position_x+xMir;}else {
            position_x=870+position_x+xMir;
        }
        if(position_y<100){position_y=-60-position_y+yMir;}else{
            position_y=499+position_y+yMir;
        }

        wragTexturewid.add(wragTextur);wragFlag.add(1);
        wragX.add(position_x);wragY.add(position_y);
        wragLive.add(10);wragStrong.add(3);


    }



}
