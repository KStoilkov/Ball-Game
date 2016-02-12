package com.kstoilkov.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kstoilkov.gameobjects.GameStage;
import com.kstoilkov.gui.Gui;
import com.kstoilkov.spaceball.Config;
import com.kstoilkov.spaceball.SpaceBall;

public class PlayScreen implements Screen{

	private SpaceBall game;
	private OrthographicCamera camera;
	private Viewport viewport;
	
	private Gui gui;
	private GameStage gameStage;
	
	private ShapeRenderer sr;
	
	public PlayScreen(SpaceBall game){
		this.game = game;
		this.camera = new OrthographicCamera();
		this.viewport = new FitViewport(Config.V_WIDTH, Config.V_HEIGHT, this.camera);
		
		this.sr = new ShapeRenderer();
		this.sr.setAutoShapeType(true);
		this.sr.setColor(Color.RED);
	}
	
	@Override
	public void show() {
		this.gui = new Gui(this.viewport, this.game.batch);
		this.gameStage = new GameStage(this.viewport, this.game.batch);
		
		Gdx.input.setInputProcessor(new InputAdapter(){
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button){
				gameStage.getBall().move();
				
				return false;
			}
		});
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.game.batch.setProjectionMatrix(this.camera.combined);

		this.gui.getViewport().apply();
		this.gui.act();
		this.gui.draw();
		
		this.gameStage.getViewport().apply();
		this.gameStage.act();
		this.gameStage.draw();
		
		
		// Red lines for easier debugging
		this.sr.begin();
		this.sr.circle(this.gameStage.getBall().getX() + this.gameStage.getBall().getWidth() / 2f, 
				this.gameStage.getBall().getY() + this.gameStage.getBall().getHeight() / 2f, 
				this.gameStage.getBall().getWidth() / 2f);
		
		int actorsCount = this.gameStage.getActors().size; 
		for (int i = 1; i < actorsCount; i++) {
			this.sr.rect(this.gameStage.getActors().get(i).getX(), 
					this.gameStage.getActors().get(i).getY(), 
					this.gameStage.getActors().get(i).getWidth(), 
					this.gameStage.getActors().get(i).getHeight());
		}
		this.sr.end();
	}

	@Override
	public void resize(int width, int height) {
		this.viewport.update(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}
}
