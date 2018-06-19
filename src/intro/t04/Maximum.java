package intro.t04;

public class Maximum{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(args[i+1]);
        }

        double max = a[0] + a[n-1];
        for (int i = 1; i < n/2; i++) {
            if (a[i] + a[n-1-i] > max)
                max = a[i] + a[n-1-i];
        }

        System.out.println(max);
    }
}