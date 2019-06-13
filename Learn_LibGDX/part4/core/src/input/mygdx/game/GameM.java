package input.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GameM {
    class jsTest {
        public void runDisplay() {
            try {
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("JavaScript");
                System.out.println("okay1");
               // FileInputStream fileInputStream = new FileInputStream("C:/Users/Kushan/eclipse-workspace/sureson.lk/src/main/webapp/js/back_end_response.js");
                System.out.println("okay2");
                if (true){//fileInputStream != null){
                   // BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
                    engine.eval("var a=1;function ftn1(i){var x=17809; var r = x+i+',test'; return r;};");
                    System.out.println("okay3");
                    // Invocable javascriptEngine = null;
                    System.out.println("okay4");
                    Invocable invocableEngine = (Invocable)engine;
                    System.out.println("okay5");
                    int x=1;
                    System.out.println("invocableEngine is : "+invocableEngine);
                    Object result = invocableEngine.invokeFunction("ftn1",x);
                    System.out.println(result + " x=" + x);

                    System.out.println("okay6");
                }
            }catch(Exception e) {
                System.out.println("erroe when calling js function"+ e);
            }
        }
    }

    jsTest jst = new jsTest();
    BitmapFont mBF = new BitmapFont();
    int B[] = {0,1,2,3,4,5,6,7,8};
    int A[] = {0,1,2,3,4,5,6,7,8};

    private float xdD = 120.0f;
    private float xdX = 120.0f;
    private float xdY = 120.0f;

    public void pbDrawVer(SpriteBatch sb,int sc){

        jst.runDisplay();
        mBF.setColor(Color.RED);
        mBF.draw(sb,"pbDrawVer:v0.0.1: sc=" + sc ,500,400);

    }

}
