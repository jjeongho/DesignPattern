package Command.Boxoffice;

public class Current implements Command {

    private Display_Current Current;

    public Current(Display_Current Current) {
        this.Current = Current;
    }

    //Command 인터페이스의 excute 메서드
    public void excute() {
        Current.DisplayC();
    }
}

