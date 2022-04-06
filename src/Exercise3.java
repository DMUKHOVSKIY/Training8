import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise3 {
    private final StringBuilder badText = new StringBuilder();
    private int countOfBadSentences = 0;
    private boolean FiledVerification;

    public void mainChek() {
        String[] sentence = getTextFromTxt("Exercise3Text.txt").toString().split("\\.");
        for (int i = 0; i < sentence.length; i++) {
            if (checkBadWords(sentence[i])) {
                addBadSentences(sentence[i]);
            }
        }
        conclusion();
    }

    private StringBuilder getTextFromTxt(String file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String words;
            while ((words = bufferedReader.readLine()) != null)
                stringBuilder.append(words);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }

    private boolean checkBadWords(String sentence) {
        String[] wordsFromText = sentence.split(" ");
        String[] badWords = getTextFromTxt("Exercise3BlackList.txt").toString().split(",");
        for (int i = 0; i < badWords.length; i++) {
            for (int j = 0; j < wordsFromText.length; j++) {
                if (wordsFromText[j].trim().equalsIgnoreCase(badWords[i].trim()))
                    return true;
            }
        }
        return false;
    }

    private void addBadSentences(String str) {
        badText.append(countOfBadSentences + ")" + str + "\n");
        countOfBadSentences++;
    }

    private void conclusion() {
        if (badText.length() != 0) {
            System.out.println("Text didn't pass the test. Bad words are in the " +
                    countOfBadSentences + " sentence:\n" + badText);
        } else
            System.out.println("Text passed the test");
    }

}
