package puppy.code;

public class Rocket extends Projectile {

	public Rocket(float x, float y, int xSpeed, int ySpeed) {
		super();
		//load custom image
		loadTexture("rocketProjectile.png");
		initProjectile(x,y,xSpeed*0.5f,1.5f, 60, 100);
		// TODO Auto-generated constructor stub
	}

	 public boolean checkCollision(Ball2 b2) {
	        if(getspr().getBoundingRectangle().overlaps(b2.getArea())){
	        	//aumenta velocidad
	        	setSpeed(getxSpeed()*2f,getySpeed()*1.5f);
	        	// destruye al otro
	            return true;

	        }
	        return false;
	    }
	
}
