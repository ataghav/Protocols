package javasample.web;

import javasample.controller.BankAccountController;
import javasample.entity.BankAccount;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;



@WebServlet("/FindAccountServletAjax")
public class FindAccountServletAjax extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        String owner = request.getParameter("owner");
        String balance = request.getParameter("balance");
        String find = request.getParameter("find");
        String create = request.getParameter("create");
        String delete = request.getParameter("delete");
        String update = request.getParameter("update");
        int num = Integer.parseInt(number);
        BankAccount ba = new BankAccount();
        BankAccountController controller = new BankAccountController();


        if (find!=(null))
        {
            ba = controller.findByNumber(num);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            if (ba == null){
                out.println("the account does not exist ");
                out.println("<a href=http://localhost:8080/bankForm.html>Back</a>");
            }else {
                out.println("Number: " + ba.getNumber());
                out.println("<br>");
                out.println("Owner: " + ba.getOwner());
                out.println("<br>");
                out.println("Balance: " + ba.getBalance());
                out.println("<br>");
                out.println("<a href=http://localhost:8080/bankForm.html>Back</a>");
            }
            out.println("</html>");
            out.close();
        }
        else if (create!=(null))
        {
            long bal = Long.parseLong(balance);
            ba.setNumber(num);
            ba.setOwner(owner);
            ba.setBalance(bal);
            controller.createAccount(ba);
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("Create account for " + ba.getOwner());
            out.println("<br>");
            out.println("<a href=http://localhost:8080/bankForm.html>Back</a>");
            out.println("</html>");
            out.close();
        }
        else if (delete!=(null))
        {
            String msg = controller.deleteByNumber(num);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println(msg);
            out.println("<br>");
            out.println("<a href=http://localhost:8080/bankForm.html>Back</a>");
            out.println("</html>");
            out.close();
        }
        else if (update!=(null))
        {
            long bal = Long.parseLong(balance);
            ba.setNumber(num);
            ba.setOwner(owner);
            ba.setBalance(bal);
            String msg = controller.updateAccount(ba);
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println(msg);
            out.println("<br>");
            out.println("<a href=http://localhost:8080/bankForm.html>Back</a>");
            out.println("</html>");
            out.close();
        }

    }



}
