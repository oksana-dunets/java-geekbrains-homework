package lesson1.package3;

public class MainApp {
    public static void main(String[] args) {
        int variable = 0;

        System.out.println("Результат задания 3: " + ((isPositive(variable)) ? "positive" : "negative"));


    }
    private static boolean isPositive(int variable) {
        return variable >= 0;
    }

}

