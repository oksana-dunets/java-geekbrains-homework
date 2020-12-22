package lesson6;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class package61 {

    private static final Random RND = new Random();
    private static final int MAX_LENGTH = 100;
    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;
    private static final int FILES_AMOUNT = 10;
    private static final int WORDS_AMOUNT = 5;
    private static final int WORD_LENGTH = 10;
    private static final String SEARCH = "FIND_ME";

    private static FileOutputStream fos;
    private static FileInputStream fis;

    private static String generateSymbols(int amount) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < amount; i++)
            sequence.append((char) (CHAR_BOUND_L + RND.nextInt(CHAR_BOUND_H - CHAR_BOUND_L)));
        return sequence.toString();
    }

    private static void writeFileContents(String fileName, int length) {
        try {
            fos = new FileOutputStream(fileName);
            fos.write(generateSymbols(length).getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Something wrong " + fileName + " Reason: " + e.getCause());
        }
    }

    private static void writeFileContents(String fileName, int words, int length) {
        try {
            fos = new FileOutputStream(fileName);
            for (int i = 0; i < words; i++) {
                if (RND.nextInt(WORDS_AMOUNT) == WORDS_AMOUNT / 2)
                    fos.write(SEARCH.getBytes());
                else
                    fos.write(generateSymbols(length).getBytes());
                fos.write(' ');
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Something wrong " + fileName + " Reason: " + e.getCause());
        }

    }

    private static void mergeFiles(String inputFile1, String inputFile2, String outputFile) {
        try {
            fos = new FileOutputStream(outputFile);
            int ch;
            fis = new FileInputStream(inputFile1);
            while ((ch = fis.read()) != -1)
                fos.write(ch);
            fis.close();

            fis = new FileInputStream(inputFile2);
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            fis.close();

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Something wrong. Reason: " + e.getCause());
        }
    }

    private static boolean searchInFile(String fileName, String search) throws IOException {
        fis = new FileInputStream(fileName);
        byte[] searchSequence = search.getBytes();
        int ch;
        int i = 0; //FINFIND_ME
        while ((ch = fis.read()) != -1) {
            if (ch == searchSequence[i]) {
                i++;
            } else {
                i = 0;
                if (ch == searchSequence[i]) {
                    i++;
                }
            }
            if (i == searchSequence.length) {
                fis.close();
                return true;
            }
        }
        fis.close();
        return false;
    }

    private static String[] searchMatch(String[] files, String search) throws IOException {
        String[] list = new String[files.length];
        int count = 0;
        File path = new File(new File(".").getCanonicalPath());
        File[] dir = path.listFiles();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isDirectory()) {
                continue;
            }
            for (int j = 0; j < files.length; j++) {
                if (dir[i].getName().equals(files[j])) {
                    if (searchInFile(dir[i].getName(), search)) {
                        list[count] = dir[i].getName();
                        count++;
                        break;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] fileNames = new String[FILES_AMOUNT];
        for (int i = 0; i < fileNames.length; i++)
            fileNames[i] = "file_" + i + ".txt";

        //#1
        for (int i = 0; i < fileNames.length; i++)
            if (i < 2)
                writeFileContents(fileNames[i], MAX_LENGTH);
            else
                writeFileContents(fileNames[i], WORDS_AMOUNT, WORD_LENGTH);
        System.out.println("Результат работы первого задания в файлах file_0 и file_1.");

        //#2
        mergeFiles(fileNames[0], fileNames[1], "FILE_OUT.txt");
        System.out.println("Результат соединения в FILE_OUT.");

        //#3
        try {
            System.out.println("В файле file_2 есть ли совпадение? " + searchInFile(fileNames[2], SEARCH));
            //#4
            System.out.println("Проверка на совпадение слова во всех файлах!");
            String[] result = searchMatch(fileNames, SEARCH);
            for (int i = 0; i < result.length; i++)
                if (result[i] != null)
                    System.out.println("Файл " + result[i] + " содержит искомое слово " + SEARCH);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

