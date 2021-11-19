package Command.Boxoffice;

public class Weekly implements Command { // 주간 박스오피스 클래스

    private Display_Weekly Weekly;

    public Weekly(Display_Weekly Weekly) {
        this.Weekly = Weekly;
    }
    //Command 인터페이스의 excute 메서드
    public void excute() {
        Weekly.DisplayW();
    }

}
