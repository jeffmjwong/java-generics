package com.pluralsight.generics;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
//        useCircularBuffer();
//        useMethodGenerics();
//        useInjectorAndLogger();
//        useTypeParametersAndToGenericStringMethods();

        final Person arthur = new Person("Arthur Lee", 29);
        final Person bastian = new Person("Bastian Saw", 30);
        final Person vincent = new Person("Vincent Lim", 28);

        final List<Person> people = new ArrayList<>(Arrays.asList(arthur, bastian, vincent));
        final Map<Boolean, List<Person>> map1 = people.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 29));
        System.out.println(map1);
    }

    private static void useTypeParametersAndToGenericStringMethods() {
        List<String> strings = new ArrayList<>(Arrays.asList("string1", "string2"));
        Class<?> arrayList = strings.getClass();
        TypeVariable<?>[] typeParameters = arrayList.getTypeParameters();
        System.out.println(arrayList);
        System.out.println(arrayList.toGenericString());
        System.out.println(Arrays.toString(typeParameters));
    }

    private static void useInjectorAndLogger() {
        Injector injector = new Injector().with("hello world");
        System.out.println(injector.getObjectGraph());
        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }

    private static void useMethodGenerics() {
        Person p1 = new Person("Arthur Lee", 29);
        Person p2 = new Person("Saw Kah Chun", 30);
        Person p3 = new Person("Chan", 28);

        List<Person> list1 = new ArrayList<>(Arrays.asList(p1, p2, p3));

        final Person youngestPerson = min(list1, new AgeComparator());

        System.out.println(youngestPerson);
    }

    private static <T> T min(List<T> list, Comparator<T> comparator) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum!");
        }

        T lowestElement = list.get(0);

        for (T element : list) {
            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }

        return lowestElement;
    }

    private static void useCircularBuffer() {
        final CircularBuffer<String> buffer = new CircularBuffer<>(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        String value = concatenate(buffer);
        System.out.println(value);
    }

    private static String concatenate(CircularBuffer<String> buffer) {
        StringBuilder builder = new StringBuilder();
        String value;

        while ((value = buffer.poll()) != null) {
            builder.append(value);
        }

        return builder.toString();
    }
}
