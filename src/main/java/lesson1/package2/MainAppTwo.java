package lesson1.package2;

public class MainAppTwo {
    public static void main(String[] args) {
    int a1 = 18;
    int b1 = 17;

        System.out.println("Результат задания № 2 " + checkNumbers(a1, b1));



    }
    private static boolean checkNumbers(int a1, int b1) {
        int sum = a1 + b1;
        return (sum <= 20) && (sum >= 10);

    }
}

