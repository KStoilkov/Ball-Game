package com.ball.game;

import com.badlogic.gdx.Gdx;

public class Config {
	
	public static final float SCREEN_WIDTH = (float)Gdx.graphics.getWidth();
	public static final float SCREEN_HEIGHT = (float)Gdx.graphics.getHeight();
	
	public static final float BRACKET_WIDTH = Config.SCREEN_WIDTH / 13f;
	public static final float COIN_SIZE = Config.SCREEN_WIDTH / 15f;
	public static final float BALL_SIZE = (Config.SCREEN_HEIGHT - Config.SCREEN_WIDTH) / 6f;
	
	public static final float BALL_SPEED = 950f;
	
	public static final float ENTITY_START_SPEED = 450f;
	public static final float ENTITY_UPDATE_SPEED = 0.05f;
	public static final float ENTITY_MAX_SPEED = 850f;
	
}
