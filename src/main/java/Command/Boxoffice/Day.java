package Command.Boxoffice;

public class Day implements Command { // 일간 박스오피스 클래스
    
    private Display_Day Day;
    
    public Day(Display_Day Day){
        this.Day = Day;
    }
    //Command 인터페이스의 excute 메서드
    public void excute() {
        Day.DisplayD();
    }

}
