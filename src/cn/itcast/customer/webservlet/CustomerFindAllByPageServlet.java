package cn.itcast.customer.webservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.customer.domain.PageBean;
import cn.itcast.customer.service.CustomerService;

@WebServlet("/CustomerFindAllByPageServlet")
public class CustomerFindAllByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.默认访问第一页
		int pageNum = 1;
		
		String _pageNum = request.getParameter("pageNum");
		if(_pageNum != null){
			pageNum = Integer.parseInt(_pageNum);
		}
		
		//2.每页条数 人为定义
		int currentPage = 5;
		
		String _currentPage = request.getParameter("currentPage");
		if(_currentPage != null){
			currentPage = Integer.parseInt(_currentPage);
		}
		
		//3.调用service,完成查询当前页数据操作
		CustomerService service = new CustomerService();
		try {
			PageBean pb = service.findByPage(pageNum,currentPage);
			
			//4.将数据存储到request域中,请求转发到页面展示
			request.setAttribute("pb", pb);
			request.getRequestDispatcher("/showCustomerByPage.jsp").forward(request, response);
			request.setAttribute("pb", pb);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
