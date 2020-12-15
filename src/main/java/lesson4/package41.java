package lesson4;

public class package41 {
    public static void main(String[] args) {
        Worker mainWorker = new Worker("Александр", "Валерьевич",
                "Гладков", "8(495)000-11-22",
                "Test Manager", 80000, 1986);

        System.out.println("Please welcome our " + mainWorker.getPosition() + ", " +
                mainWorker.getName() + " " + mainWorker.getSecondName() + " " + mainWorker.getSurname() + ".");

        Worker[] workers = {
                mainWorker,
                new Worker("Андрей", "Андреевич",
                        "Андреев", "8(495)111-22-33",
                        "project owner", 520000, 1973),
                new Worker("Евгений", "Евгеньевич",
                        "Евгеньев", "8(495)222-33-44",
                        "project manager", 40000, 1963),
                new Worker("Наталья", "Натальевна",
                        "Натальева", "8(495)333-44-55",
                        "senior developer", 90000, 1990),
                new Worker("Тетенька", "Тетеньковна",
                        "Тетенькова", "8(495)444-55-66",
                        "engineer", 50000, 1983)
        };

        System.out.println("**********************************************");

        for (int i = 0; i < workers.length; i++)
            if (workers[i].getAge() > 40) {
                System.out.println(workers[i].getFullInfo());
            }

        System.out.println("**********************************************");

        for (int i = 0; i < workers.length; i++)
            System.out.println(workers[i].getFullInfo());

        increaseSalary(workers, 45, 5000);

        System.out.println("**********************************************");
        for (int i = 0; i < workers.length; i++)
            if (workers[i].isSalaryChanged)
                System.out.println(workers[i].getFullInfo());

    }

    private static void increaseSalary(Worker[] emp, int age, float increment) {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > age) {
                emp[i].setSalary(increment);
                emp[i].isSalaryChanged = true;
            }
        }
    }
}


