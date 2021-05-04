package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Turet {

    static int dmg;
    static int range;
    static float timer;
    int cordX;
    int cordY;
    float reloading = 0;
double rotation=0;

    TextureAtlas TuretTexture;

    public Turet(int cordX, int cordY) {
        Screen.TuretHP.add(Screen.updateMenu.xp);
        this.dmg = Screen.updateMenu.dmg;
        this.range = Screen.updateMenu.range;
        this.cordX = cordX;
        this.cordY = cordY;
        this.timer = Screen.updateMenu.timer;
this.TuretTexture=new TextureAtlas("TuretAtlas.txt");


        this.reloading = 0;
    }

    int shot(int x, int y) {
        int retur = 0;
        if (( cordY - y < range ) && ( cordY - y > -1 * range ) && ( reloading == 0 ) && ( cordX - x < range ) && ( cordX - x > -1 * range )) {
            retur = dmg;
            reloading = timer;

 rotation  = Math.atan2(cordY - y, cordX - x) / Math.PI * 180;
            rotation = (rotation < 0) ? rotation + 180 : rotation;
            rotation+=180;
            if (rotation>=360){rotation-=360;}



            MyGdxGame.sr.rectLine(cordX+10,cordY+10,x+10,y+10,1f);


        }

        return retur;
    }

    void fight(int index) {
        Screen.TuretHP.set(index, Screen.TuretHP.get(index) - 1);

    }


    void Drav(Batch batch, int index) {

        if (Screen.TuretHP.get(index) <= 0) {
            Screen.TuretArray.remove(index);
            Screen.TuretHP.remove(index);
            Screen.player.turetColVo--;

        } else {

            String name= String.valueOf((int)(rotation / 30)*30);
            Sprite sprite = TuretTexture.createSprite(name);

            sprite.setPosition(cordX - Screen.xMir, cordY - Screen.yMir);
            sprite.setSize(Gdx.graphics.getWidth()/15, Gdx.graphics.getHeight()/10);
            sprite.draw(batch);
        }
        if (reloading > 0) {

            reloading--;
        }
    }
}
