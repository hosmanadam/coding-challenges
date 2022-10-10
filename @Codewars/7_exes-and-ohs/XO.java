import java.util.Arrays;

public class XO {

    // v2 - A bit cleaner, some duplication but it's OK
    public static boolean getXO(String str) {
        long countX = str.toLowerCase().chars().filter(c -> c == 'x').count();
        long countO = str.toLowerCase().chars().filter(c -> c == 'o').count();
        return countX == countO;
    }

    // v1 - Old style
//    public static boolean getXO(String str) {
//        char[] chars = str.toLowerCase().toCharArray();
//        int countX = 0;
//        int countO = 0;
//        for (char c : chars) {
//            if (c == 'x') countX++;
//            if (c == 'o') countO++;
//        }
//        return countX == countO;
//    }

}
