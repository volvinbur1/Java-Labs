package com.company;

import com.google.gson.Gson;

import java.util.Objects;

public class Person {
    public final String Name;
    public final String LastName;
    public final int Age;
    public final double High;
    public final boolean Married;

    Person(String name, String lastName, int age, double high, boolean married) {
        Name = name;
        LastName = lastName;
        Age = age;
        High = high;
        Married = married;
    }

    static public String SerializeJson(Person obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    static public Person DeserializeJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Person.class);
    }

    @Override
    public final boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;

        Person person = (Person)o;

        boolean nameEquality, lastNameEquality;

        if (Name == null) {
            nameEquality = person.Name == null;
        }
        else
            nameEquality = this.Name.equals(person.Name);

        if (LastName == null) {
            lastNameEquality = person.LastName == null;
        }
        else
            lastNameEquality = this.LastName.equals(person.LastName);
        return nameEquality && lastNameEquality && this.Age == person.Age && Double.compare(this.High, person.High) == 0 && this.Married == person.Married;
    }

    @Override
    public final int hashCode(){
        return Objects.hash(Name, LastName, Age, High, Married);
    }

    @Override
    public String toString() {
        Class c = this.getClass();
        return c.getName() + "\t" + this.Name + "\t" + this.LastName + "\t" + this.Age + "\t" + this.High + "\t" + this.Married;
    }
}
