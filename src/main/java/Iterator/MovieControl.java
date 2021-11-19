/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Scanner;

public class MovieControl {
  
    public void test() throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        ArrayList<Genre> actionList = new ArrayList();
        ArrayList<Genre> sfList = new ArrayList();
        ArrayList<Genre> comedyList = new ArrayList();
        ArrayList<Genre> dramaList = new ArrayList();
        ArrayList<Genre> romance_meloList = new ArrayList();
        ArrayList<Genre> thrillerList = new ArrayList();
        actionList.add(new ActionGenre());
        sfList.add(new SFGenre());
        comedyList.add(new ComedyGenre());
        dramaList.add(new DramaGenre());
        romance_meloList.add(new Romance_MeloGenre());
        thrillerList.add(new ThrillerGenre());
        
         boolean t = true;
        Scanner input = new Scanner(System.in);
        Scanner an = new Scanner(System.in);
        while(t){
            System.out.print("\n ☞ ①Action\n ☞ ②SF\n ☞ ③Comedy\n ☞ ④Drama\n ☞ ⑤Romance&Melo\n ☞ ⑥Thiller\n\n ▶▶원하는 영화 장르를 번호로 입력하세요: ");
            String temp = input.nextLine(); 
            
            if(temp.equals("1")== true){
                  System.out.println("\n-----Action 장르의 영화를 보여드립니다.-----\n");
                  Wait wait = new Wait(actionList);
                  wait.printGenre();
                  System.out.print("\n다른 장르의 영화를 더 검색하시겠습니까? (검색을 종료하시려면 n이나 아무키나 누르세요) (y/n) : ");
                  String inp = an.nextLine();
                  if(inp.equals("y")){
                      t = true;
                  }else{
                      t = false;
                  }
                  
        }
            
            else if(temp.equals("2") == true){
                  System.out.println("\n-----SF 장르의 영화를 보여드립니다.-----\n");
                  Wait wait = new Wait(sfList);
                  wait.printGenre();
                  System.out.print("\n다른 장르의 영화를 더 검색하시겠습니까? (검색을 종료하시려면 n이나 아무키나 누르세요) (y/n) : ");
                  String inp = an.nextLine();
                  if(inp.equals("y")){
                      t = true;
                  }else{
                      t = false;
                  }
            }
            
            else if(temp.equals("3") == true){
                  System.out.println("\n-----Comedy 장르의 영화를 보여드립니다.-----\n");
                  Wait wait = new Wait(comedyList);
                  wait.printGenre();
                  System.out.print("\n다른 장르의 영화를 더 검색하시겠습니까? (검색을 종료하시려면 n이나 아무키나 누르세요) (y/n) : ");
                  String inp = an.nextLine();
                  if(inp.equals("y")){
                      t = true;
                  }else{
                      t = false;
                  }
            }
             else if(temp.equals("4") == true){
                  System.out.println("\n-----Drama 장르의 영화를 보여드립니다.-----\n");
                  Wait wait = new Wait(dramaList);
                  wait.printGenre();
                  System.out.print("\n다른 장르의 영화를 더 검색하시겠습니까? (검색을 종료하시려면 n이나 아무키나 누르세요) (y/n) : ");
                  String inp = an.nextLine();
                  if(inp.equals("y")){
                      t = true;
                  }else{
                      t = false;
                  }
            }
             else if(temp.equals("5") == true){
                  System.out.println("\n-----Romance&Melo 장르의 영화를 보여드립니다.-----\n");
                  Wait wait = new Wait(romance_meloList);
                  wait.printGenre();
                  System.out.print("\n다른 장르의 영화를 더 검색하시겠습니까? (검색을 종료하시려면 n이나 아무키나 누르세요) (y/n) : ");
                  String inp = an.nextLine();
                  if(inp.equals("y")){
                      t = true;
                  }else{
                      t = false;
                  }
            }
             else if(temp.equals("6") == true){
                  System.out.println("\n-----Thriller 장르의 영화를 보여드립니다.-----\n");
                  Wait wait = new Wait(thrillerList);
                  wait.printGenre();
                  System.out.print("\n다른 장르의 영화를 더 검색하시겠습니까? (검색을 종료하시려면 n이나 아무키나 누르세요) (y/n) : ");
                  String inp = an.nextLine();
                  if(inp.equals("y")){
                      t = true;
                  }else{
                      t = false;
                  }
            }
            else
            System.out.println("---------------------------------------\n잘못입력하셨습니다.\n알맞은 번호로 다시 입력해주세요.\n--------------------------------------- ");
            
            
       }
           
      }
        
        
        
        
   
    }
    

