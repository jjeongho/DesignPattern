/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ThrillerGenre implements Genre {
    private final ArrayList<Movie> movies = new ArrayList<Movie>();

    public ThrillerGenre() throws SQLException, ClassNotFoundException {
        
        Connection con = MyConnect.getConnection();
        String sql = "SELECT * FROM searchword.movie_genre WHERE m_genre = 'thriller'";
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            Movie movie = new Movie();
            movie.setName(rs.getString("m_name"));
            movies.add(movie);
        }
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    @Override
    public Iterator<Movie> createIterator() {
        return movies.iterator();
    }
    
    
    
}
