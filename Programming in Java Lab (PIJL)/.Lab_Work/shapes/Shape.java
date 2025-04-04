abstract class Shape {
    protected double dim_one;
    protected double dim_two;
    protected double dim_three;
    protected double num_sides;

    void Shape(double dim_one, double dim_two, double dim_three, double num_sides) {
        this.dim_one = dim_one;
        this.dim_two = dim_two;
        this.dim_three = dim_three;
        this.num_sides = num_sides;
    }

    void getDimOne() {
        System.out.println("dim_one = " + dim_one);
    }

    void getDimTwo() {
        System.out.println("dim_two = " + dim_two);
    }

    void getDimThree() {
        System.out.println("dim_three = " + dim_three);
    }

    void getNumSides() {
        System.out.println("num_sides = " + num_sides);
    }
}
