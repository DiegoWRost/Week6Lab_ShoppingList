
package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
        System.out.println(action); // FOR TESTING
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
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        String userField = request.getParameter("username");
        String action = request.getParameter("action");

        String registerURL = "/WEB-INF/register.jsp";
        String shoppingURL = "/WEB-INF/shoppinglist.jsp";
        
        String item;
//        String listItem;

        if (action != null) {
            switch (action) {
                case "register":
                    if (userField != null && !userField.isEmpty()) {
                        items = new ArrayList<>();
                        
                        session.setAttribute("username", userField);
                        session.setAttribute("items", items);
                        getServletContext().getRequestDispatcher(shoppingURL).forward(request, response);
                    } else {
                        request.setAttribute("message", "Error: Username cannot be empty");
                        getServletContext().getRequestDispatcher(registerURL).forward(request, response);
                    }
                    break;
                case "add":
                    item = request.getParameter("item");
                    if (item != null && !item.isEmpty()) {
                        items.add(item);
                    } else {
                        request.setAttribute("message", "Error: Item cannot be empty");
                    }
                    getServletContext().getRequestDispatcher(shoppingURL).forward(request, response);
                    break;
            }
        
//        if (action != null && action.equals("delete")) {
//            listItem
//            getServletContext().getRequestDispatcher(shoppingURL).forward(request, response);
//        }
        }
        
    }
}