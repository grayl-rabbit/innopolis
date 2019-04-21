import part01.lesson01.task03.BubbleSort;
import part01.lesson01.task03.Person;
import part01.lesson01.task03.QuickSort;
import part01.lesson01.task03.Sorting;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Task01 task01 = new Task01();
//        task01.hello();
//        task01.npe();
//        task01.indexOutOfBounds();
//        task01.testError();



        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            try {
                people.add(new Person("Name"+getRandomNumberInRange(0,100), getRandomNumberInRange(-10,100), Person.Sex.getRandom()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        Sorting quickSort = new QuickSort();
        Sorting bubbleSort = new BubbleSort();

        long startTime = System.currentTimeMillis();

//        quickSort.mainSort(people);
//        quickSort.ageSort(people);
//        quickSort.alphabetSort(people);
//        quickSort.sexSort(people);

//        bubbleSort.ageSort(people);
//        bubbleSort.alphabetSort(people);
//        bubbleSort.sexSort(people);

        long stopTime = System.currentTimeMillis();
        long elapsedMillis = stopTime-startTime;
        long elapsedSec = elapsedMillis/1000;
        long elapsedMin = elapsedMillis/60000;
        System.out.printf("Sorting took %d minutes and %s secs and %d milliseconds \n",
                elapsedMin,elapsedSec%60, elapsedMillis%1000);

        printAllPerson(people);


    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        java.util.Random r = new java.util.Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static void printAllPerson(List<Person> people){

        for(int i=0;i<people.size();i++){
            System.out.println("Person: name - " + people.get(i).getName()
                    + "; age - " + people.get(i).getAge()
                    + "; sex - "+ people.get(i).getSex());
        }
    }
}
