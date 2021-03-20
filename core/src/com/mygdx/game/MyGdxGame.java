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
	TextureAtlas goblin;
	boolean loader = false;
	screen sc;
	public static float red =0.1f;
	public static float blue =0.4f;
	public static float green =0.4f;
	@Override
	public void create () {

		character= new TextureAtlas("character.txt");
		goblin= new TextureAtlas("goblin.txt");
		batch = new SpriteBatch();
		img = new Texture("loaddd.jpg");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
  sc=new screen();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(red, green, blue, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();










		 sc.render(batch,character,goblin);


		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
character.dispose();
	}
}
