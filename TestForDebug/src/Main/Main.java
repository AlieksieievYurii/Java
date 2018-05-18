package Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("");
        String text = " kakaka name:Nazar";
        Matcher m = p.matcher(text);

        if(m.find()) System.out.println(m.group());
    }

}
