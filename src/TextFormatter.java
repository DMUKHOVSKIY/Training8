public class TextFormatter {

    public static int stringSize(String str) {
        String tempStr = str.replaceAll(" ", "");
        return tempStr.length();
    }

    public static boolean palindromes(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != 0 && words[i].length() != 1 && check(words[i]))
                return true;
        }
        return false;
    }

    private static boolean check(String str) {
        String[] symbols = str.split("");
        for (int i = 0, j = symbols.length - 1; i < symbols.length / 2; i++, j--) {
            if (!(symbols[i].equalsIgnoreCase(symbols[j]))) {
                return false;
            }
        }
        return true;
    }
}
