package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();
        response.setContentType("text/html;charset=UTF-8");
        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        Path path = Paths.get("src/main/resources/users.json").normalize();
        String file = Files.readString(path);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> users = objectMapper.readValue(file, List.class);
        return users;
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {
        List<Map<String, Object>> users = getUsers();
        String line = "<tr><td>%s</td><td><a href=\"/users/%s\">%s</a></td></tr>";
        String body = "<table>" + users.stream()
                .map(user -> line.formatted(user.get("id"),
                                            user.get("id"),
                                            user.get("firstName") + " " + user.get("lastName")))
                .collect(Collectors.joining("\n")) + "</table>";
        PrintWriter out = response.getWriter();
        out.println(body);
        out.close();
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {
        List<Map<String, Object>> users = getUsers();
        String tableBody = users.stream()
                .filter(user -> user.get("id").equals(id))
                .map(user -> user.keySet().stream()
                        .map(key -> "<tr><td>" + key + "</td><td>" + user.get(key) + "</td></tr>")
                        .collect(Collectors.joining("\n")))
                .collect(Collectors.joining());
        if (tableBody.isEmpty()) {
            response.sendError(404);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<table>" + tableBody + "</table>");
            out.close();
        }
    }
}
