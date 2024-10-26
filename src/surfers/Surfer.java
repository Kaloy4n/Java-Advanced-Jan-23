package surfers;

public class Surfer {
    private String name;
    private int age;
    private int experience;
    private Boolean ownsASurfBoard;
    private int money;

    public Surfer(String name, int age, int experience, Boolean ownsASurfBoard, int money) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.ownsASurfBoard = ownsASurfBoard;
        this.money = money;
    }

    // Getters
    public String getName() {
        return name;
    }


    public int getExperience() {
        return experience;
    }

    public Boolean getOwnsASurfBoard() {
        return ownsASurfBoard;
    }

    public int getMoney() {
        return money;
    }

    // Setters

    public void setMoney(int money) {
        this.money = money;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("Surfer %s is %d years old and has %d years surfing experience.",
                this.name, this.age, this.experience);
    }
}
