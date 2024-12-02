package com.example.java1222.model.servlet;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet
{
    private Map<String, QuizCategory> categories = new HashMap<>();
    private List<Question> questions = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole()))
        {
            response.sendRedirect("login.jsp");
            return;
        }
        request.setAttribute("categories", categories.values());
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }
}
