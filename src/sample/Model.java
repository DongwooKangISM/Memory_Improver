package sample;

import java.util.Random;

public class Model {

    public int getRandomNumber () {
        return new Random().nextInt(5) + 1;
    }

}
