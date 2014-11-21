package www.aic.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationStarter implements ServletContextListener {

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//放在这个文件夹下更安全，用户通过输入jsp是找不到的
		sce.getServletContext().setAttribute("jsp_folder", "/jsp/");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
