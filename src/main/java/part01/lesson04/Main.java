package main.java.part01.lesson04;/*
 *  11.05.2019
 *  main.java.part01.lesson04
 *  innopolis
 *  @author L
 */

import main.java.part01.lesson04.dto.AnimalDto;
import main.java.part01.lesson04.service.AnimalServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        List<Animal> animals = createAnimalList(10);

        AnimalServiceImpl animalService = new AnimalServiceImpl();
        animalService.findByNickname("Nickname1", animals);

        UUID id = animals.get(0).getId();
        AnimalDto dto = new AnimalDto("Update nickname", createPerson(), 999);
        animalService.update(id, dto, animals);
        animalService.sorting(animals);
        printAllAnimals(animals);
    }


    private static List<Animal> createAnimalList(int count){
        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            try {
                animals.add(new Animal("Nickname" + getRandomNumberInRange(0,5),
                        createPerson(), getRandomNumberInRange(0,50)));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return animals;
    }

    private static Person createPerson(){
        return new Person("Name" + getRandomNumberInRange(0,100),
                getRandomNumberInRange(0,100), Person.Sex.getRandom());
    }

    /**
     * generate random number
     * @param min
     * @param max
     * @return
     */
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Print every person
     * @param animals
     */
    private static void printAllAnimals(List<Animal> animals){

        for(int i=0;i<animals.size();i++){
            System.out.println("Animal: Nickname - " + animals.get(i).getNickname()
                    + "; Owner - " + animals.get(i).getOwner().getName()
                    + "; Weight - "+ animals.get(i).getWeight());
        }
    }
}
