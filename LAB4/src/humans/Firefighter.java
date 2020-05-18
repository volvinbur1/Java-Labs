package humans;

public class Firefighter extends Human {
    public String Department;
    public String Rank;

    public Firefighter(String name, String surname, String middleName, int age, String department, String rank) {
        super(name, surname, middleName, age);
        Department = department;
        Rank = rank;
    }
}
