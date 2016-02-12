package com.kstoilkov.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kstoilkov.spaceball.Config;

public class GameStage extends Stage{
	private Texture bracketTexture;
	
	private Ball ball;
	private Actor currentActor;
	
	private float spaceBetweenEntities = 150f;
	
	public GameStage(Viewport port, SpriteBatch batch){
		super(port, batch);
		this.bracketTexture = new Texture("Bracket.png");
		
		this.ball = new Ball();
		this.currentActor = new Bracket(bracketTexture); 
		
		this.addActor(this.ball);
		this.addActor(this.currentActor);
	}
	
	private boolean readyForEntity() {
		if(this.currentActor.getY() + this.currentActor.getHeight() < Config.V_HEIGHT - this.spaceBetweenEntities) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void act(){
		super.act();
		
		if(readyForEntity()){
			Actor actor;
			
			float random = MathUtils.random(0, 10);
			if(random > 1){
				actor = new Bracket(bracketTexture);
				this.spaceBetweenEntities = MathUtils.random(100f, 220f);
			} else {
				actor = new Coin();
				this.spaceBetweenEntities = MathUtils.random(50f, 100f);
			}

			this.spaceBetweenEntities = MathUtils.random(100f, 220f);
			this.currentActor = actor;
			
			this.addActor(actor);
		}
		
		this.checkForCollision();
	}
	
	private void checkForCollision(){
		for(int i = 1; i < this.getActors().size; i++){
			if(this.getActors().get(i) instanceof Bracket){
				if(Intersector.overlaps(this.ball.getBounds(), ((Bracket)this.getActors().get(i)).getBounds())){
					// Overlapping Braket == Dead
					// TODO: set Screen to DeadScreen
					System.out.println("Dead");
				}
			} else {
				Coin coin = (Coin)this.getActors().get(i);
				
				if(Intersector.overlaps(this.ball.getBounds(), coin.getBounds())){
					coin.remove();
				}
			}
		}
	}
	
	public Ball getBall(){
		return this.ball;
	}
}
