package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class screen {
    public screen() {
    }
    static void render(Batch batch, Texture img, TextureAtlas character){
load(batch,img);
//startmenu
play(batch,character);




    }
static  void play(Batch batch,TextureAtlas character){
        Player.move(batch,character);





}











     static void load(Batch batch, Texture img){
         Gdx.gl.glClearColor(0, 0, 0, 1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         batch.draw(img, 150, 0,500,500);
         try {
             Thread.sleep(1000);                 //1000 milliseconds is one second.
         } catch(InterruptedException ex) {
             Thread.currentThread().interrupt();
         }
    }






}
