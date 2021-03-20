package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class screen {

    static Stage stage;
    static boolean StartFlag = true;
    static Player player = new Player("asd");
   static int sloznost = 10;


    static ArrayList<Goblin>goblins = new ArrayList<>();
    static ArrayList<Integer>wragX = new ArrayList<>();
    static ArrayList<Integer>wragY = new ArrayList<>();


    public screen() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        Skin skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        TextButton newgame = new TextButton("New Game", skin);
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
                StartFlag = false;
                MyGdxGame.red = 0f;
                MyGdxGame.green = 0f;
                MyGdxGame.blue = 0f;
            }
        });


    }


    static void render(Batch batch, TextureAtlas character, TextureAtlas goblin) {


        if (StartFlag) {
            startmenu();
        } else {
            if (sloznost>0 ) {
                 goblins.add(new Goblin()) ;
                 wragGenerate();
                 sloznost--;

            }

            play(batch, character, goblin);
        }


    }

    static void play(Batch batch, TextureAtlas character, TextureAtlas goblin) {
        player.move(batch, character);



        for (int i = 0; i < goblins.size(); i++) {
            Goblin g =goblins.get(i);
            g.move(batch, goblin,wragX.get(i),wragY.get(i),i);
            }

        try {
            Thread.sleep( (100));                 //1000 milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


    }

    static void startmenu() {

        stage.act();
        stage.draw();

    }
static  void wragGenerate(){
    Random random = new Random();
    int position_x = random.nextInt(200);
    int position_y = random.nextInt(200);
    if(position_x<100){position_x=-80-position_x;}else {
        position_x=870+position_x;
    }
    if(position_y<100){position_y=-60-position_y;}else{
        position_y=499+position_y;
    }
  wragX.add(position_x);wragY.add(position_y);
}
    ;


//     static void load(Batch batch, Texture img){
//
//         batch.draw(img, 150, 0,500,500);
//
//
//    }


}
