package main.java.part01.lesson01;

import main.java.part01.lesson01.task01.TestExceptions;
import main.java.part01.lesson01.task02.SqrtRandomNumber;
import main.java.part01.lesson01.task03.BubbleSortringServiceImpl;
import main.java.part01.lesson01.task03.Person;
import main.java.part01.lesson01.task03.QuickSortingServiceImpl;
import main.java.part01.lesson01.task03.SortingService;
import main.java.part01.lesson01.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Main class for lesson 01-02
 * @author L
 */
public class Main {


    public static void main(String[] args) {

        TestExceptions task01 = new TestExceptions();
        task01.printAll();

        SqrtRandomNumber numbers = new SqrtRandomNumber();
        numbers.check(100);

        List<Person> people = createPersonList(1000);

        SortingService quickSort = new QuickSortingServiceImpl();
        SortingService bubbleSort = new BubbleSortringServiceImpl();

        long startTime = System.currentTimeMillis();

//        quickSort.mainSort(people);
        quickSort.ageSort(people);
//        quickSort.alphabetSort(people);
//        quickSort.sexSort(people);

//        bubbleSort.ageSort(people);
//        bubbleSort.alphabetSort(people);
//        bubbleSort.sexSort(people);

        long stopTime = System.currentTimeMillis();
        long elapsedMillis = stopTime-startTime;
        long elapsedSec = elapsedMillis/1000;
        long elapsedMin = elapsedMillis/60000;
        System.out.printf("SortingService took %d minutes and %s secs and %d milliseconds \n",
                elapsedMin,elapsedSec%60, elapsedMillis%1000);

        printAllPerson(people);


    }



    private static void printAllPerson(List<Person> people){

        for(int i=0;i<people.size();i++){
            System.out.println("Person: name - " + people.get(i).getName()
                    + "; age - " + people.get(i).getAge()
                    + "; sex - "+ people.get(i).getSex());
        }
    }

    private static List<Person> createPersonList(int count){
        RandomNumber number = new RandomNumber();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            try {
                people.add(new Person("Name" + number.getRandomNumberInRange(0,100),
                        number.getRandomNumberInRange(-10,100), Person.Sex.getRandom()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return people;
    }


}
