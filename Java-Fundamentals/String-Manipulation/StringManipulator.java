public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        return str1.trim() + str2.trim();
    }

    public Integer getIndexOrNull(String str, char ch) {
        int index = str.indexOf(ch);
        if (index == -1) {
            return null;
        }
        return index;
    }

    public Integer getIndexOrNull(String str1, String str2) {
        int index = str1.indexOf(str2);
        if (index == -1) {
            return null;
        }
        return index;
    }

    public String concatSubstring(String str1, int start, int end, String str2) {
        String subString = str1.substring(start, end);
        return subString + str2;
    }
}
