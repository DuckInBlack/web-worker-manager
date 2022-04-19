package pl.pp.manager.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.pp.manager.model.Worker;
import pl.pp.manager.model.WorkersDBUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;


@WebServlet("/list")
public class WorkersController extends HttpServlet {

    @Resource(name = "web-worker-manager-db")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Worker> workers = WorkersDBUtils.getWorkers(dataSource);
        request.setAttribute("workers", workers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/worker/list.jsp");
        dispatcher.forward(request, response);

    }
}
