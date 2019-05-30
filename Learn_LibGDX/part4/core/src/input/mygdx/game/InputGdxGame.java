package input.mygdx.game;
import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InputGdxGame implements ApplicationListener, InputProcessor{
	SpriteBatch batch;

	private BitmapFont font;

	private Texture texture;
	private Sprite sprite;

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

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();


		//font = new BitmapFont(Gdx.files.internal("data/arial-15.fnt"),false);
		//font.setColor(Color.RED);

		font = new BitmapFont();
		font.setColor(Color.BLUE);

		//texture = new Texture(Gdx.files.internal("data/0001.png"));
		texture = new Texture("badlogic.jpg");
		sprite = new Sprite(texture);
		sprite.setPosition(w/2 -sprite.getWidth()/2, h/2 - sprite.getHeight()/2);

		Gdx.input.setInputProcessor(this);
		for(int i = 0; i < 5; i++){
			touches.put(i, new TouchInfo());
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
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

		message = "xdmsg";
		for(int i = 0; i < 5; i++){
			if(touches.get(i).touched)
				message += "Finger:" + Integer.toString(i) + "touch at:" +
						Float.toString(touches.get(i).touchX) +
						"," +
						Float.toString(touches.get(i).touchY) +
						"\n";

		}
		//float tb = font.getBounds(message);
		float x = w/2 ;//- tb.width/2;
		float y = h/2 ;//+ tb.height/2;
		//font.drawMultiLine(batch, message, x, y);

		font.draw(batch, message, touches.get(0).touchX,touches.get(0).touchY);//200, 200);

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
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(pointer < 5){
			touches.get(pointer).touchX = screenX;
			touches.get(pointer).touchY = screenY;
			touches.get(pointer).touched = true;
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(pointer < 5){
			touches.get(pointer).touchX = 0;
			touches.get(pointer).touchY = 0;
			touches.get(pointer).touched = false;
		}
		return true;
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
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
