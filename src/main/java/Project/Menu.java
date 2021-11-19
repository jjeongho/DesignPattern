package Project;

public class Menu {

    private MenuBehavior menubehavior;

    public Menu(MenuBehavior menubehavior) {
        this.menubehavior = menubehavior;
    }

    public void Change() {
        menubehavior.Action();
    }

    public void setMenuBehavior(MenuBehavior menubehavior) {
        this.menubehavior = menubehavior;
    }

}


