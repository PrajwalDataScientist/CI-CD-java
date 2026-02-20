package com.game;

import java.io.IOException;
import java.util.Random;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/play")
public class NumberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userNumber = Integer.parseInt(request.getParameter("number"));
        int randomNumber = new Random().nextInt(10) + 1;

        if (userNumber == randomNumber) {
            request.setAttribute("result", "🎉 You Won! Correct Number was " + randomNumber);
        } else {
            request.setAttribute("result", "❌ Try Again! Correct Number was " + randomNumber);
        }

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
