package ru.job4j.oop.profession;

public class Doctor extends Profession {
    public Pacient[] pacList = new Pacient[1000];
    public void  addPacient(Pacient pacient) {

    }
    public Doctor() {
        super();
    }
    public Doctor(String name) {
        super(name);
    }
}
