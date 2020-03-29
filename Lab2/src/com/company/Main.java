package com.company;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Name", "LastName", 100, 1.75, true);
        Person person2 = new Person("Name", "LastName", 100, 1.75, true);

        person1 = Person.DeserializeJson(Person.SerializeJson(person1));
        person2 = Person.DeserializeJson(Person.SerializeJson(person2));

        System.out.println(person1.equals(person2));
    }
}
