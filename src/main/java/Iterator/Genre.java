/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.util.Iterator;


public interface Genre {
    public Iterator<Movie> createIterator();
}
