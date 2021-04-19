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
int colVoSkinsConstant =2;

    public Skins() {


        table.setPosition(0,Gdx.graphics.getHeight()/-3);
        table.setFillParent(true);

        character1 = new TextureAtlas("character.txt");
        character2 = new TextureAtlas("character2.txt");
        skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        TextButton skin1 = new TextButton("set", skin);
        TextButton skin2 = new TextButton("set", skin);
        TextButton out = new TextButton("out", skin);


        table.add(out).fillX();
        table.add(skin1).fillX();
        table.add(skin2).fillX();
        table.row().pad(10, 0, 10, 0);

        skin1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MyGdxGame.character = character1;
                MyGdxGame.PlayerWith= Gdx.graphics.getWidth()/15;

                MyGdxGame.Playerheight = Gdx.graphics.getHeight()/8;
                MyGdxGame.PlayerCdvig = 0;
            }
        });
        skin2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MyGdxGame.character = new TextureAtlas("character2.txt");
                MyGdxGame.PlayerWith = Gdx.graphics.getWidth()/10;
                MyGdxGame.Playerheight = Gdx.graphics.getHeight()/5;
                MyGdxGame.PlayerCdvig = 30;
            }
        });

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

        sprite.setPosition(Gdx.graphics.getWidth()/2+80*(colVoSkinsConstant+1)/2-80*(colVoSkinsConstant-0), Gdx.graphics.getHeight()/-3+Gdx.graphics.getHeight()/3*2);
        sprite.setSize(100, 170);
        sprite.draw(batch);
        sprite = character2.createSprite("s");

        sprite.setPosition(Gdx.graphics.getWidth()/2+80*(colVoSkinsConstant+1)/2-80*(colVoSkinsConstant-1), Gdx.graphics.getHeight()/-3+Gdx.graphics.getHeight()/3*2);
        sprite.setSize(160, 170);
        sprite.draw(batch);


    }
}
