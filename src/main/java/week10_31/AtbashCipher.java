package week10_31;

public class AtbashCipher {

    // 1) Long solution:

    public static String atbash(String word){

        char[] firstHalfOfAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};
        char[] secondHalfOfAlphabet = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n'};

        StringBuilder atbashString = new StringBuilder();

        for(char ch : word.toCharArray()){

            if(!Character.isAlphabetic(ch)) atbashString.append(ch);

            for(int i=0; i< firstHalfOfAlphabet.length; i++){
                if(Character.isUpperCase(ch)){

                    char upperCase1 = Character.toUpperCase(firstHalfOfAlphabet[i]);
                    char upperCase2 = Character.toUpperCase(secondHalfOfAlphabet[i]);

                    if(ch == upperCase1) atbashString.append(upperCase2);
                    if(ch == upperCase2) atbashString.append(upperCase1);
                }
                else{

                    if(ch == firstHalfOfAlphabet[i]) atbashString.append(secondHalfOfAlphabet[i]);
                    if(ch == secondHalfOfAlphabet[i]) atbashString.append(firstHalfOfAlphabet[i]);
                }
            }
        }
        return atbashString.toString();
    }

    // 2) Optimized solution:

    public static String atbashOptimized(String word){

        StringBuilder atbashString = new StringBuilder();

        for(int i=0; i<word.length(); i++){

            if(!Character.isAlphabetic(word.charAt(i)))
                atbashString.append(word.charAt(i));
            else if(Character.isUpperCase(word.charAt(i)))
                atbashString.append((char) ('Z' - (word.charAt(i) - 'A')));
            else atbashString.append((char) ('z' - (word.charAt(i) - 'a')));
        }

        return atbashString.toString();
    }

    public static void main(String[] args) {

        System.out.println(atbash("Tlw rh ivzo!"));
        System.out.println(atbashOptimized("Christmas is the 25th of December"));
    }
}
