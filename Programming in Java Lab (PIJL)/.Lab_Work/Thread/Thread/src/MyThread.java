

import static java.lang.Thread.sleep;

public class MyThread implements Runnable {

    private int init;
    private int increment;
    private int delay;

    public MyThread( int init, int increment, int delay ) {
        this.init = init;
        this.increment = increment;
        this.delay = delay;

    }



    public void run() {
        for(;;){

        try{
            System.out.println(init+"  ");
            init += increment;
            sleep(delay);

        }catch ( Exception e ) {
            e.printStackTrace();
        }
        //System.out.println("Thread started");
    }

}
}




