package wiprotraining;
public class StringOperations {

    public static String concatenateReverseAndExtract(String str1, String str2, int length) {
        String concatenated = str1 + str2;
        String reversed = new StringBuilder(concatenated).reverse().toString();
        if (length > reversed.length()) {
            return reversed;
        }
        int start = (reversed.length() - length) / 2;
        String middleSubstring = reversed.substring(start, start + length);
        
        return middleSubstring;
    }

    public static void main(String[] args) {
        System.out.println(concatenateReverseAndExtract("hello", "world", 5));
        System.out.println(concatenateReverseAndExtract("abc", "def", 4)); 
        System.out.println(concatenateReverseAndExtract("", "", 3));
        System.out.println(concatenateReverseAndExtract("a", "b", 10));
    }
}
