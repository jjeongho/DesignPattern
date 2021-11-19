package Project;

import Iterator.MovieControl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Genre implements MenuBehavior {

    public void Action() {
        System.out.println("장르별 영화");
        MovieControl m = new MovieControl();
        try {
            m.test();
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        Start s = new Start();
        s.StartMenu();
    }
}
