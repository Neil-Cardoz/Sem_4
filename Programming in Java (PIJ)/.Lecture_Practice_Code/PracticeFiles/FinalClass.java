public class FinalClass {
    public final void sleep(int hrs){
        if(hrs < 10){
            System.out.println("Sleeping for 10 hrs");
        }
    }

    public static void main(String[] args) {
        FinalClass fc = new FinalClass();
        fc.sleep(10);

    }





}
