package com.ball.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;	
import com.ball.screens.MenuScreen;

public class BallGame extends Game{
	public SpriteBatch batch;
	
	public OrthographicCamera camera;
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.camera = new OrthographicCamera(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		
		setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
