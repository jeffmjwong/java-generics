package com.pluralsight.generics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Person> persons = new ArrayList<>(Arrays.asList(matt, nick, mike));
        List<Employee> employees = new ArrayList<>(Arrays.asList(mike));
        List<Partner> partners = new ArrayList<>(Arrays.asList(matt, nick));

        saver.saveAll(persons);
        saver.saveAll(employees);
        saver.saveAll(partners);

        assertEquals(matt, loader.load());
        assertEquals(nick, loader.load());
    }

    @Test
    public void loadsListsOfPeople() throws Exception {
        saver.save(matt);
        saver.save(mike);

        List<Object> people = new ArrayList<>();
        loader.loadAll(people);

        assertEquals(matt, people.get(0));
        assertEquals(mike, people.get(1));
    }
}
