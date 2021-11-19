package Alltime;

import java.util.Scanner;

public class DaoTest {

    static int count = 0;

    public static void main(String[] args) {
        print();
    }

    public static void print() {
        AlltimeDAO dao = new AlltimeDAO();
        for (int i = 0;; i++) {
            dao.Alltime(count);

            System.out.println("PageUp : 1 PageDown : 2 exit : 3");
            Scanner scan = new Scanner(System.in);
            String select = scan.next();

            if (select.equals("1")) {
                count += 10;
            } else if (select.equals("2")) {
                if (count <= 0) {
                    System.out.println("첫 페이지입니다.");
                }
                count -= 10;
            } else if (select.equals("3")) {
                System.out.println("나갑니다.");
                break;
            }
        }

    }
}
