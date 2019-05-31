package input.mygdx.game;
<<<<<<< HEAD

import com.badlogic.gdx.ApplicationAdapter;
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> part5demo3
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.Input.Buttons;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

<<<<<<< HEAD
public class InputGdxGame implements ApplicationListener,InputProcessor{
=======
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;

public class InputGdxGame implements ApplicationListener, GestureListener, InputProcessor{
>>>>>>> part5demo3
	SpriteBatch batch;

	private BitmapFont font;

	private Texture texture;
	private Sprite sprite;

<<<<<<< HEAD
	private float posX, posY;
=======
	private int w,h;

	private String message = "Touch something already!";

	class TouchInfo {
		public float touchX = 0;
		public float touchY = 0;
		public boolean touched = false;
	}
	private Map<Integer,TouchInfo> touches = new HashMap<Integer,TouchInfo>();
>>>>>>> part5demo3

	@Override
	public void create () {
		batch = new SpriteBatch();

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		font = new BitmapFont();
		font.setColor(Color.BLUE);

		//texture = new Texture(Gdx.files.internal("data/0001.png"));
		texture = new Texture("badlogic.jpg");
		sprite = new Sprite(texture);
		sprite.setPosition(w/2 -sprite.getWidth()/2, h/2 - sprite.getHeight()/2);



		InputMultiplexer im = new InputMultiplexer();
		GestureDetector gd = new GestureDetector(this);
		im.addProcessor(gd);
		im.addProcessor(this);


		Gdx.input.setInputProcessor(im);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
				sprite.translateX(-1f);
			else
				sprite.translateX(-10.0f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
				sprite.translateX(1f);
			else
				sprite.translateX(10.0f);
		}
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,
					Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
		}
		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
			sprite.setPosition(Gdx.graphics.getWidth()/2 -sprite.getWidth()/2,
					Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		}
		batch.begin();
		sprite.draw(batch);

		//message = "xdmsg";

		font.draw(batch, message, 200, 200);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
<<<<<<< HEAD
	public boolean keyDown(int keycode) {
		float moveAmount = 1.0f;
		if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			moveAmount = 10.0f;

		if(keycode == Keys.LEFT)
			posX-=moveAmount;
		if(keycode == Keys.RIGHT)
			posX+=moveAmount;
=======
	public void pinchStop(){

	}
	@Override
	public boolean panStop(float x,
						   float y,
						   int pointer,
						   int button){
		return true;
	}
	@Override
	public boolean touchDown(float x,
							 float y,
							 int pointer,
							 int button){
		return true;
	}
	@Override
	public boolean tap(float x, float y, int count, int button) {
		message = "Tap performed, finger" + Integer.toString(button);
>>>>>>> part5demo3
		return true;
	}

	@Override
<<<<<<< HEAD
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(button == Buttons.LEFT){
			posX = screenX - sprite.getWidth()/2;
			posY = Gdx.graphics.getHeight() - screenY - sprite.getHeight()/2;
		}
		if(button == Buttons.RIGHT){
			posX = Gdx.graphics.getWidth()/2 - sprite.getWidth()/2;
			posY = Gdx.graphics.getHeight()/2 - sprite.getHeight()/2;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
=======
	public boolean longPress(float x, float y) {
		message = "Long press performed";
		return true;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		message = "Fling performed, velocity:" + Float.toString(velocityX) +
				"," + Float.toString(velocityY);
		return true;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		message = "Pan performed, delta:" + Float.toString(deltaX) +
				"," + Float.toString(deltaY);
		return true;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		message = "Zoom performed, initial Distance:" + Float.toString(initialDistance) +
				" Distance: " + Float.toString(distance);
		return true;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
						 Vector2 pointer1, Vector2 pointer2) {
		message = "Pinch performed";
		return true;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		message = "Touch Down";
		Gdx.app.log("INFO", message);

		return false;
	}


	@Override
	public boolean keyDown(int keycode) {
		message = "Key Down";
		Gdx.app.log("INFO", message);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		message = "Key up";
		Gdx.app.log("INFO", message);
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		message = "Key typed";
		Gdx.app.log("INFO", message);
		return true;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		message = "Touch up";
		Gdx.app.log("INFO", message);
>>>>>>> part5demo3
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
<<<<<<< HEAD
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
=======
		message = "Touch Dragged";
		Gdx.app.log("INFO", message);
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		message = "Mouse moved";
		Gdx.app.log("INFO", message);
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		message = "Scrolled";
		Gdx.app.log("INFO", message);
>>>>>>> part5demo3
		return false;
	}
}
/*
git log --oneline --decorate --graph --all
 */