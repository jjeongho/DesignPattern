
package Command.Boxoffice;

public class Upcomming implements Command {//개봉 예정작 클래스
    
    private Display_Upcomming Upcomming;

    public Upcomming(Display_Upcomming Upcomming) {
        this.Upcomming = Upcomming;
    }
    //Command 인터페이스의 excute 메서드
    public void excute() {
        Upcomming.DisplayUp();
    }

}
