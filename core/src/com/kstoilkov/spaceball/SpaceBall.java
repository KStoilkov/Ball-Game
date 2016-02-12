package com.kstoilkov.spaceball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kstoilkov.screens.PlayScreen;

public class SpaceBall extends Game {
	public SpriteBatch batch;
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		
		this.setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
