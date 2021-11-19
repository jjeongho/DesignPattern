/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.Scanner;

public class Start {

    public void StartMenu() {
        while (true) {
            line();
            menu();
            line();
            System.out.print("실행 메뉴 입력 : ");
            Scanner sc = new Scanner(System.in); // 사용자 입력받기
            int num = Integer.parseInt(sc.nextLine()); //String 타입 int 형으로 변환
            Menu menu;

            if (num == 1) {
                menu = new Menu(new Search());
                menu.Change();
                break;
            } else if (num == 2) {
                menu = new Menu(new Recommend());
                menu.Change();
                break;
            } else if (num == 3) {
                menu = new Menu(new Inquiry());
                menu.Change();
                break;
            } else if (num == 4) {
                menu = new Menu(new List());
                menu.Change();
                break;
            } else if (num == 5) {
                menu = new Menu(new Genre());
                menu.Change();
                break;
            } else if (num == 6) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
            }
        }
    }

    public void menu() {
        // 메뉴
        System.out.println("<<영화 검색 시스템>>");
        System.out.println("1. 검색");
        System.out.println("2. 영화 추천받기");
        System.out.println("3. 조회");
        System.out.println("4. 실시간 검색어");
        System.out.println("5. 장르별 영화");
        System.out.println("6. 종료");
    }

    public void line() {
        System.out.println("=================================================");
    }

    public static void main(String[] args) {
        //프로그램 첫 실행
        Start s = new Start();
        s.StartMenu();
    }
}
