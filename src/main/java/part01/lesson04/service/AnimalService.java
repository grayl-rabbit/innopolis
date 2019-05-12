package main.java.part01.lesson04.service;/*
 *  11.05.2019
 *  main.java.part01.lesson04.service
 *  innopolis
 *  @author L
 */

import main.java.part01.lesson04.Animal;
import main.java.part01.lesson04.Person;
import main.java.part01.lesson04.dto.AnimalDto;

import java.util.List;
import java.util.UUID;

public interface AnimalService {
    List<Animal> findByNickname(String nickname, List<Animal> animals);
    List<Animal> update(UUID id, AnimalDto newAnimal, List<Animal> animals);
    Animal findByUUID(UUID id, List<Animal> animals);
    List<Animal> sorting(List<Animal> animals);
}
