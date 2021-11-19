package Command.Boxoffice;
public class All_time implements Command {//역대박스오피스
    
    private Display_All_time All;
    
    public All_time(Display_All_time All){
        this.All = All;
    }
    //Command 인터페이스의 excute 메서드
    public void excute() {
        All.displayAll();
    }
}