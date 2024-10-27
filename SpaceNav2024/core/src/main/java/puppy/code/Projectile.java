package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Projectile implements ProjectileCollision{
	//variables velocidad y para cargar el sprite
	private float xSpeed;
	private float ySpeed = 3;
	protected boolean destroyed = false;
	private Sprite spr;
	private Texture txBala;
	
	public Projectile(float x, float y, int xSpeed, int ySpeed) {
		
		loadTexture("Rocket1.png");
		initProjectile(x,y,xSpeed,ySpeed, 20, 45);
		
	}

	
	public Projectile() {
		// TODO Auto-generated constructor stub
	}


	public void update() {
        spr.setPosition(spr.getX()+xSpeed, spr.getY()+ySpeed);
        if (spr.getX() < 0 || spr.getX()+spr.getWidth() > Gdx.graphics.getWidth()) {
            destroyed = true;
        }
        if (spr.getY() < 0 || spr.getY()+spr.getHeight() > Gdx.graphics.getHeight()) {
        	destroyed = true;
        }
        
    }
    
    public void draw(SpriteBatch batch) {
    	spr.draw(batch);
    }
    
    //collision
    @Override
    public boolean checkCollision(Ball2 b2) {
        if(spr.getBoundingRectangle().overlaps(b2.getArea())){
        	// Se destruyen ambos
            this.destroyed = true;
            return true;

        }
        return false;
    }
    
    
  //metodos para sprite
    public Sprite getspr() {
    	return spr;
    }
    public void loadTexture(String ImageName) {
    	//cargar imagen del proyectil
    	this.txBala = new Texture(Gdx.files.internal(ImageName));
    	spr = new Sprite(txBala);
    }
    
    public void initProjectile(float x, float y, float xSpeed, float ySpeed, int sizeX, int sizeY) {
    	spr.setPosition(x, y);
        this.xSpeed = xSpeed;
        if(ySpeed!=0) {
        	this.ySpeed = ySpeed;
        }
        
        //rotacion
        spr.setRotation(xSpeed*-15);
        // establecer tamaño del rocket
        spr.setBounds(x, y, sizeX, sizeY);
    }

    //speed
    public float getxSpeed() {
    	return this.xSpeed;
    }
    
    public float getySpeed() {
    	return this.ySpeed;
    }
    
    public void setSpeed(float x, float y) {
    	this.xSpeed = x;
    	this.ySpeed = y;
    }
    
    public boolean isDestroyed() {return destroyed;}
	
}
