package humans;

public class Policeman extends Human {
    public String Department;
    public String Rank;
    public int BadgeNumber;

    public Policeman(String name, String surname, String middleName, int age, String department, String rank, int badgeNumber) {
        super(name, surname, middleName, age);
        Department = department;
        Rank = rank;
        BadgeNumber = badgeNumber;
    }
}
