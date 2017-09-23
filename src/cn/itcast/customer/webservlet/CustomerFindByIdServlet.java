package cn.itcast.customer.webservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.customer.domain.Customer;
import cn.itcast.customer.service.CustomerService;

@WebServlet("/CustomerFindByIdServlet")
public class CustomerFindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       /**
        * 编辑：
        * 1 查询，做回显示
        * 	(1)创建CustomerFindByIdServlet,得到要查询的id，调用service方法，得到customer对象
        * 	(2)将customer对象存储到request域中，请求转发到customerInfo.jsp页面中
        * 	（3）在customerInfo.jsp页面中将客户信息展示出来
        * 2 修改
        * 	(1) 使用BeanUtils时出现类型转换问题 
        * 	(2) 注意编码问题
        * 			post请求： request.setCharacterEncoding("utf-8");
        * 			get请求： new String(request.getParameter(name).getBytes("iso8859-1"),"utf-8");
        */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到要查询的id值
		String id = request.getParameter("id");
		//调用service层中的方法，根据id查询的方法
		CustomerService service = new CustomerService();
		try {
			Customer c = service.findById(id);
			
			//存储，转发
			request.setAttribute("c", c);
			request.getRequestDispatcher("/customerInfo.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("查询失败");
			return ;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}























