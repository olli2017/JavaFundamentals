package intro.t02;

public class Epsilon{
    public static void main(String[] args) {
        double epsilon = Double.parseDouble(args[0]);
        int i = 1;

        while (1.0d/((i+1)*(i+1)) >= epsilon) {
            i = i + 1;
        }

        System.out.println(i);
    }
}
