package www.aic.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// 获得全局属性
		ServletContext context = req.getServletContext();
		String jspPrefix = (String) context.getAttribute("jsp_folder");
		req.getRequestDispatcher(jspPrefix + "form.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println(name + age);

		HttpSession s = req.getSession();
		s.setAttribute("sessionObj", name + age);
		resp.sendRedirect("jsp/hello.jsp");
	}

}
