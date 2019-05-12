package main.java.part01.lesson04.service;/*
 *  11.05.2019
 *  main.java.part01.lesson04.service
 *  innopolis
 *  @author L
 */

import main.java.part01.lesson01.task03.Person;
import main.java.part01.lesson04.Animal;
import main.java.part01.lesson04.dto.AnimalDto;

import java.util.*;

import static java.util.Comparator.comparing;

public class AnimalServiceImpl implements AnimalService {

    @Override
    public List<Animal> findByNickname(String nickname, List<Animal> animals) {
        List<Animal> animalList = new ArrayList<>();
        animals.stream()
                .filter(animal -> nickname.equals(animal.getNickname()))
                .forEach(animalList::add);
        return animalList;
    }

    @Override
    public List<Animal> update(UUID id, AnimalDto newAnimal, List<Animal> animals){
        Animal animal = findByUUID(id, animals);
        int i = animals.indexOf(animal);
        animal.setNickname(newAnimal.getNickname());
        animal.setOwner(newAnimal.getOwner());
        animal.setWeight(newAnimal.getWeight());
        animals.set(i, animal);
        return animals;
    }

    @Override
    public Animal findByUUID(UUID id, List<Animal> animals){
        Animal animal = animals.stream()
                .filter(item -> id.equals(item.getId()))
                .findAny()
                .orElse(null);

        return animal;
    }

    @Override
    public List<Animal> sorting(List<Animal> animals){
//        Comparator<Animal> comparator= Comparator.comparing(Person::getName);
//        Comparator<Animal> comparator = Comparator
//                .comparing(animal -> animal.getOwner().getName());
//        Collections.sort(animals, comparator);
        return animals;
    }
}
