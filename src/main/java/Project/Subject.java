
package Project;
import java.util.List;


public  class Subject implements Observer {
     private String name;
   public String getName() {
      return name;
   }
   public Subject(String name) {
      this.name = name;
   }
   @Override
   public void hear(String voice) {
      System.out.println(name +"께서 \"" + voice + "\"를 입력받았습니다.");
   }

    @Override
    public void add(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void people() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}