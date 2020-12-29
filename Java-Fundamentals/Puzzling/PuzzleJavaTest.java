import java.util.ArrayList;

public class PuzzleJavaTest {
    public static void main(String[] args) {
        PuzzleJava pj = new PuzzleJava();

        int[] numArray = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
        System.out.println(pj.printSumReturnGreaterThan10(numArray));

        // ===========================================================================

        ArrayList<String> strArray = new ArrayList<>();
        strArray.add("Nancy");
        strArray.add("Jinichi");
        strArray.add("Fujibayashi");
        strArray.add("Momochi");
        strArray.add("Ishikawa");
        System.out.println(pj.printNameReturnLongerThan5(strArray));

        // ===========================================================================

        ArrayList<Character> charArray = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            charArray.add(i);
        }
        pj.displayFirstLastLetter(charArray);

        // ===========================================================================

        int[] randomIntArray = pj.generateRandomNumArray(10);
        for (int num : randomIntArray) {
            System.out.println(num);
        }

        // ===========================================================================

        ArrayList<Integer> randomSortList = pj.generateSortRandomNumArray(10);
        System.out.println(randomSortList);

        // ===========================================================================

        pj.generateRandomString(5);
    }
}
