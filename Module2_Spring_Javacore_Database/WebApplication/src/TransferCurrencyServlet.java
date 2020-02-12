import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TransferCurrencyServlet", urlPatterns = "/convert")
public class TransferCurrencyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float vnd = rate * usd;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h3>Rate:" + rate  + "</h3>");
        writer.println("<h3>USD:" + usd  + "</h3>");
        writer.println("<h3>VND:" + vnd  + "</h3>");
        writer.println("</html>");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
