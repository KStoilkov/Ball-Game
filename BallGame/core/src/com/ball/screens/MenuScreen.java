package com.ball.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ball.game.BallGame;
import com.ball.game.Config;

public class MenuScreen implements Screen {

	private BallGame ballGame;
	
	private Table table;
	
	private Skin skin;
	private TextButton startButton;
	private TextButtonStyle buttonStyle;
	private Stage stage;
	
	private BitmapFont font;
	
	public FreeTypeFontGenerator generator;
	public FreeTypeFontParameter parameter;
	
	public static TextureAtlas btnTextureAtlas;
	
	public MenuScreen(BallGame ballGame) {
		this.ballGame = ballGame;
	}
	
	@Override
	public void show() {
		this.btnTextureAtlas = new TextureAtlas(Gdx.files.internal("Buttons/StartButton/startButtonPack.atlas"));
		
		this.table = new Table();
		this.skin = new Skin();
		this.skin.addRegions(this.btnTextureAtlas);
		this.stage = new Stage();
		this.font = createFont();
		
		this.stage.setViewport(new FitViewport(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT, this.ballGame.camera));
		
		
		this.buttonStyle = new TextButtonStyle();
		
		this.buttonStyle.up = this.skin.getDrawable("startButton");
		this.buttonStyle.down = this.skin.getDrawable("startButtonPressed");
		this.buttonStyle.font = this.font;
		
		this.startButton = new TextButton("PLAY", this.buttonStyle);
		this.table.setDebug(true);
		this.table.add(this.startButton);
		
		this.stage.addActor(this.table);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.ballGame.camera.update();
		this.ballGame.batch.setProjectionMatrix(this.ballGame.camera.combined);
		
		this.stage.act();
		
		this.ballGame.batch.begin();
		this.stage.draw();
		this.ballGame.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	private BitmapFont createFont() {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/Freshman.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = (int)Config.SCREEN_WIDTH / 30;
		parameter.color = Color.BLACK;
		return generator.generateFont(parameter);
	}
	
}
