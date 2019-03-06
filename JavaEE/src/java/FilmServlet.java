import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/film"})
public class FilmServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // connect to database
        Connection con;
        Statement stmt;
        ResultSet rs;
       
        PrintWriter out = response.getWriter();
        
        // list all film by title and descr
        // try..catch = exceotion/err handling
        // code berada dalam try, catch bila berlaku err
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/sakila", "root", "");
            
            String sql = "SELECT * FROM film LIMIT 10";
            // create an instance of the statement object
            stmt = con.createStatement();
            // execute sql
            rs = stmt.executeQuery(sql);
            //result
            out.print("<h1>LIST OF TOP FILM</h1>");
            out.print("<table border=0 cellpadding=2 cellspacing=2><tr bgcolor=#ff1244><td>No</td><td>Film</td><td>Description</td></tr>");
            while(rs.next()){    
                out.print("<tr bgcolor=#ffffcc>");
                out.print("<td>" + rs.getInt("film_id") + ".</td>");
                out.print("<td>" + rs.getString("title") + "</td>");
                out.print("<td>" + rs.getString("description") + "</td>");  
                out.print("</tr>");
            }
            out.print("</table>"); 
            
        } catch (Exception e) {
            //System.out.println("error conn");
            out.println(e.getMessage());
        }            
    }   
}
