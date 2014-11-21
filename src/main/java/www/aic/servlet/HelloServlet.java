package www.aic.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		String isRedirectStr = req.getParameter("forward");
		Boolean isRedirect = Boolean.parseBoolean(isRedirectStr);

		// jsp中可以看到
		req.setAttribute("name", "haha");

		List<Integer> testList = new ArrayList<Integer>();

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			testList.add(r.nextInt(100));
		}

		// jsp中可以看到
		req.setAttribute("list", testList);
		
		HttpSession s = req.getSession();
		s.setAttribute("sessionObj", "I am in session!");

		ServletContext context = req.getServletContext();
		// 获得全局属性
		String jspPrefix = (String) context.getAttribute("jsp_folder");
		
		
		// forward, request中属性可以获得，并且浏览器中的url不改变
		if (!isRedirect)
			//这里的路径为/jsp/hello.jsp
			req.getRequestDispatcher(jspPrefix + "hello.jsp")
					.forward(req, resp);
		else
			//浏览器中url改变,这里的路径为jsp/hello.jsp，为何和forward的路径不一样（hint:sendRedirect和forward机制不同）
			//sendRedirect后request中参数没有了
			resp.sendRedirect("jsp/hello.jsp");
	}
	

}
