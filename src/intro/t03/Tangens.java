package intro.t03;

public class Tangens {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double h = Double.parseDouble(args[2]);
        for (double i = a; i <= b + h; i+= h) {
            System.out.printf("%.4f", i);
            System.out.print("    ");
            System.out.printf("%.6f", Math.tan(2*i) - 3);
            System.out.println();
        }
    }
}
