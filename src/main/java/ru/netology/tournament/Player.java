package ru.netology.tournament;

public class Player {

    private int id;
    private String name;
    private int strenght;

    public String getName() {
        return name;
    }

    public int getStrenght() {
        return strenght;
    }

    public Player(int id, String name, int strenght) {
        this.id = id;
        this.name = name;
        this.strenght = strenght;
    }
}
