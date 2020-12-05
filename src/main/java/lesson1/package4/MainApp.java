package lesson1.package4;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("Результат задания 4: " + welcome("Андрей"));
    }
    private static String welcome(String name) {
        return "Привет, " + name + "!";
    }
}