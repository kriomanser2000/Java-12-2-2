package com.example.java1222.model.servlet;

@WebServlet("/theme")
public class ThemeServlet extends HttpServlet
{
    private List<String> themes = List.of("default", "christmas", "halloween", "summer");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("themes", themes);
        request.getRequestDispatcher("/theme.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String selectedTheme = request.getParameter("theme");
        request.getSession().setAttribute("theme", selectedTheme);
        response.sendRedirect("admin");
    }
}