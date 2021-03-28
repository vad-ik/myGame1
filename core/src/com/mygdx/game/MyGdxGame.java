package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	TextureAtlas character;
	TextureAtlas wrag1Texture;
	static Texture Turret;
	boolean loader = false;
	static screen sc;
	public static float red =0f;
	public static float blue =0f;
	public static float green =0f;
	static Texture load;


	@Override
	public void create () {
		Turret = new Texture("Turet.png");
		load = new Texture("loaddd2.jpg");
		character= new TextureAtlas("character.txt");
		wrag1Texture= new TextureAtlas("wrag1.txt");
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
  sc=new screen();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(red, green, blue, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();










		 sc.render(batch,character,wrag1Texture,load);


		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		wrag1Texture.dispose();
character.dispose();
load.dispose();
Turret.dispose();
		Player.skinText.dispose();
		Player.skin.dispose();
		screen.skin.dispose();
	}
}
