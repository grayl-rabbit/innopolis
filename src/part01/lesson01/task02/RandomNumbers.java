package part01.lesson01.task02;/*
 *  21.04.2019
 *  part01.lesson01.task02
 *  innopolis
 *  @author L
 */

public class RandomNumbers {

    public void check(){
        double[] arr = new double[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = getRandomNumberInRange(-80, 10000);
        }

        try {

            for (double k : arr) {

                if(Math.signum(k)<0){
                    throw new Exception("\n -_- awful. this is a negative number: " + k);
                }

                double q = Math.sqrt(k);
                if (Math.pow((int) q, 2) == (int) k) {
                    System.out.println("\n ^.^ lucky number: " + q);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        java.util.Random r = new java.util.Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
