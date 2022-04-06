import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise1 {
    private static final String file= "Exercise1.txt";

    public static void findPalindromes() {
        String str;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((str = bufferedReader.readLine()) != null) {
                check(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void check(String str) {
        boolean same = true;
        String[] symbols = str.split("");
        for (int i = 0, j = symbols.length - 1; i < symbols.length / 2; i++, j--) {
            if (!(symbols[i].equalsIgnoreCase(symbols[j]))) {
                same = false;
                break;
            }
        }
        if (same)
            System.out.println(str);
    }
}
