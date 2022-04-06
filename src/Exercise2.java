import java.io.*;

public class Exercise2 {
    private static final String file = "Exercise2.txt";
    private StringBuilder stringBuilder = new StringBuilder();

    public void getStringFromTxt() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String words;
            while ((words = bufferedReader.readLine()) != null)
                stringBuilder.append(words);
            checkOfString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkOfString() {
        String[] str = stringBuilder.toString().split("\\.");
        for (int i = 0; i < str.length; i++) {
            if (TextFormatter.palindromes(str[i]) || TextFormatter.stringSize(str[i]) >= 3
                    && TextFormatter.stringSize(str[i]) <= 5)
                addStringToFile(str[i]);
        }
        System.out.println("Finished!");
    }

    private void addStringToFile(String str) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("FormattedText.txt", true))) {
            bufferedWriter.write(str + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
