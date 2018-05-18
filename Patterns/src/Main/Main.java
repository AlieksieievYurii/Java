package Main;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args)
    {
        String text = "4r34r34r34 Яна 22 cota.";
	// write your code here
        Pattern p = Pattern.compile("[А-яа-я]*\\s\\d{2}");
        Matcher m = p.matcher(text);

        while(m.find())
        {
            System.out.println(m.group());
        }
    }
}
