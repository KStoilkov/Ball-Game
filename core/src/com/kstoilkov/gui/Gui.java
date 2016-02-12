package com.kstoilkov.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Gui extends Stage{
	private PlayScreenBackground psBackground;
	
	public Gui(Viewport port, SpriteBatch batch){
		super(port, batch);
		
		this.psBackground = new PlayScreenBackground();
		
		this.addActor(this.psBackground);
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
	}
}
