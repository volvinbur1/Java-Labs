package humans;

public class Firefighters extends Humans {
    public String Department;
    public String Rank;

    public Firefighters(String name, String surname, String middleName, int age, String department, String rank) {
        super(name, surname, middleName, age);
        Department = department;
        Rank = rank;
    }
}
