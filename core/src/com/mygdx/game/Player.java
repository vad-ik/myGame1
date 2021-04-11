package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import jdk.vm.ci.amd64.AMD64;
import org.w3c.dom.Text;

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
static int turetColVo;
    static public int x;
    static public int y;
    static public int l;
    static int TuretLimit;
    static ProgressBar lifeBar;
    static TextField socerText;
    static TextField moneyText;
    static TextField turetLImitText;
    static Table table = new Table();
    static Skin skin;
    static Skin skinText;
    static String socerForInt;
static String moneyForInt;
 TextButton Update;

    public Player(String name) {
        turetColVo=0;
        TuretLimit=10;
        table.setPosition(-280,75);
        table.setFillParent(true);
        skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        skinText = new Skin(Gdx.files.internal("terra-mother/skin/terra-mother-ui.json"));
        lifeBar = new ProgressBar(0,100,1,false,skin);



       socerForInt = ("socer: "+screen.score);
       moneyForInt = ("money: "+screen.money);

         Update= new TextButton("Update",skin);
   socerText=new TextField(socerForInt,skinText);
   moneyText=new TextField(moneyForInt,skinText);
String turetlimText = ("Turret "+turetColVo+"/"+TuretLimit);
        turetLImitText=new TextField(turetlimText,skinText);

        table.add(Update).fillX();
        table.row().pad(10, 0, 10, 0);
        table.add(lifeBar).fillX();
        table.row().pad(10, 0, 10, 0);
        table.add(socerText).fillX();
        table.row().pad(10, 0, 10, 0);
        table.add(moneyText).fillX();
        table.row().pad(10, 0, 10, 0);
        table.add(turetLImitText).fillX();
        table.row().pad(10, 0, 10, 0);

        Update.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {


                screen.stage.clear();
                screen.stage.addActor(screen.updateMenu.table);
        screen.UpDateMenFlag=true;
            }
        });


        this.xp = 0;
        Name = name;
        this.lvl = 1;
        life = 100;
        lifeBar.setValue(100);
x=380;
y=200;
        w=false;
        a=false;
        s=true;
        d=false;

    }

    public static void move(Batch batch, TextureAtlas character) {
        TuretLimit=screen.updateMenu.turetLimit;
        String turetlimText = ("Turret "+turetColVo+"/"+TuretLimit);
turetLImitText.setText(turetlimText);


        screen.stage.addActor(table);
        lifeRender(life);
        screen.stage.act();

        screen.stage.draw();

        if((Gdx.input.isKeyPressed(Input.Keys.SPACE))&&(screen.money>0)&&(turetColVo<TuretLimit)) {
screen.TuretArray.add(new Turet(x+screen.xMir,y+screen.yMir));
screen.money--;turetColVo++;
        }



        if(Gdx.input.isKeyPressed(Input.Keys.W)){
         w=true;
            a=false;
            s=false;
            d=false;
            if(y<400){y=y+10;}else {
                screen.yMir+=10;

            }
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
}else {
    screen.xMir-=10;
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
                 if(y>0){   y=y-10;}else {

                     screen.yMir-=10;
                 }
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
                       if(x<760){ x=x+10;}else {
                           screen.xMir+=10;
                       }
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
        if (!moneyText.getText().equals("money: " + String.valueOf(screen.money))) {

        socerForInt= ("socer: "+String.valueOf(screen.score));
        socerText.setText(socerForInt);
        moneyForInt= ("money: "+String.valueOf(screen.money));
        moneyText.setText(moneyForInt);
    }
        if (l!=life) {
            lifeBar.setValue(life);
            l=life;
        }



    }






}
