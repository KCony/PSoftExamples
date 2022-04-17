import java.util.Date;

public class StackDemo {
    private int x = 10;
    private static int y = 100;
    static {
        int x = 15;
        int y = 105;
        System.out.printf("Static initializer, x = %d, y = %d, StackDemo.y = %d%n", x, y, StackDemo.y);
        //System.out.printf("this.x = %n", this.x); // Error: 'StackDemo.this' cannot be referenced from a static context
    }
    {
        x = 90;
    }
    public static void print(String x, StringBuilder y) {
        System.out.printf("%s%n", x);
        String z = y.append(" as StringBuilder").toString();
        System.out.printf("%s%n", z);
    }
    {
        int x = 20;
        int y = 110;
        System.out.printf("Instance initializer, x = %d, y = %d, StackDemo.y = %d, this.x = %d, this.y = %d%n",
                x, y, StackDemo.y, this.x, this.y); //Warning: Static member 'StackDemo.y' accessed via instance reference
    }
    public /* void */ StackDemo() {  // No return type for the constructor!
        int x = 25;
        int y = 115;
        this.x = 990;
        System.out.printf("Constructor, x = %d, y = %d, StackDemo.y = %d, this.x = %d, this.y = %d%n",
                x, y, StackDemo.y, this.x, this.y);
    }
    public int square(int x) {
        int result = 0;
        result = x * x;
        return result;
    }
    public int sumSquares(int x, int y) {
        // int x = 5; // Variable 'x' is already defined in the scope
        int sq1 = 0;
        sq1 = square(x);
        int sq2 = 0;
        sq2 = square(y);
        int sq3 = 0;
        sq3 = square(this.x);
        int sq4 = 0;
        sq4 = square(StackDemo.y);
        int result;
        result = 0;
        result = sq1 + sq2 + sq3 + sq4;
        System.out.printf("StackDemo.sunSquares, x = %d, y = %d, StackDemo.y = %d, this.x = %d, this.y = %d%n",
                x, y, StackDemo.y, this.x, this.y);
        System.out.printf("StackDemo.sunSquares, sq1 = %d, sq2 = %d, sq3 = %d, sq4 = %d, result = %d%n",
                sq1, sq2, sq3, sq4, result);
        return result;
    }
    public static void main(String... args) {
        StackDemo aStackDemo = null;
        aStackDemo = new StackDemo();
        System.out.printf("main, StackDemo.y = %d%n", StackDemo.y);
        // int result = sumSquares(30, 120); // Non-static method 'sumSquares(int, int)' cannot be referenced from a static context
        int result = 0;
        result = aStackDemo.sumSquares(30, 120);
        // aStackDemo.StackDemo();
        System.out.printf("main, StackDemo.y = %d, result = %d%n", StackDemo.y, result);
        String x = null;
        x = String.format("StackDemo object printed on %tB %<te %<tY at %<tT %<Tp", new Date());
        StringBuilder y = null;
        y = new StringBuilder(x);
        StackDemo.print(x, y);
    }
}
