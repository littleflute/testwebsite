package input.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;

public class myJSON {
    public class Person {
        private String name;
        private int age;
        private ArrayList numbers;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
        public void setNumbers(ArrayList al){
            this.numbers = al;
        }
    }

    public class PhoneNumber {
        private String name;
        private String number;
        public   PhoneNumber(String sName,String sNumber){
            this.name = sName;
            this.number = sNumber;
        }
    }

    public void pbDraw(SpriteBatch sb) {

        BitmapFont f = new BitmapFont();

        f.setColor(Color.BLUE);
        f.draw(sb,"myJSON:v0.0.1 " ,500,300);

    }
    public void test(){
        Json json = new Json();
        Person person = new Person();
        person.setName("Nate");
        person.setAge(31);
        ArrayList numbers = new ArrayList();
        numbers.add(new PhoneNumber("Home", "206-555-1234"));
        numbers.add(new PhoneNumber("Work", "425-555-4321"));
        person.setNumbers(numbers);
        System.out.println(json.toJson(person));
        System.out.println(json.prettyPrint(person));
    }
}
