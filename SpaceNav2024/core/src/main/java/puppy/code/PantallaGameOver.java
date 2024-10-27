package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class PantallaGameOver extends Pantalla implements Screen {

	private SpaceNavigation game;
	private OrthographicCamera camera;
	public PantallaGameOver(SpaceNavigation game) {
		this.game = game;
		//Carga imagen para el background segun nombre de archivo
		initBackground("GameOver.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1200, 800);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		// Dibuja la imagen del fondo
        showBackground();
		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		game.getBatch().begin();
		game.getFont().draw(game.getBatch(), "Game Over !!! ", 120, 400,400,1,true);
		game.getFont().draw(game.getBatch(), "Pincha en cualquier lado para reiniciar ...", 100, 300);
	
		game.getBatch().end();

		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
			Screen ss = new PantallaJuego(game,1,3,0,1,1,10);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
	}
 
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
   
}