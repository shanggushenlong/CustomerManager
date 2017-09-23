package cn.itcast.customer.webservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.customer.service.CustomerService;

@WebServlet("/CustomerDelSelectServlet")
public class CustomerDelSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		// 1.得到所有要删除的客户的id
		String[] id = request.getParameterValues("ck");

		// 2.调用service，完成批量删除
		CustomerService service = new CustomerService();
		try {
				service.delSelect(id);
				response.sendRedirect(request.getContextPath() + "/CustomerFindAllServlet");
				return;	
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("批量删除失败");
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
