package cn.itcast.customer.webservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.customer.service.CustomerService;

@WebServlet("/CustomerDelByIdServlet")
public class CustomerDelByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 进行删除操作
	 * 1.在showCustomer.jsp页面的删除链接上添加参数 客户的id
	 * 2.创建一个CustomerDelByIdServlet，获取请求参数，调用service层中的删除方法
	 * 注意：如果删除完成后，怎样处理？
	 * 		需要重新跳转到查询所有客户信息的servlet中，再重新查询数据
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		//首先获取请求的要删除的id
		String id = request.getParameter("id");
		
		CustomerService service = new CustomerService();
		
		try {
			service.delById(id);
			
			//跳转到CustomerFindAllServlet,实质就是重新再次查询一次数据
			response.sendRedirect(request.getContextPath()+"/CustomerFindAllServlet");
			return ;
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("删除失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
