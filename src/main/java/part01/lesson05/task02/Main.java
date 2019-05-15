package main.java.part01.lesson05.task02;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        RandomUtils randomUtils = new RandomUtils();
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < 3; i++) text.append(randomUtils.getRandomParagraph(randomUtils.getRandomNumberInRange(1, 5)));
        System.out.println(text);

        randomUtils.getFiles(70);

    }






}
