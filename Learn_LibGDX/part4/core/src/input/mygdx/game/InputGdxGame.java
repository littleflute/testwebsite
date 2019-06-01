package input.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InputGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private ArrayList<Texture> Ts = new ArrayList<Texture>();
	private ArrayList<Sprite> Ss = new ArrayList<Sprite>();


	@Override
	public void create () {
		batch = new SpriteBatch();

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();

		//texture = new Texture(Gdx.files.internal("data/0001.png"));
		texture = new Texture("1.jpg");
		sprite = new Sprite(texture);
		sprite.setPosition(w/2 -sprite.getWidth()/2, h/2 - sprite.getHeight()/2);

		Ts.add(new Texture("1.jpg"));
		Ss.add(new Sprite(Ts.get(0)));
		Ts.add(new Texture("2.jpg"));
		Ss.add(new Sprite(Ts.get(1)));
		Ts.add(new Texture("3.jpg"));
		Ss.add(new Sprite(Ts.get(2)));
		Ts.add(new Texture("4.jpg"));
		Ss.add(new Sprite(Ts.get(3)));
		Ts.add(new Texture("5.jpg"));
		Ss.add(new Sprite(Ts.get(4)));
		Ts.add(new Texture("6.jpg"));
		Ss.add(new Sprite(Ts.get(5)));
		Ts.add(new Texture("7.jpg"));
		Ss.add(new Sprite(Ts.get(6)));
		Ts.add(new Texture("8.jpg"));
		Ss.add(new Sprite(Ts.get(7)));
		Ts.add(new Texture("9.jpg"));
		Ss.add(new Sprite(Ts.get(8)));

		float x = 50.0f;
		float y = 320.0f;
		float d = 120.0f;
		for (int i = 0; i < Ss.size(); i++) {
			Ss.get(i).setPosition(x+d*(i%3),y - d*(i/3));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
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
		for (int i = 0; i < Ss.size(); i++) {
			Ss.get(i).draw(batch);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();

		Ts.get(0).dispose();
	}
}
