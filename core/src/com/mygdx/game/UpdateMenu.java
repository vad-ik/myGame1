package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;

import javax.swing.*;

public class UpdateMenu {
    int xp;
    int dmg;
    int range;
    float timer;
int turetLimit;
    static Table table = new Table();
    static Skin skin;


    public UpdateMenu() {
        table.setFillParent(true);
        skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        this.xp = 10;
        this.dmg = 1;
        this.range = 100;
        this.timer = 50;
        this.turetLimit = 20;





        table.pad(10).defaults().expandX().space(4);

        final TextButton xpButton =new TextButton("update xp 10 coins. "+ this.xp,skin);

        final TextButton dmgButton =new TextButton("update dmg 10 coins. "+ this.dmg,skin);
        final TextButton rangeButton =new TextButton("update range 10 coins. "+ this.range,skin);
        final TextButton timerButton =new TextButton("update reloading 10 coins. "+ this.timer,skin);
        final TextButton turetColVoButton =new TextButton("update turetLimit 10 coins. "+ this.turetLimit,skin);
        TextButton Out =new TextButton("out to game",skin);

        table.add(xpButton).height(Gdx.graphics.getHeight()/7);
        table.row().pad(2, 0, 2, 0);

        table.add(dmgButton).height(Gdx.graphics.getHeight()/7);
        table.row().pad(2, 0, 2, 0);
        table.add(rangeButton).height(Gdx.graphics.getHeight()/7);
        table.row().pad(2, 0, 2, 0);
        table.add(timerButton).height(Gdx.graphics.getHeight()/7);
        table.row().pad(2, 0, 2, 0);
        table.add(turetColVoButton).height(Gdx.graphics.getHeight()/7);
        table.row().pad(2, 0, 2, 0);
        table.add(Out).height(Gdx.graphics.getHeight()/7);
        table.row().pad(2, 0, 2, 0);


        xpButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if( screen.money>=10){
                screen.money-=10;
                xp=xp+10;
                xpButton.setText("update xp 10 coins. "+ xp);

                for (int i = 0; i < screen.TuretArray.size(); i++) {

                    screen.TuretHP.set(i,screen.TuretHP.get(i)+10)  ;
                }}
            }
        });

        dmgButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if( screen.money>=10){
                    screen.money-=10;
                    dmg=dmg+1;
                    dmgButton.setText("update dmg 10 coins. "+ dmg);

                    for (int i = 0; i < screen.TuretArray.size(); i++) {
                        screen.TuretArray.get(i).dmg+=1;
                    }}
            }
        });

        rangeButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if( screen.money>=10){
                    screen.money-=10;
                    range=range+10;
                    rangeButton.setText("update range 10 coins. "+ range);

                    for (int i = 0; i < screen.TuretArray.size(); i++) {
                        screen.TuretArray.get(i).range+=1;
                    }}
            }
        });

        timerButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if( screen.money>=10){
                    screen.money-=10;
                    timer-=(timer*0.05);
                    timerButton.setText("update reloading 10 coins. "+ timer);

                    for (int i = 0; i < screen.TuretArray.size(); i++) {
                        screen.TuretArray.get(i).timer=timer;
                    }
                    }
            }
        });

        turetColVoButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if( screen.money>=10){
                    screen.money-=10;
                    turetLimit=turetLimit+1;
                   turetColVoButton.setText("update turetLimit 10 coins. "+ turetLimit);

                    screen.player.TuretLimit++;
                    }
            }
        });


Out.addListener(new ChangeListener() {
    @Override
    public void changed(ChangeEvent event, Actor actor) {


        screen.stage.clear();
        screen.UpDateMenFlag=false;
    }
});







    }








    void render(){

        screen.stage.act();
        screen.stage.draw();


  }






}
