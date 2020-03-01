package com.pluralsight.generics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;

public class PersonStorageTest {
    private Partner matt = new Partner("Matt", 57);
    private Partner nick = new Partner("Nick", 53);
    private Employee mike = new Employee("Mike", 39);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Test
    public void savesAndLoadPerson() throws Exception {
        Person person = new Person("Bob", 20);
        saver.save(person);

        assertEquals(person, loader.load());
    }

    @Test
    public void savesAndLoadsArraysOfPeople() throws Exception {
        Person[] persons = new Person[2];
        persons[0] = matt;
        persons[1] = nick;

        saver.saveAll(persons);
    }
}
