package main.java.part01.lesson04;

import java.util.UUID;

public class Animal {
    private UUID id;
    private String nickname;
    private Person owner;
    private int weight;

    public Animal(String nickname, Person owner, int weight) {
        this.id = setId();
        this.nickname = nickname;
        this.owner = owner;
        this.weight = weight;
    }

    public UUID getId() {
        return id;
    }

    public UUID setId() {
        return this.id = UUID.randomUUID();
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
