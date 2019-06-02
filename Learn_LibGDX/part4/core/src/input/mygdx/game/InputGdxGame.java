package input.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InputGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;

	private float xdD = 120.0f;
	private float xdX = 120.0f;
	private float xdY = 120.0f;
	private float w = 0;
	private float h = 0;
	private BitmapFont font;
	private String xdStrV = "v0.0.2: ";
	private String xdMsg = xdStrV;

	private ArrayList<Texture> Ts = new ArrayList<Texture>();
	private ArrayList<Sprite> Ss = new ArrayList<Sprite>();

	private void xdSetxy(Sprite s,float x,float y){
		s.setPosition(x-s.getWidth()/2,h-y-s.getHeight()/2);
	}
	private void xdSwap(ArrayList<Sprite> sl,int i,int j){
			float xI = sl.get(i).getX();
			float yI = sl.get(i).getY();
			float xJ = sl.get(j).getX();
			float yJ = sl.get(j).getY();
			sl.get(i).setPosition(xJ,yJ);
			sl.get(j).setPosition(xI,yI);

	}
	private void xdHit(int iBox){

		String i = xdGetSpriteNoByBoxNo(iBox);
		xdMsg = "box:" + iBox + " i:" + i;
	}
	private String xdGetSpriteNoByBoxNo(int iBox){
		String s = "spriteNo:";
		for(int i=0;i<Ss.size();i++){
			int ii = (int)((Ss.get(i).getX()-xdX/2)/xdD);
			int jj = (int)((Ss.get(i).getY()-xdY/2)/xdD);
			if(iBox==(jj*3+ii))
			{
				s+=i;
			}
		}

		return s;
	}
	private int xdGetBoxNoByXY(float x,float y){
		int r = -1;
		int i = (int)((x-xdX/2)/xdD);

		int j = (int)((y-xdY/2)/xdD);

		if((i>=0&&i<=2)&&(j>=0&&j<=2)){
			r = j*3 + i;
			xdHit(r);
		}
		else{
			xdSwap(Ss,2,3);
		}
		return r;
	}
	private void xdF1(ArrayList<Sprite> sl){
		for (int i = 0; i < sl.size(); i++) {
			sl.get(i).draw(batch);
		}

		font.draw(batch, xdMsg, 420, 300);
	}
	private void xdF2(ArrayList<Sprite> sl,float x,float y){
		int i = xdGetBoxNoByXY(x,y);
	}

	@Override
	public void create () {
		batch = new SpriteBatch();

		font = new BitmapFont();
		font.setColor(Color.RED);

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
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


		for(int i=0;i<Ss.size();i++){
			xdSetxy(Ss.get(i),xdX+xdD*(i%3),xdY+xdD*(i/3));
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
			xdMsg = xdStrV + Gdx.input.getX();
			xdF2(Ss,Gdx.input.getX(),Gdx.input.getY());

		}
		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
			sprite.setPosition(Gdx.graphics.getWidth()/2 -sprite.getWidth()/2,
					Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		}
		batch.begin();
		sprite.draw(batch);

		xdF1(Ss);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();

		Ts.get(0).dispose();
	}
}
