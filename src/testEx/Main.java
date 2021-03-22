package testEx;
import java.util.Scanner;
import java.util.regex.*;

public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String mystr = scanner.nextLine();

        /*System.out.println(mystr);*/
        if(Validity_check(mystr))
        {
            String unpackedStr = UnpackStr(mystr);

            while (Coincidence(unpackedStr) > 0) {
                unpackedStr = (UnpackStr(unpackedStr));//While there are unpacked substrings, we call.
            }
            System.out.println(unpackedStr);
        }
        else
        {
            System.out.println("Error! Invalid String!");
        }

    }

    public static String UnpackStr(String inputstr) {

        Pattern substrPattern = Pattern.compile("\\d+\\[[a-zA-Z]+\\]");
        Matcher matcher = substrPattern.matcher(inputstr);
        String finalStr="";
        String substring="";

    if(matcher.find()) {

        substring = matcher.group();

        finalStr = matcher.replaceFirst(unpackSubstring(substring));

      /* System.out.println(substring);*/
    }
       /* System.out.println(finalStr);*/
        return finalStr;
    }

    public static String unpackSubstring(String inputstr)
    {
        Pattern splitPattern = Pattern.compile("[\\[\\]]");
        String finalStr="";
        String[] splitSubstring=splitPattern.split(inputstr);
        /* System.out.println(splitSubstring);*/
        for(int i=0;i<splitSubstring.length;i++)
        {
            if(isNumeric(splitSubstring[i]))
            {
                int value=Integer.parseInt(splitSubstring[i]);
                for(int j=0;j<value;j++)
                {
                    finalStr=finalStr+splitSubstring[i+1];
                }
            }
        }
        return finalStr;
    }

    public static boolean isNumeric(String str)
    {
        return str.matches("\\d+");
    }

    public static int Coincidence(String str)
    {
        Pattern mypattern = Pattern.compile("\\d+\\[[a-zA-Z]+\\]");
        Matcher matcher = mypattern.matcher(str);
        int counter=0;
        while(matcher.find()) {
            counter++;
        }
        return  counter;
    }
    public static boolean count_square_brackets(String str)
    {
        Pattern Leftpattern = Pattern.compile("\\[");
        Pattern Rightpattern = Pattern.compile("\\]");
        Matcher Lmatcher = Leftpattern.matcher(str);
        Matcher Rmatcher = Rightpattern.matcher(str);
        int lCounter=0,rCounter=0;

        while(Lmatcher.find())
            lCounter++;
        while(Rmatcher.find())
            rCounter++;
        return(lCounter==rCounter);
    }

    public static boolean Validity_check(String str)
    {
        Pattern pattern = Pattern.compile("(\\d+\\[+((\\d*\\[*[a-zA-z]*))\\]+)+");

        Matcher matcher = pattern.matcher(str);

        if(count_square_brackets(str)&matcher.matches())
        {
            return true;
        }
        else
        {
            return false;
        }

    }


}