package Project;

import java.util.LinkedList;
import java.util.Scanner;

public class Control {

    public void test() {
        ConcreateSubject dat = new ConcreateSubject();
        int chart;
        Scanner sc = new Scanner(System.in);//입력값 if문 
        Subject person = new Subject("영화검색을 원하는 사용자");
        Subject person1 = new Subject("배우(영화인) 검색을 원하는 사용자");

        System.out.println("1.영화 검색  2.배우(영화인) 검색 이외는 종료 ");
        chart = sc.nextInt();

        if (chart == 1) {
            System.out.print("영화 입력 : ");

            Scanner scan = new Scanner(System.in);

            String movieNm = scan.nextLine();
            Movie movie = new Movie(movieNm);
            movie.StoreRepository();
            BriefInfor mJson = new BriefInfor();
            dat.add(person);
            dat.people();
            BriefInfor m = mJson.updateM(movieNm);
            System.out.println("상세한 정보를 원한다면? 영화 코드를 입력 :");
            Scanner scan_detailm = new Scanner(System.in);//영화값
            String movieCd = scan_detailm.nextLine();
            DetailInforM bxwJson = new DetailInforM();
            DetailInforM bx = bxwJson.update(movieCd);

        } else if (chart == 2) {
            Scanner scan = new Scanner(System.in);
            System.out.print("배우명 입력 : ");

            String peopleNm = scan.nextLine();
            Actor actor = new Actor(peopleNm);
            actor.StoreRepository();
            BriefInfor aJson = new BriefInfor();
            dat.add(person1);
            dat.people();
            BriefInfor a = aJson.updateA(peopleNm);
            System.out.println("상세한 정보를 원한다면? 배우(영화인) 코드를 입력 :");
            Scanner scan_detaila = new Scanner(System.in);
            String peopleCd = scan_detaila.nextLine();
            DetailInforA bxwJson = new DetailInforA();
            DetailInforA bx = bxwJson.update(peopleCd);
        } else
            ;

    }
}
