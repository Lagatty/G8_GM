package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;


public class ShipController implements InputProcessor {
	//*** X 
	 private float Xspeed = 0;
	 private float MaxXSpeed = 2;  // Maxima velocidad en x
	//*** Y
	 private float Yspeed = 0;
	 private float MaxYSpeed = 2;  // Maxima velocidad en y
	 //Referencia a la nave que se controla
	 private Nave4 NaveRef;
	public ShipController(Nave4 NaveRef) {
		//Guardar referencia de la nave
		this.setNaveRef(NaveRef);
	}

	@Override
	public boolean keyDown(int keycode) {
		//  velocidad en X
		if (keycode == Input.Keys.D) {
			this.setXspeed(MaxXSpeed);
        }
		if (keycode == Input.Keys.A) {
			this.setXspeed(-MaxXSpeed);
        }
		// velocidad en Y
		if (keycode == Input.Keys.W) {			
			this.setYspeed(MaxYSpeed);				
        }
		if (keycode == Input.Keys.S) {								
			this.setYspeed(-MaxYSpeed);			
        }				
		return true;
		
	}
	
	public void CheckScreenLimits() {
		//Limitar en Y
		if (NaveRef.getY()+getYspeed()+ NaveRef.getSprite().getHeight() >= Gdx.graphics.getHeight() || NaveRef.getY()+getYspeed() < 0)
			this.setYspeed(0);
		//Limitar en X
		if (NaveRef.getX()+getXspeed()+ NaveRef.getSprite().getWidth() >= Gdx.graphics.getWidth() || NaveRef.getX()+getXspeed() < 0)
			this.setXspeed(0);
	}

	@Override
	public boolean keyUp(int keycode) {
		//  X = 0
		if (keycode == Input.Keys.D) {
			setXspeed(0);
        }
		if (keycode == Input.Keys.A) {
			setXspeed(0);
        }
		// Y = 0
		if (keycode == Input.Keys.W) {
			setYspeed(0);
        }
		if (keycode == Input.Keys.S) {
			setYspeed(0);
        }
		
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		//Disparo
				if (button  == Input.Buttons.LEFT)
					NaveRef.spawnBala();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}

	public float getXspeed() {
		return Xspeed;
	}

	public void setXspeed(float xspeed) {
		Xspeed = xspeed;
	}

	public Nave4 getNaveRef() {
		return NaveRef;
	}

	public void setNaveRef(Nave4 naveRef) {
		NaveRef = naveRef;
	}

	public float getMaxYSpeed() {
		return MaxYSpeed;
	}

	public void setMaxYSpeed(float maxYSpeed) {
		MaxYSpeed = maxYSpeed;
	}

	public float getYspeed() {
		return Yspeed;
	}

	public void setYspeed(float yspeed) {
		Yspeed = yspeed;
	}

}
