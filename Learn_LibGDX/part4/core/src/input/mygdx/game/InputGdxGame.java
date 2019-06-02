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

	int b[] = {0,1,2,3,4,5,6,7,8};
	int a[] = {0,1,2,3,4,5,6,7,8};
	private float xdD = 120.0f;
	private float xdX = 120.0f;
	private float xdY = 120.0f;
	private float w = 0;
	private float h = 0;
	private BitmapFont font;
	private String xdStrV = "v0.0.5: " + xdStart();
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

		int iSprite = xdGetSpriteNoByBoxNo(iBox);
		int i8InBox = xdGetBoxNoBySpriteNo(8);

		xdMsg = "box:" + iBox + " iSprite:" + iSprite + "i8InBox:"+i8InBox;
		if(iBox-i8InBox==3 || -3==iBox-i8InBox ||
				(iBox/3==i8InBox/3)&&(  iBox-i8InBox==1 || -1==iBox-i8InBox)
		){
			xdSwap(Ss,iSprite,8);
		}
	//	xdSwap(Ss,i,8);
	}
	private int xdGetBoxNoBySpriteNo(int iSprite){
		float x = Ss.get(iSprite).getX()+xdD/2;
		float y = h - Ss.get(iSprite).getY()-xdD/2;
		int iBox = -1;
		iBox = xdGetBoxNoByXY(x,y);
		return iBox;
	}
	private int xdGetSpriteNoByBoxNo(int iBox){
		int iRet = -1;
		for(int i=0;i<Ss.size();i++){
			float x = Ss.get(i).getX() + xdD/2;
			float y = h - Ss.get(i).getY() -xdD/2;

			int ii = (int)((x-xdX+xdD/2)/xdD);
			int jj = (int)((y-xdY+xdD/2)/xdD);
			if(iBox==(jj*3+ii))
			{
				iRet = i;
			}
		}

		return iRet;
	}
	private int xdGetBoxNoByXY(float x,float y){
		int r = -1;
		int i = (int)((x-xdX+xdD/2)/xdD);

		int j = (int)((y-xdY+xdD/2)/xdD);

		if((i>=0&&i<=2)&&(j>=0&&j<=2)){
			r = j*3 + i;

		}
		else{
			//xdSwap(Ss,2,3);
		}
		return r;
	}
	private String xdStart(){
//        double r= Math.random();
		String s = "b[]:";
		for(int i=0;i<b.length;i++){
			int n = (int)( Math.random()*11100);
			n%=9;
			while(a[n]==-1){
				n++;
				if(n>8) n=0;
			}
			b[i]=n;
			a[n]=-1;
		}
		for(int i=0;i<b.length;i++){
			s +=b[i] + "::";
		}
        return s;
    }
	private void xdF1(ArrayList<Sprite> sl){
		for (int i = 0; i < sl.size(); i++) {
			sl.get(i).draw(batch);
		}

		font.draw(batch, xdMsg, 420, 300);
	}
	private void xdF2(ArrayList<Sprite> sl,float x,float y){
		int i = xdGetBoxNoByXY(x,y);
		if(-1!=i) xdHit(i);
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
			xdSetxy(Ss.get(b[i]),xdX+xdD*(i%3),xdY+xdD*(i/3));
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
