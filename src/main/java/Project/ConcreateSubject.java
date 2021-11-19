
package Project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ConcreateSubject implements Observer {
    private ArrayList<Observer> List;
 public ConcreateSubject() {
      List = new ArrayList<Observer>();
   }
   
   public void add(Observer o) {
      List.add(o);
   }

  

   public void people() {
      String [] voices = { "정보", "값" };
      Random r = new Random();
      int index = r.nextInt(voices.length);
      for(int i = 0 ; i < List.size(); i++){
         Observer o = (Observer)List.get(i);
         o.hear(voices[index]);
      }
   }

    @Override
    public void hear(String voice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}