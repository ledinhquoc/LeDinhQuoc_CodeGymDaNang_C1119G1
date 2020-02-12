import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet(name = "Calculator", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post here");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        int discount_percent = Integer.parseInt(request.getParameter("discount"));
        float discount = (float) (price * discount_percent * 0.01);
        float total = price - discount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "  <head>\n" +
                "    <title>$Title$</title>\n" +
                "    <style>\n" +
                "      #content{\n" +
                "        width:450px;\n" +
                "        margin: 0 auto;\n" +
                "        padding: 0px 20px 20px;\n" +
                "        background: white;\n" +
                "        border: solid navy 2px;\n" +
                "      }\n" +
                "      label{\n" +
                "        width: 10em;\n" +
                "        padding-right: 1em;\n" +
                "        float: left;\n" +
                "      }\n" +
                "      #data input{\n" +
                "        float: left;\n" +
                "        width: 15em;\n" +
                "        margin-bottom: .5em;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "  <div id=\"content\">\n" +
                "    <h1>Product Discount Calculator</h1>\n" +
                "    <form action=\"/calculator\" method=\"post\">\n" +
                "      <div id=\"data\">\n" +
                "        <label>Product Description</label>\n" + description +
                "\n" +
                "        <br>\n" +
                "        <label>Price</label>\n" + price +
                "\n" +
                "        <br>\n" +
                "        <label>Discount Percent</label>\n" + discount_percent +
                "\n" +
                "        <br>\n" +
                "        <label>Product discount</label>\n" + discount +
                "\n" +
                "        <br>\n" +
                "        <label>Product Total</label>\n" + total +
                "\n" +
                "    </form>\n" +
                "  </div>\n" +
                "  </body>\n" +
                "</html>");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get here");
    }
}
