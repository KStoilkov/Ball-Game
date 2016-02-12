package com.kstoilkov.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kstoilkov.spaceball.Config;

public class Coin extends Actor{
	private final float COIN_SPEED = (Config.V_HEIGHT / Config.V_WIDTH) * 200f;
	private final float COIN_SIZE = (Config.V_HEIGHT / Config.V_WIDTH) * 15f;
	private Texture coinTexture;
	
	public Coin(){
		this.setSize(this.COIN_SIZE, this.COIN_SIZE);
		this.setPosition((Config.V_WIDTH / 2f) - (this.getWidth() / 2f), Config.V_HEIGHT);
		this.coinTexture = new Texture("Coin.png");
	}

	public Circle getBounds() {
		return new Circle(this.getX() + this.getWidth() / 2f, this.getY() + this.getHeight() / 2f, this.COIN_SIZE / 2f);
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		
		this.moveBy(0, -this.COIN_SPEED * delta);
		
		if(this.getY() < -this.getHeight()){
			this.remove();
		}
	}
	
	@Override
	public void draw(Batch batch, float alpha){
		super.draw(batch, alpha);
		
		batch.draw(this.coinTexture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
