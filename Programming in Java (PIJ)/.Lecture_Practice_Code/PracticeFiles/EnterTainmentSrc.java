public class EnterTainmentSrc {
    public static int i;
    public int incStaticVar(){
        return ++i;
    }
    int count = 0;
    for (int i=0;i<100;i++){count++;}
    public static void main(String[] args) {
        EnterTainmentSrc obj = new EnterTainmentSrc();
        System.out.println(EnterTainmentSrc.i);
        System.out.println(obj.incStaticVar());
    }
}
