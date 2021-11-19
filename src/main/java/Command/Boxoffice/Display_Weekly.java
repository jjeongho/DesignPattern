package Command.Boxoffice;

import BoxofficeWeeklyAPI.BoxofficeWeeklyAPI;
import java.util.Scanner;

public class Display_Weekly {

    public void DisplayW() {
        System.out.println("주간 박스오피스");
        Scanner scan = new Scanner(System.in);
        System.out.println("주간 박스오피스 검색 (yyyymmdd) : ");
        String targetDt = scan.nextLine();

        System.out.println("주간/주말/주중을 선택 입력하시오 (“0” : 주간 (월~일)\n"
                + "“1” : 주말 (금~일) (default)\n"
                + "“2” : 주중 (월~목): ");
        String weekGb = scan.nextLine();

        System.out.println("국가 선택 (K : 한국 , F : 외국영화 , default : 전체) : ");
        String repNationCd = scan.nextLine();

        BoxofficeWeeklyAPI bxwJson = new BoxofficeWeeklyAPI();

        BoxofficeWeeklyAPI bx = bxwJson.getBoxOfficeW(targetDt, weekGb, repNationCd);
    }
}
