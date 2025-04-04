import java.util.Vector;

public class VectorEx
{
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        v.add(10);
        v.add(20);
        Vector<Integer> v2 = new Vector<Integer>();
        v2.add(30);
        v2.add(40);
        v.addAll(v2);

        System.out.println("Vector elements: ");
        for(Integer e  : v)
            System.out.println(e);

        Point p1 = new Point(3, 4);
        Point p2 = new Point(5, 2);

        Vector<Point> v3 = new Vector<Point>();
        v3.add(p1);
        v3.add(p2);

        
        System.out.println("Vector elements of v3: " );
        for(Point e : v3)
            System.out.println(e.x + "," + e.y);
    }
}
class Point {
    int x, y;
    public Point(int a, int b)
    {
        x = a;
        y = b;
    }
}