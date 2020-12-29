import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> printSumReturnGreaterThan10(int[] array) {
        int sum = 0;
        ArrayList<Integer> newArray = new ArrayList<>();
        for (int value : array) {
            sum += value;
            if (value > 10) {
                newArray.add(value);
            }
        }
        System.out.println("The Sum: " + sum);
        return newArray;
    }

    public ArrayList<String> printNameReturnLongerThan5(ArrayList<String> array) {
        Collections.shuffle(array);
        ArrayList<String> newArray = new ArrayList<>();
        for (String name : array) {
            System.out.println(name);
            if (name.length() > 5) {
                newArray.add(name);
            }
        }
        return newArray;
    }

    public void displayFirstLastLetter(ArrayList<Character> list) {
        Collections.shuffle(list);
        char firstLetter = list.get(0);
        char lastLetter = list.get(list.size() - 1);
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        boolean isVowel = false;
        System.out.println("First Letter: " + firstLetter);
        System.out.println("Last Letter: " + lastLetter);
        for (char vowel : vowels) {
            if (firstLetter == vowel) {
                isVowel = true;
            }
        }
        if (isVowel) {
            System.out.println("The first letter is vowel.");
        }
    }

    public int[] generateRandomNumArray(int length) {
        int[] numArray = new int[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            numArray[i] = r.nextInt(46) + 55;
        }
        return numArray;
    }

    public ArrayList<Integer> generateSortRandomNumArray(int length) {
        ArrayList<Integer> numArray = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            numArray.add(r.nextInt(46) + 55);
        }
        Collections.sort(numArray);
        return numArray;
    }

    public void generateRandomString(int length) {
        String str = "";
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            str += (char) (r.nextInt(26) + 97);
        }
        System.out.println(str);
    }
}
