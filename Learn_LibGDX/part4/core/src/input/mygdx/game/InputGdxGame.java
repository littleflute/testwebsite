package input.mygdx.game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class InputGdxGame implements ApplicationListener{
	public class MyActor extends Actor {
		Texture texture = new Texture(Gdx.files.internal("data/jet.png"));
		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture,0,0);
		}
	}

	private Stage stage;

	@Override
	public void create () {
		stage = new Stage();

		MyActor myActor = new MyActor();
		stage.addActor(myActor);
	}


	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
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
}
/*
git log --oneline --decorate --graph --all
 */