package input.mygdx.game;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.ApplicationListener;
=======

//import com.badlogic.gdx.audio;

import com.badlogic.gdx.ApplicationAdapter;
>>>>>>> game
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;

public class InputGdxGame implements ApplicationListener, GestureListener, InputProcessor{
	SpriteBatch batch;

<<<<<<< HEAD
	private BitmapFont font;

	private Texture texture;
	private Sprite sprite;
=======
	GameM gm = new GameM();

	private float xdD = 120.0f;
	private float xdX = 120.0f;
	private float xdY = 120.0f;
	private float w = 0;
	private float h = 0;
	private BitmapFont xdFont;
	private String xdStrV = "v0.0.12: " ;
	private String xdMsg = xdStrV;

	private ArrayList<Texture> Ts = new ArrayList<Texture>();
	private ArrayList<Sprite> Ss = new ArrayList<Sprite>();



	private void xdHit(ArrayList<Sprite> sl,int iBox){

		int iSprite = gm.xdGetSpriteNoByBoxNo(sl,iBox);
		int i8InBox = xdGetBoxNoBySpriteNo(8);

		xdMsg = "box:" + iBox + " iSprite:" + iSprite + "i8InBox:"+i8InBox;
		if(iBox-i8InBox==3 || -3==iBox-i8InBox ||
				(iBox/3==i8InBox/3)&&(  iBox-i8InBox==1 || -1==iBox-i8InBox)
		){
			gm.xdSwap(sl,iSprite,8);
		}
	}
	private int xdGetBoxNoBySpriteNo(int iSprite){
		float x = Ss.get(iSprite).getX()+xdD/2;
		float y = h - Ss.get(iSprite).getY()-xdD/2;
		int iBox = -1;
		iBox = gm.xdGetBoxNoByXY(x,y,xdX,xdY,xdD);
		return iBox;
	}

	private void xdF2(ArrayList<Sprite> sl,float x,float y){
		int i = gm.xdGetBoxNoByXY(x,y,xdX,xdY,xdD);
		if(-1!=i) xdHit(sl,i);
	}
>>>>>>> game

	private int w,h;

	private String message = "Touch something already!";

	class TouchInfo {
		public float touchX = 0;
		public float touchY = 0;
		public boolean touched = false;
	}
	private Map<Integer,TouchInfo> touches = new HashMap<Integer,TouchInfo>();

	@Override
	public void create () {
		batch = new SpriteBatch();

<<<<<<< HEAD
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
=======
		xdFont = new BitmapFont();
		xdFont.setColor(Color.RED);

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		gm.pbInit(Ss,Ts);
>>>>>>> game
	}

	@Override
	public void render () {
<<<<<<< HEAD
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

		batch.begin();
		sprite.draw(batch);

		//message = "xdmsg";

		font.draw(batch, message, 200, 200);
=======
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			xdF2(Ss,Gdx.input.getX(),Gdx.input.getY());

		}
		batch.begin();
		xdFont.draw(batch, xdMsg, 450, 300);
		gm.pbDraw(batch,Ss);
>>>>>>> game

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();

		for(int i=0;i<Ts.size();i++){
			Ts.get(i).dispose();
		}
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
		return true;
	}

	@Override
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
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
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
		return false;
	}
}
/*
git log --oneline --decorate --graph --all
 */