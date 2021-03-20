package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import jdk.vm.ci.amd64.AMD64;

public class Player {
    int xp;
    String Name;
    int lvl;
   static int life;
static int Falg=1;
    static boolean w;
    static boolean a;
    static boolean s;
    static boolean d;
    static public int x;
    static public int y;

    public Player(String name) {
        this.xp = 0;
        Name = name;
        this.lvl = 1;
        life = 100;

x=380;
y=200;
        w=false;
        a=false;
        s=true;
        d=false;

    }

    public static void move(Batch batch, TextureAtlas character) {
lifeRender(life);








        if(Gdx.input.isKeyPressed(Input.Keys.W)){
         w=true;
            a=false;
            s=false;
            d=false;
            if(y<400){y=y+10;}
            if (Falg==1){

                drawSprite(batch,character,"wa");
                Falg=2;
            }else  if (Falg==2){

                drawSprite(batch,character,"w");

                Falg=3;
            } else if (Falg==3){


                drawSprite(batch,character,"wd");
               Falg=4;
            }else  if (Falg==4){

                drawSprite(batch,character,"w");

                Falg=1;
            }








        }else
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                w=false;
                a=true;
                s=false;
                d=false;
if(x>0) {
    x = x - 10;
}
if (Falg==1){

                    drawSprite(batch,character,"aa");
                    Falg=2;
                }else  if (Falg==2){

                    drawSprite(batch,character,"a");

                    Falg=3;
                } else if (Falg==3){


                    drawSprite(batch,character,"ad");
                    Falg=4;
                }else  if (Falg==4){

                    drawSprite(batch,character,"a");

                    Falg=1;
                }



            }else
            if(Gdx.input.isKeyPressed(Input.Keys.S)){
                    w=false;
                    a=false;
                    s=true;
                    d=false;
                 if(y>0){   y=y-10;}
                if (Falg==1){

                    drawSprite(batch,character,"sa");
                    Falg=2;
                }else  if (Falg==2){

                    drawSprite(batch,character,"s");

                    Falg=3;
                } else if (Falg==3){


                    drawSprite(batch,character,"sd");
                    Falg=4;
                }else  if (Falg==4){

                    drawSprite(batch,character,"s");

                    Falg=1;
                }




                }else
            if(Gdx.input.isKeyPressed(Input.Keys.D)){
                        w=false;
                        a=false;
                        s=false;
                        d=true;
                       if(x<760){ x=x+10;}
                if (Falg==1){

                    drawSprite(batch,character,"da");
                    Falg=2;
                }else  if (Falg==2){

                    drawSprite(batch,character,"d");

                    Falg=3;
                } else if (Falg==3){


                    drawSprite(batch,character,"dd");
                    Falg=4;
                }else  if (Falg==4){

                    drawSprite(batch,character,"d");

                    Falg=1;
                }

            }else if (s==true){
                drawSprite(batch,character,"s");
            }else if (w==true){
                drawSprite(batch,character,"w");
            }else if (a==true){
                drawSprite(batch,character,"a");
            }else if (d==true){
                drawSprite(batch,character,"d");
            }







    }
    private static void drawSprite(Batch batch, TextureAtlas textureAtlas, String name) {
        Sprite sprite = textureAtlas.createSprite(name);

        sprite.setPosition(x ,y);
sprite.setSize(40,80);
        sprite.draw(batch);

    }



    static void lifeRender(int life){
        Stage stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        //table.setFillParent(true);
        table.setPosition(180,400);
        Skin skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        ProgressBar lifee = new ProgressBar(0,100,1,false,skin);
lifee.act(life);


                // TextButton lifee = new TextButton("New Game", skin);

        table.add(lifee).fill(0.3f,0.3f);
        table.row().pad(10, 0, 10, 0);
        stage.addActor(table);
        stage.act();
        stage.draw();

//        lifee.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                Gdx.app.exit();
//            }
//        });
    }


















}
