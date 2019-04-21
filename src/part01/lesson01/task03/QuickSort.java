package part01.lesson01.task03;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;


public class QuickSort implements Sorting {
    @Override
    public List<Person> sexSort(List<Person> people) {
        Comparator<Person> comparator= comparing(Person::getSex)
                .thenComparing(checkDouble());
        Collections.sort(people, comparator);
        return people;
    }

    @Override
    public List<Person> ageSort(List<Person> people) {
        Comparator<Person> comparator= comparing(Person::getAge).reversed()
                .thenComparing(checkDouble());
        Collections.sort(people, comparator);

        return people;
    }


    @Override
    public List<Person> alphabetSort(List<Person> people) {
        Comparator<Person> comparator= comparing(Person::getName)
                .thenComparing(checkDouble());
        Collections.sort(people, comparator);
        return people;
    }

    public List<Person> mainSort(List<Person> people){
        Comparator<Person> comparator= comparing(Person::getSex)
                .thenComparing(comparing(Person::getAge).reversed())
                .thenComparing(Person::getName)
                .thenComparing(checkDouble());
        Collections.sort(people, comparator);

        return people;
    }

    private Comparator<Person> checkDouble() {
        return (o1, o2) -> {
            try{
                if(o1.getName().equals(o2.getName()) && o1.getAge() == o2.getAge()){
                    throw new Exception("Same data person: name - " + o1.getName()+"; age - " + o1.getAge());
                }
            }catch (Exception e) {
                System.out.println(e);
            }
            return 0;
        };
    }

}
