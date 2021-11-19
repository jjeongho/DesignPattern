package Command.Boxoffice;

import BoxofficeDayAPI.BoxofficeDayAPI;
import java.util.Scanner;

public class Display_Day {

    public void DisplayD() {
        System.out.println("일간 박스오피스");
        Scanner scan = new Scanner(System.in);
        System.out.println("일간 박스오피스 검색 (yyyymmdd) : ");
        String targetDt = scan.nextLine();
        System.out.println("국가 선택 (K : 한국 , F : 외국영화 , default : 전체) : ");
        String repNationCd = scan.nextLine();

        BoxofficeDayAPI bxJson = new BoxofficeDayAPI();

        BoxofficeDayAPI bx = bxJson.getBoxOffice(targetDt, repNationCd);
    }
}
