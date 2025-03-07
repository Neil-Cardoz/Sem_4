abstract public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    abstract public void exercise(int calories);

    abstract public void work();

    public final void sleep(int hrs){

        if(hrs < 8) {
            System.out.println("I'm sleeping too much");
        }
        else {
            System.out.println("I'm sleeping too little");

        }

    }

    abstract public void display();

}
