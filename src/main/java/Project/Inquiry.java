package Project;

import Command.Boxoffice.All_time;
import Command.Boxoffice.Boxoffice;
import Command.Boxoffice.Command;
import Command.Boxoffice.Day;
import Command.Boxoffice.Display_All_time;
import Command.Boxoffice.Display_Day;
import Command.Boxoffice.Display_Upcomming;
import Command.Boxoffice.Display_Weekly;
import Command.Boxoffice.Upcomming;
import Command.Boxoffice.Weekly;
import Command.Boxoffice.Current;
import Command.Boxoffice.Display_Current;
import java.util.Scanner;

class Inquiry implements MenuBehavior {

    public void Action() {  
        System.out.println("현재 상영영화 : 1 \n일간 박스오피스 : 2 \n주간 박스오피스 : 3\n역대 박스오피스 : 4\n개봉예정영화 : 5\n"
                + "뒤로 : 6");
        Display_Current current = new Display_Current(); // 현재 상영 영화 순위(7등까지)
        Command Current = new Current(current);
        Display_Day day = new Display_Day(); // 일간 박스오피스
        Command Day = new Day(day);
        Display_Weekly weekly = new Display_Weekly();//주간 박스오피스
        Command Weekly = new Weekly(weekly);
        Display_Upcomming up = new Display_Upcomming();//개봉예정작
        Command Upcomming = new Upcomming(up);
        Display_All_time All = new Display_All_time();//역대 박스오피스
        Command All_time = new All_time(All);

        System.out.print("실행 메뉴 입력 : ");
        Scanner sc = new Scanner(System.in); // 사용자 입력받기
        int num = Integer.parseInt(sc.nextLine()); //String 타입 int 형으로 변환

        if (num == 1) {
            Boxoffice CurrentD = new Boxoffice(Current);//실시간 순위 7등까지
            CurrentD.Display();// 실시간 출력
            
            System.out.print("1번을 누를시 돌아갑니다.");
            Scanner en = new Scanner(System.in); // 사용자 입력받기
            int num1 = Integer.parseInt(en.nextLine()); //String 타입 int 형으로 변환
            if (num1 == 1) {
                Menu menu;
                menu = new Menu(new Inquiry());
                menu.Change();
            }
        } else if (num == 2) {
            Boxoffice DayD = new Boxoffice(Day);//일간 박스오피스 Command 설정
            DayD.Display();// 일간 박스오피스 출력
            
            System.out.print("1번을 누를시 돌아갑니다.");
            Scanner en = new Scanner(System.in); // 사용자 입력받기
            int num1 = Integer.parseInt(en.nextLine()); //String 타입 int 형으로 변환
            if (num1 == 1) {
                Menu menu;
                menu = new Menu(new Inquiry());
                menu.Change();
            }
        } else if (num == 3) {
            Boxoffice WeeklyD = new Boxoffice(Weekly);//주간 박스오피스 Command 설정
            WeeklyD.Display();// 주간 박스오피스 출력
            
            System.out.print("1번을 누를시 돌아갑니다.");
            Scanner en = new Scanner(System.in); // 사용자 입력받기
            int num1 = Integer.parseInt(en.nextLine()); //String 타입 int 형으로 변환
            if (num1 == 1) {
                Menu menu;
                menu = new Menu(new Inquiry());
                menu.Change();
            }
        } else if (num == 4) {
            Boxoffice AllD = new Boxoffice(All_time);// 역대 박스오피스 200위까지
            AllD.Display(); //역대 박스오피스

            System.out.print("1번을 누를시 돌아갑니다.");
            Scanner en = new Scanner(System.in); // 사용자 입력받기
            int num1 = Integer.parseInt(en.nextLine()); //String 타입 int 형으로 변환
            if (num1 == 1) {
                Menu menu;
                menu = new Menu(new Inquiry());
                menu.Change();
            }
        } else if (num == 5) {
            Boxoffice UpD = new Boxoffice(Upcomming);//개봉 예정작
            UpD.Display();// 개봉 예정작

            System.out.print("1번을 누를시 돌아갑니다.");
            Scanner en = new Scanner(System.in); // 사용자 입력받기
            int num1 = Integer.parseInt(en.nextLine()); //String 타입 int 형으로 변환
            if (num1 == 1) {
                Menu menu;
                menu = new Menu(new Inquiry());
                menu.Change();
            }
        } else if (num == 6) {
            System.out.println("돌아갑니다.");
            Start s = new Start();
            s.StartMenu();
        }
    }
}
