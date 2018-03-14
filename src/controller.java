import com.domain.Person;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

public class controller extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Collection<Person> personList = new ArrayList<Person>();
        String key = request.getParameter("key");
        String firsName = request.getParameter("fistName");
        String lastName = request.getParameter("lastName");
        if (key != null && firsName != null && lastName != null) {
            HttpSession session = request.getSession();
            try {
                personList = (Collection<Person>) session.getAttribute("list");
                if (personList == null)

                {
                    personList = new ArrayList<>();
                    session.setAttribute("list",personList);
                }
                personList.add(new Person(key,firsName,lastName));

            } catch (ClassCastException e) {
                e.printStackTrace();
            }

        }
        out.println("<html>");
        out.println("<body>");
        out.print("<table border= '1'>");
        for (Person person:personList){
            out.println("<tr><th>" + person.getKey() +"</th><th>" + person.getFirstName()+"</th><th>"+ person.getLastName() +"</th><th>");
        }
        out.println("</table>");
        out.print("<br>");
        out.println("<form method=GET action=AddPersonServlet>");
        out.println("Key=<input type=text name=key>");
        out.println("First Name=<input type=text name=firstname>");
        out.println("Last Name=<input type=text name=lastname>");
        out.println("<input type=submit value='Add'>");
        out.println("</body>");
        out.println("</html>");
    }
}
