package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Pantalla implements Screen {
	//Background
    private Texture background;
    private SpriteBatch batchBackground;
	
	public Pantalla() {
		// TODO Auto-generated constructor stub
		//Background 
		initBackground("fondo.png");
	}

	@Override
	public void show() {
				
	}
																																					
	@Override
	public void render(float delta) {
		
	}

	//Background
	public void initBackground(String ImageName) {
		batchBackground = new SpriteBatch();
		background = new Texture(Gdx.files.internal(ImageName));
	}
	
	public void showBackground() {
		//Dibuja Background
        batchBackground.begin();
        batchBackground.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Dibuja la textura en toda la pantalla
        batchBackground.end();
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
