package Project;

class List implements MenuBehavior {

    public void Action() {
        System.out.println("실시간 검색어");
        ActorList a = new ActorList();
        a.List();
        MovieList m = new MovieList();
        m.List();
        Start s = new Start();
        s.StartMenu();
    }

}
