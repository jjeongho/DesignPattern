package Command.Boxoffice;

public class Boxoffice {

    private Command theCommand;
    //생성자에서 버튼을 눌렀을 때 필요한 기능을 인자로 받는다.

    public Boxoffice(Command theCommand) {
        setCommand(theCommand);
    }

    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }
    // 실행시 주어진 Command의 execute 메서드를 호출한다.
    public void Display() {
        theCommand.excute();
    }

}
