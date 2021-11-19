package Command.Boxoffice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Display_Upcomming {

    public void DisplayUp() {
        System.out.println("개봉예정 영화 리스트");
        try {
            //Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/pre-movies.aspx").get();
            Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/pre-movies.aspx").get();
            Elements name = doc.select(".sect-movie-chart .box-contents > a  ");
            Elements open = doc.select(".sect-movie-chart .box-contents > span.txt-info ");
            System.out.println("개봉예정작");
            for (int i = 3, s = 1; i < name.size(); i++, s++) {
                System.out.println("=================================================================\n" + s);
                System.out.println(name.get(i).text());
                //System.out.println("\n"); 
                System.out.println(open.get(i).text());
            }

        } catch (Exception e) {
            System.out.println("값을 가져오는 중 오류가 발생했습니다");
            e.printStackTrace();
        }

    }

}
