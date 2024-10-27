package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Ball2 {
	private int x;
    private int y;
    private float xSpeed;
    private float ySpeed;
    private Sprite spr;

    public Ball2(int x, int y, int size, float xSpeed, float ySpeed, Texture tx) {
    	spr = new Sprite(tx);
    	this.x = x; 
    	this.y = y;
    	
        //validar que borde de esfera no quede fuera
    	if (x-size < 0) this.x = x+size;
    	if (x+size > Gdx.graphics.getWidth())this.x = x-size;
                 
        //validar que borde de esfera no quede fuera
    	if (y-size < 0) this.y = y+size;
    	if (y+size > Gdx.graphics.getHeight())this.y = y-size;
    	
        spr.setPosition(x, y);
        
        this.setXSpeed(xSpeed);
        this.setySpeed(ySpeed);
        
        
    }
    public void update() {
        x += getXSpeed();
        y += getySpeed();

        if (x+getXSpeed() < 0 || x+getXSpeed()+spr.getWidth() > Gdx.graphics.getWidth())
        	setXSpeed(getXSpeed() * -1);
        if (y+getySpeed() < 0 || y+getySpeed()+spr.getHeight() > Gdx.graphics.getHeight())
        	setySpeed(getySpeed() * -1);
        spr.setPosition(x, y);
        spr.rotate(getXSpeed());
    }
    
    public Rectangle getArea() {
    	return spr.getBoundingRectangle();
    }
    public void draw(SpriteBatch batch) {
    	spr.draw(batch);
    }
    
    public void checkCollision(Ball2 b2) {
        if(spr.getBoundingRectangle().overlaps(b2.spr.getBoundingRectangle())){
        	// rebote
            if (getXSpeed() ==0) setXSpeed(getXSpeed() + b2.getXSpeed()/2);
            if (b2.getXSpeed() ==0) b2.setXSpeed(b2.getXSpeed() + getXSpeed()/2);
        	setXSpeed(- getXSpeed());
            b2.setXSpeed(-b2.getXSpeed());
            
            if (getySpeed() ==0) setySpeed(getySpeed() + b2.getySpeed()/2);
            if (b2.getySpeed() ==0) b2.setySpeed(b2.getySpeed() + getySpeed()/2);
            setySpeed(- getySpeed());
            b2.setySpeed(- b2.getySpeed()); 
        }
    }
	public float getXSpeed() {
		return xSpeed;
	}
	public void setXSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}
	public float getySpeed() {
		return ySpeed;
	}
	public void setySpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
	
    
}
