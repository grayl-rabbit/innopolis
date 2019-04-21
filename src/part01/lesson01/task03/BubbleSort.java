package part01.lesson01.task03;

import java.util.List;

public class BubbleSort implements Sorting {
    @Override
    public List<Person> sexSort(List<Person> people) {
        mainSort(people, "sex");
        return people;
    }

    @Override
    public List<Person> ageSort(List<Person> people) {
        mainSort(people, "age");
        return people;
    }

    @Override
    public List<Person> alphabetSort(List<Person> people) {
        mainSort(people, "name");
        return people;
    }


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
            }
            if (is_sorted) break;
        }

    }

}
