package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;



public class Nave4 {
	
	private boolean destruida = false;
    private int vidas = 3;
    private float xVel = 0;
    private float yVel = 0;
    private Sprite spr;
    private Sound sonidoHerido;
    private Sound soundBala;
    private Texture txBala;
    private boolean herido = false;
    private int tiempoHeridoMax=50;
    private int tiempoHerido;
    //Input de la nave 
    ShipController inputHandler;
    private PantallaJuego juego;
    
    public Nave4(int x, int y, Texture tx, Sound soundChoque, Sound soundBala, PantallaJuego juego) {
    	sonidoHerido = soundChoque;
    	this.soundBala = soundBala;
    	//cargar imagen del proyectil
    	this.txBala = new Texture(Gdx.files.internal("Rocket1.png"));
    	spr = new Sprite(tx);
    	spr.setPosition(x, y);
    	//spr.setOriginCenter();
    	spr.setBounds(x, y, 45, 45);
    	//init controller, con referencia de esta nave
    	inputHandler = new ShipController(this);
    	Gdx.input.setInputProcessor(inputHandler);
    	//referencia de pantalla juego
    	setJuego(juego);

    }
    public void draw(SpriteBatch batch, PantallaJuego juego){
        float x =  spr.getX();
        float y =  spr.getY();
        
        if (!herido) {
	        
	        // que se mantenga dentro de los bordes de la ventana
	        inputHandler.CheckScreenLimits();
	       //Actualizar posicion de la nave segun input
	        spr.setPosition(x+inputHandler.getXspeed(), y+inputHandler.getYspeed());   
         
 		    spr.draw(batch);
        } else {
        	// Shake si esta herido
           spr.setX(spr.getX()+MathUtils.random(-2,2));
 		   spr.draw(batch); 
 		  spr.setX(x);
 		   tiempoHerido--;
 		   if (tiempoHerido<=0) herido = false;
 		 }               
    }
    
    //Spawn bala
    public void spawnBala() {
    	
    	Projectile  bala = new Bullet(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,(int)inputHandler.getXspeed(),(int)inputHandler.getYspeed()*3);
    	getJuego().agregarProyectil(bala);
    	//Reproducir sonido de la bala a un determinado volumen 
	      soundBala.setVolume(soundBala.play(), 0.45f);
    }
    
    //spawn rocket
    
    public void spawnRocket() {
    	Projectile  rocket = new Rocket(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,(int)inputHandler.getXspeed(),(int)inputHandler.getYspeed()*3);
    	getJuego().agregarProyectil(rocket);
    	//Reproducir sonido de la bala a un determinado volumen 
	    soundBala.setVolume(soundBala.play(), 0.55f);
    }
    
    public boolean checkCollision(Ball2 b) {
        if(!herido && b.getArea().overlaps(spr.getBoundingRectangle())){
        	// rebote
            if (xVel ==0) xVel += b.getXSpeed()/2;
            if (b.getXSpeed() ==0) b.setXSpeed(b.getXSpeed() + (int)xVel/2);
            xVel = - xVel;
            b.setXSpeed(-b.getXSpeed());
            
            if (yVel ==0) yVel += b.getySpeed()/2;
            if (b.getySpeed() ==0) b.setySpeed(b.getySpeed() + (int)yVel/2);
            yVel = - yVel;
            b.setySpeed(- b.getySpeed());
            // despegar sprites
      /*      int cont = 0;
            while (b.getArea().overlaps(spr.getBoundingRectangle()) && cont<xVel) {
               spr.setX(spr.getX()+Math.signum(xVel));
            }   */
        	//actualizar vidas y herir
            vidas--;
            herido = true;
  		    tiempoHerido=tiempoHeridoMax;
  		    sonidoHerido.play();
            if (vidas<=0) 
          	    destruida = true; 
            return true;
        }
        return false;
    }
    
    public boolean estaDestruido() {
       return !herido && destruida;
    }
    public boolean estaHerido() {
 	   return herido;
    }
    
    public int getVidas() {return vidas;}
    //public boolean isDestruida() {return destruida;}
    public int getX() {return (int) spr.getX();}
    public int getY() {return (int) spr.getY();}
	public void setVidas(int vidas2) {vidas = vidas2;}
	//obtener sprite
	public Sprite getSprite() {
		return this.spr;
	}
	public PantallaJuego getJuego() {
		return juego;
	}
	public void setJuego(PantallaJuego juego) {
		this.juego = juego;
	}
}
