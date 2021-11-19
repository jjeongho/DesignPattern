/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import Decorator.Control;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Recommend implements MenuBehavior {

    public void Action() {
        System.out.println("영화 추천 받기");
        Control t = new Control();
        try {
            t.test();
        } catch (SQLException ex) {
            Logger.getLogger(Recommend.class.getName()).log(Level.SEVERE, null, ex);
        }
        Start s = new Start();
        s.StartMenu();
    }
}
