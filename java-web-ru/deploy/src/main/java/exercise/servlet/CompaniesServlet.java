package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {
        PrintWriter pw = response.getWriter();
        List<String> companies = getCompanies();
        Optional search = Optional.ofNullable(request.getParameter("search"));
        String result = companies.stream()
                .filter(o-> o.contains(search.orElse("").toString()))
                .collect(Collectors.joining("\n"));
        pw.write(result.isEmpty() ? "Companies not found" : result);
        pw.close();
    }
}
