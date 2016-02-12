package com.kstoilkov.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kstoilkov.spaceball.Config;

public class Ball extends Actor{
	public enum BallState {LEFT, RIGHT, MOVING_LEFT, MOVING_RIGHT}
	
	private final float BALL_SIZE = (Config.V_HEIGHT / Config.V_WIDTH) * 35f;
	private final float BALL_SPEED = (Config.V_HEIGHT / Config.V_WIDTH) * 300f;
	
	private Texture ballTexture = new Texture("ball.png");
	private BallState state;
	
	public Ball(){
		this.setSize(BALL_SIZE, BALL_SIZE);
		this.setPosition(0, (Config.V_HEIGHT / 2f) - (this.getHeight() / 2f));
		this.setState(BallState.LEFT);
	}

	public Circle getBounds() {
		return new Circle(this.getX() + this.BALL_SIZE / 2f, this.getY() + this.BALL_SIZE / 2f, this.BALL_SIZE / 2f);
	}
	
	public BallState getState(){
		return this.state;
	}
	
	public void setState(BallState state){
		this.state = state;
	}
	
	private boolean isMoving(){
		if(this.state == BallState.MOVING_LEFT || this.state == BallState.MOVING_RIGHT){
			return true;
		}
		
		return false;
	}
	
	private void keepMoving(float delta){
		if(this.getState() == BallState.MOVING_RIGHT){
			if(this.getX() < Config.V_WIDTH - this.BALL_SIZE){
				this.moveBy(this.BALL_SPEED * delta, 0);
			} else {
				this.setX(Config.V_WIDTH - this.BALL_SIZE);
				this.setState(BallState.RIGHT);
			}
		} else if (this.getState() == BallState.MOVING_LEFT) {
			if(this.getX() > 0){
				this.moveBy(-this.BALL_SPEED * delta, 0);
			} else {
				this.setX(0);
				this.setState(BallState.LEFT);
			}
		}
	}

	public void move(){
		if(this.state == BallState.LEFT){
			this.state = BallState.MOVING_RIGHT;
		} else if(this.state == BallState.RIGHT){
			this.state = BallState.MOVING_LEFT;
		}
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		
		if(this.isMoving()){
			this.keepMoving(delta);
		}
	}
	
	@Override
	public void draw(Batch batch, float alpha){
		super.draw(batch, alpha);
	
		batch.draw(ballTexture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
