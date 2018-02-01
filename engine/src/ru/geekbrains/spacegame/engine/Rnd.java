package ru.geekbrains.spacegame.engine;

import java.util.Random;

/**
 * Random number
 */
public class Rnd {
    private static final Random random = new Random();

    /**
     * To get rnd number
     * @param min minimum number
     * @param max max nunmber
     * @return result
     */
    public static float nextFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }
}
