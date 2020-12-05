package lesson1.packege;

public class MainApp {
    public static void main(String[] args) {


        int a = 15;
        int b = 40;
        int c = 100;
        int d = 20;

        System.out.println("Результат задания № 1 способ № 2: " + calculate(a, b, c, d));

    }

    private static float calculate(int a, int b, int c, int d) {
        return a * (b + (c * 1.0f / d));
    }

}
