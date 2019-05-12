package main.java.part01.lesson04.dto;

import main.java.part01.lesson04.Person;

public class AnimalDto {
    public String nickname;
    public Person owner;
    public int weight;

    public AnimalDto(String nickname, Person owner, int weight) {
        this.nickname = nickname;
        this.owner = owner;
        this.weight = weight;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
