class Customer
{
    private int custId;
    private String custName;
    private double revenueTarget;
    class Address
    {
        public String addrLine1;
        public String addrLine2;
        public String city;
        public String custState;
        public String country;
        public int zip;
        public double increaseTarget()
        {
            if (revenueTarget < 100000)
                revenueTarget+= 100000;
            return revenueTarget;

        }
    }
    public static void main(String[] a)
    {
        Customer c = new Customer();
        Customer.Address ca1 = c.new Address();
        ca1.addrLine1 = "123, Main St.";
        ca1.addrLine2 = "Sacs, 5th Ave.";
        ca1.city = "New York";
        ca1.custState = "NY";
        ca1.country = "USA";
        double t = ca1.increaseTarget();
        System.out.println("Target : " + t);
    }
}