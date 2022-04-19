package pl.pp.manager.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.pp.manager.model.Worker;
import pl.pp.manager.model.WorkersDBUtils;

import java.io.IOException;
import java.util.List;


@WebServlet("/list")
public class WorkersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Worker> workers = WorkersDBUtils.getWorkers();
        request.setAttribute("workers", workers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/worker/list.jsp");
        dispatcher.forward(request, response);

    }
}
