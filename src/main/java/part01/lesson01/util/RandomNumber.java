package main.java.part01.lesson01.util;

import java.util.Random;

/**
 * generate a random number
 * @author L
 */
public class RandomNumber {

    public int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
