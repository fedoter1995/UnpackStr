package testEx;
import java.util.regex.Pattern;

public class ppp {

        public static void main(String[] args) {
            String a = "2[xyz]4[xy]z";
            Pattern pattern = Pattern.compile("[\\[ ,.!?\\]]");

            String []i = pattern.split(a);
            for(String word:i)
                System.out.println(word);
        }

}
