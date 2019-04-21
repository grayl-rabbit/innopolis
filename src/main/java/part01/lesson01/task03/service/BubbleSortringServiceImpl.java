package main.java.part01.lesson01.task03.service;

import main.java.part01.lesson01.task03.Person;

import java.util.List;

public class BubbleSortringServiceImpl implements SortingService {
    /**
     * sort by sex(men higher)
     * @param people
     * @return list people
     */
    @Override
    public List<Person> sexSort(List<Person> people) {
        mainSort(people, "sex");
        return people;
    }

    /**
     * sort by age(higher older)
     * @param people
     * @return list people
     */
    @Override
    public List<Person> ageSort(List<Person> people) {
        mainSort(people, "age");
        return people;
    }

    /**
     * sort by alphabet
     * @param people
     * @return list people
     */
    @Override
    public List<Person> alphabetSort(List<Person> people) {
        mainSort(people, "name");
        return people;
    }


    /**
     * sort list by type
     * @param people
     * @param type - sort type(age, sex, alphabet)
     */
    private static void mainSort(List<Person> people, String type) {

        int length = people.size();
        Person person1;
        Person person2;
        boolean is_sorted;

        for (int i = 0; i < length; i++) {
            is_sorted = true;
            for (int j = 1; j < (length - i); j++) {

                person1 = people.get(j-1);
                person2 = people.get(j);
                boolean sortVal = false;

                switch (type){
                    case "sex":
                        sortVal = person1.getSex().compareTo(person2.getSex()) > 0;
                        break;
                    case "age":
                        sortVal = person1.getAge() < person2.getAge();
                        break;
                    case "name":
                        sortVal = person1.getName().compareTo(person2.getName()) > 0;
                        break;
                    default:
                        break;
                }

                if(sortVal) {
                    people.set((j-1), person2);
                    people.set(j, person1);
                    is_sorted = false;
                }

                checkDouble(person1, person2);

            }
            if (is_sorted) break;
        }

    }

    /**
     * check double entries by name and age
     * @param person1
     * @param person2
     */
    private static void checkDouble(Person person1, Person person2) {
        try{
            if(person1.getName().equals(person2.getName()) && person1.getAge() == person2.getAge()){
                throw new Exception("Same data person: name - " + person1.getName()+"; age - " + person1.getAge());
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }


}
