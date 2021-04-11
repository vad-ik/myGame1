package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Turet {

    static int dmg;
    static int range;
    static float timer;
int cordX;
int cordY;
float reloading=0;


Texture TuretTexture;
    public Turet(int cordX,int cordY) {
        screen.TuretHP.add( screen.updateMenu.xp);
        this.dmg = screen.updateMenu.dmg;
        this.range =screen.updateMenu.range;
        this.cordX=cordX;
        this.cordY=cordY;
        this.timer = screen.updateMenu.timer;
        this.TuretTexture=MyGdxGame.Turret;

this.reloading=0;
    }
int shot (int x,int y){
        int retur = 0;
        if ((cordY-y<range)&&(cordY-y>-1*range)&&(reloading==0)&&(cordX-x<range)&&(cordX-x>-1*range)){
            retur =dmg;
            reloading=timer;
        }

        return retur;
}
void fight(int index){
    screen.TuretHP.set(index,screen.TuretHP.get(index)-1)  ;

}



    void Drav(Batch batch,int index){

if (screen.TuretHP.get(index)<=0){
    screen.TuretArray.remove(index);
    screen.TuretHP.remove(index);
    screen.player.turetColVo--;

}else  batch.draw(TuretTexture,cordX-screen.xMir,cordY-screen.yMir,40,40);

        if(reloading>0){

reloading--;}




    };




}
