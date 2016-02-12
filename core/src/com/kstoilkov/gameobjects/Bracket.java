package com.kstoilkov.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kstoilkov.spaceball.Config;

public class Bracket extends Actor{
	private final float BRACKET_SPEED = (Config.V_HEIGHT / Config.V_WIDTH) * 150f;
	
	private Texture bracketTexture;
	
	public Bracket(Texture texture){
		this.setSize((Config.V_HEIGHT / Config.V_WIDTH) * 20f, GenerateBracketHeight());
		this.setPosition((Config.V_WIDTH / 2f) - (this.getWidth() / 2f), Config.V_HEIGHT);
		this.bracketTexture = texture;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	private float GenerateBracketHeight() {
		float generatedWidth = (float)MathUtils.random(100, 300);
		
		return generatedWidth;
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		
		this.moveBy(0, -this.BRACKET_SPEED * delta);
		
		if(this.getY() < -this.getHeight()) {
			this.remove();
		}
	}
	
	@Override
	public void draw(Batch batch, float alpha){
		super.draw(batch, alpha);
		
		batch.draw(this.bracketTexture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
