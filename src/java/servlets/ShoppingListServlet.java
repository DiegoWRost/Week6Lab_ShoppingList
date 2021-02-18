
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego Weidle Rost
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = (String) session.getAttribute("username");
        
        String registerURL = "/WEB-INF/register.jsp";
        String shoppingURL = "/WEB-INF/shoppinglist.jsp";
            
        if (action != null && action.equals("logout")) {
           session.invalidate();
           getServletContext().getRequestDispatcher(registerURL).forward(request, response);
        }
        
        if (username != null && !username.isEmpty()) {
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher(shoppingURL).forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(registerURL).forward(request, response);
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String userField = request.getParameter("username");
        
        String registerURL = "/WEB-INF/register.jsp";
        String shoppingURL = "/WEB-INF/shoppinglist.jsp";
        String action = request.getParameter("action");
        
        if (userField != null && !userField.isEmpty() && action.equals("register")) {
            session.setAttribute("username", userField);
            getServletContext().getRequestDispatcher(shoppingURL).forward(request, response);
        } else {
            request.setAttribute("message", "Error: Username cannot be empty");
            request.setAttribute("userField", userField);
            getServletContext().getRequestDispatcher(registerURL).forward(request, response);
        }
    }
}