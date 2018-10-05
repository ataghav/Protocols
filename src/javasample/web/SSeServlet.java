package javasample.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SSeServlet")
public class SSeServlet extends HttpServlet {

	@Override
    public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/event-stream");	
		PrintWriter out = response.getWriter();

		for(int i=0; i<60; i++) {
			out.write("data: " + System.currentTimeMillis() + "\n\n");
                        out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.close();
                
	}

    
}
