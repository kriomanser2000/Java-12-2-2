package com.example.java1222.model.servlet;

@WebServlet("/login")
public class UserServlet extends HttpServlet
{
    private Map<String, User> users = new HashMap<>();
    @Override
    public void init()
    {
        users.put("admin", new User("admin", "admin123", "ADMIN"));
        users.put("user", new User("user", "user123", "USER"));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password))
        {
            request.getSession().setAttribute("user", user);
            if ("ADMIN".equals(user.getRole()))
            {
                response.sendRedirect("admin");
            }
            else
            {
                response.sendRedirect("quiz");
            }
        }
        else
        {
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }
}
