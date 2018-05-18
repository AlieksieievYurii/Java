package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFromInternet
{
    private String url = "https://sinoptik.ua/";
    private Document index;

    private String NowDataString;

    private Pattern nowDayPattern = Pattern.compile("[а-яА-Яъ]*");//Pattern for today day
    private Pattern nowDatePattern = Pattern.compile("\\d{2}\\s[а-яъ]*");//Pattern for today date
    private Pattern nowMinPattern = Pattern.compile("мин.\\s[0-9+-°]*");//Pattern for today minimum temperatyre
    private Pattern nowMaxPattern = Pattern.compile("макс.\\s[0-9+-°]*");//Pattern for today maximum temperatyre

    public DataFromInternet()//Method(Constructor) for connect with site
    {
        try {
            int times = 3000;
            index = Jsoup.parse(new URL(url), times);
        }catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("[*] Error not find internet!");
        }
        NowDataString = getMainInform();
    }

    String getMainInform()//Taking main inforamtion on today
    {
        try {

            Element element = index.select("div[id=bd1]").first();
            return element.text();

        }catch (Exception e)
        {
            //e.printStackTrace();
            return null;
        }
    }

    public String getNowDay()//select only day today
    {
        try {
            Matcher m = nowDayPattern.matcher(NowDataString);

            if(m.find())
            {
                return m.group();

            }else return null;

        }catch (Exception e)
        {
            //e.printStackTrace();
            return null;
        }
    }

    public String getNowDate()//taking date today
    {
        try
        {
            Matcher m = nowDatePattern.matcher(NowDataString);

            if(m.find())
            {
                return m.group();
            }else return null;

        }catch (Exception e)
        {
            //e.printStackTrace();
            return null;
        }
    }

    public String[] getNowMinMax()//min and max today of temperatyre
    {
        try
        {
            Matcher m_one = nowMinPattern.matcher(NowDataString);
            Matcher m_two = nowMaxPattern.matcher(NowDataString);
            String[] minMax = new String[2];

            if(m_one.find())
            {
              minMax[0] = m_one.group();

            }else minMax[0] = null;

            if(m_two.find())
            {
                minMax[1] = m_two.group();

            }else minMax[1] = null;

                return minMax;

        }catch (Exception e )
        {
            //e.printStackTrace();
            return null;
        }
    }

    public String getTemperatyreNow()//Taking teamperatyre now
    {
        try
        {
            Element element = index.select("p[class=today-temp]").first();
            return element.text();
        }catch (Exception e)
        {
            //e.printStackTrace();
            return null;
        }

    }

    public String[][] getInfOnFucture()// Return two arrays about next six days(information)
    {

        try {
            Elements elements = index.select("div[class=main]");
            String[] arrayInf = new String[6];
            String[][] list = new String[6][4];
            for (int i = 0; i < 6; i++) {
                arrayInf[i] = elements.get(i).text();

                Matcher m = nowDayPattern.matcher(arrayInf[i]);
                if (m.find()) list[i][0] = m.group();

                m = nowDatePattern.matcher(arrayInf[i]);
                if (m.find()) list[i][1] = m.group();

                m = nowMinPattern.matcher(arrayInf[i]);
                if (m.find()) list[i][2] = m.group();

                m = nowMaxPattern.matcher(arrayInf[i]);
                if (m.find()) list[i][3] = m.group();
            }

            return list;

        }catch (Exception e)
        {
            //e.printStackTrace();
            return null;
        }
    }
}
