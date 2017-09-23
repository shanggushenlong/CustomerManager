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

@WebServlet("/CustomerFindAllServlet")
public class CustomerFindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置页面输出文本格式
		response.setContentType("text/html;charset=utf-8");
		
		CustomerService service = new CustomerService();
		//调用service层中的方法，
		try {
			List<Customer> cs = service.findAll();
			
			//将dao层所传回来的list结果集，存入到request域中，然后通过转发到jsp页面中，有jsp显示出来
			//先存储
			request.setAttribute("cs", cs);
			//后转发
			request.getRequestDispatcher("/showCustomer.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			//在此处进行异常处理,向页面输出打印错误信息
			response.getWriter().write("查询不到客户信息");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
