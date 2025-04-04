public class StringBufferEx
{   
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("I'm Sam");
        sb.append(" Sam I am");
        System.out.println(sb);
        System.out.println("Capacity of StringBuffer: " + sb.capacity());
        sb.delete(9, 13);
        System.out.println("After delete method:" + sb);
        System.out.println("Index of a char in StringBuffer: " + sb.indexOf("Sam"));
        System.out.println("After replace():" + sb.replace(0, 2, "U"));
        System.out.println("Substring of StringBuffer: " + sb.substring(0, 5));
        System.out.println("Length of StringBuffer: " + sb.length());
    }
}