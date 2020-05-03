package humans;

public class Policemen extends Humans {
    public String Department;
    public String Rank;
    public int BadgeNumber;

    public Policemen(String name, String surname, String middleName, int age, String department, String rank, int badgeNumber) {
        super(name, surname, middleName, age);
        Department = department;
        Rank = rank;
        BadgeNumber = badgeNumber;
    }
}
