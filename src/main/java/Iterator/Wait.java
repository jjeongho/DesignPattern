/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Wait {
    ArrayList<Genre> genres;

    public Wait(ArrayList<Genre> genres) {
        this.genres = genres;
    }
    
    
    
    public void printGenre(){
        Iterator genreIterator = genres.iterator();
        while(genreIterator.hasNext()){
            Genre genre = (Genre) genreIterator.next();
            printGenre(genre.createIterator());
        }
    }

    private void printGenre(Iterator<Movie> iterator) {
       while(iterator.hasNext()){
           Movie movie = iterator.next();
           System.out.println(movie.getName());
       }
    }


    
}
