package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Turet {
    int xp;
    int dmg;
    int range;
    int timer;
int cordX;
int cordY;
int reloading;

Texture TuretTexture;
    public Turet(int cordX,int cordY) {
        this.xp = screen.updateMenu.xp;
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
void fight(){
        xp--;

}



    void Drav(Batch batch,int index){
        if (xp<=0){
            screen.TuretArray.remove(index);
        }
        if(reloading>0){
reloading--;}
        batch.draw(TuretTexture,cordX,cordY,40,40);

    };




}
