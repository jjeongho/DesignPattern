/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.sql.SQLException;
import java.util.Scanner;

public class Control {
     public void test() throws SQLException {
    Recommendation b1 = new Search();
    
     Scanner scan = new Scanner(System.in);
        System.out.print("영화 입력 : ");
        String movieNm = scan.nextLine();

        
        Search mJson = new Search();//제이슨을 통해 나온다
        Search m = mJson.getDescription(movieNm);
        
        b1 = new Grade(b1);
        System.out.println(b1.getDescription() +b1.getData());
}
}
