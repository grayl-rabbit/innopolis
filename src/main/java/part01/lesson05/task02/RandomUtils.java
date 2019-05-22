package main.java.part01.lesson05.task02;/*
 *  15.05.2019
 *  main.java.part01.lesson05.task02
 *  innopolis
 *  @author L
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.nio.file.StandardOpenOption.CREATE;

public class RandomUtils {

    private static List<String> words;

    public RandomUtils() {
        setWords();
    }


    public List<String> getWords() {
        return words;
    }

    public void setWords() {
        this.words = generateWords(getRandomNumberInRange(1, 1000));
    }

    public static void main(String[] args) {

    }

    /**
     * generate random sentence
     * @param countWord
     * @return string
     */
    public static String getRandomSentence(int countWord, int probability){
        String sentence="";
        String firstWord;
        boolean probabilityResult = getProbabilityResult(probability);
        if(probabilityResult){
            int randomIndex = getRandomNumberInRange(1, words.size()-1);
            firstWord = words.get(randomIndex);
        }else {
            firstWord = getRandomWord(getRandomNumberInRange(1, 15));
        }
        sentence  += firstWord.substring(0,1).toUpperCase() + firstWord.substring(1) + "|";

        for(int i = 0; i < countWord-1; i++) {
            sentence += getRandomWord(getRandomNumberInRange(1, 15)) + "|";
        }

        sentence = sentence.substring(0, sentence.length() - 1) + LastSymbol.getRandom().toString() + " ";
        return sentence.replace("|", SymbolComma.getRandom().toString());
    }


    /**
     * generate random word
     * @param length
     * @return string
     */
    public static String getRandomWord(int length) {
        String r = "";
        for(int i = 0; i < length; i++) {
            r += (char)(Math.random() * 26 + 97);
        }
        return r;
    }

    /**
     * generate random paragraph
     * @param sentenceCount
     * @return string
     */
    public static String getRandomParagraph(int sentenceCount,int probability){
        String paragraph = "";
        for(int i = 0; i < sentenceCount; i++) {
            paragraph += getRandomSentence(getRandomNumberInRange(1, 15), probability);
        }
        return paragraph +"\n\r";
    }

    private enum LastSymbol {
        DOT("."),
        EMPTY(" "),
        QUESTION_MARK("?"),
        EXCLAMATION_MARK("!");

        private String value;
        LastSymbol(String value) {
            this.value = value;
        }

        public String toString()
        {
            return this.value;
        }
        public static LastSymbol getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }
    }


    private enum SymbolComma {
        COMMA(", "),
        EMPTY(" ");

        private String value;
        SymbolComma(String value) {
            this.value = value;
        }

        public String toString()
        {
            return this.value;
        }
        public static SymbolComma getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    /**
     * generate random number
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * get result of probability
     * @param probability
     * @return true/false
     */
    public static boolean getProbabilityResult(int probability) {
        double prob =(double) probability / 100;
        return Math.random() < prob;
    }


    /**
     * generate random words
     * @param count
     * @return String list
     */
    public static List<String> generateWords(int count){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add("Array_"+getRandomWord(getRandomNumberInRange(1, 15)));
        }
        return list;
    }

    public void getFiles( String path, int probability)  {
        Path fileWrite = Paths.get(path);
        boolean probabilityResult = getProbabilityResult(probability);

        String text ="";
        for(int i = 0; i < 10; i++)
//            text.append(getRandomParagraph(getRandomNumberInRange(1, 5), probability));
            text += getRandomParagraph(getRandomNumberInRange(1, 5), probability);
        System.out.println(text);

        System.out.println(text.getBytes());

        byte b = 100;
        byte size = new Byte(b);
//        byte[] byteVal = str.getBytes();
        byte[] data = new byte[1000];

        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(fileWrite, CREATE))) {
            out.write(data, 0, size);
        } catch (IOException x) {
            System.err.println(x);
        }

    }
}
