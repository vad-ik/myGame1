package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Skins {
    static Skin skin;
    static Table table = new Table();
    static TextureAtlas character1;
    static TextureAtlas character2;

    public Skins() {


        table.setPosition(-70, -180);
        table.setFillParent(true);

        character1 = new TextureAtlas("character.txt");
        character2 = new TextureAtlas("character2.txt");
        skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        TextButton skin1 = new TextButton("set", skin);
        TextButton skin2 = new TextButton("set", skin);
        //TextButton skin3 = new TextButton("set", skin);
        TextButton out = new TextButton("out", skin);


        table.add(out).fillX();
        table.add(skin1).fillX();
        table.add(skin2).fillX();
        // table.add(skin3).fillX();
        // table.add(skin4).fillX();
        table.row().pad(10, 0, 10, 0);

        skin1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MyGdxGame.character = character1;
                MyGdxGame.PlayerWith = 60;
                MyGdxGame.Playerheight = 90;
                MyGdxGame.PlayerCdvig = 0;
            }
        });
        skin2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MyGdxGame.character = new TextureAtlas("character2.txt");
                MyGdxGame.PlayerWith = 100;
                MyGdxGame.Playerheight = 90;
                MyGdxGame.PlayerCdvig = 30;
            }
        });
//        skin3.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                MyGdxGame.character = new TextureAtlas("character3.txt");
//                MyGdxGame.PlayerWith = 100;
//                MyGdxGame.Playerheight = 90;
//                MyGdxGame.PlayerCdvig = 30;
//            }
//        });

        out.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Screen.skinsFlag = false;
                Screen.stage.clear();
                Screen.skinsFlagws = true;
                Screen.stage.addActor(Screen.table);
                Screen.stage.addActor(Screen.table2Levl);
            }
        });


    }

    void render(Batch batch) {


        Screen.stage.act();
        Screen.stage.draw();
        Sprite sprite = character1.createSprite("s");

        sprite.setPosition(288, 130);
        sprite.setSize(100, 170);
        sprite.draw(batch);
        sprite = character2.createSprite("s");

        sprite.setPosition(372, 95);
        sprite.setSize(160, 170);
        sprite.draw(batch);


    }
}
