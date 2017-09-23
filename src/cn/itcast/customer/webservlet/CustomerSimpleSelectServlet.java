package cn.itcast.customer.webservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.customer.domain.Customer;
import cn.itcast.customer.service.CustomerService;

@WebServlet("/CustomerSimpleSelectServlet")
public class CustomerSimpleSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("utf-8");
		
		//1.得到请求参数
		String field = request.getParameter("field");
		String msg = request.getParameter("msg");
		
		//2.调用service完成查询操作
		CustomerService service = new CustomerService();
		try {
			List<Customer> cs  = service.simpleSelect(field,msg);
			
			request.setAttribute("cs", cs);
			request.getRequestDispatcher("/showCustomer.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("条件查询失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
