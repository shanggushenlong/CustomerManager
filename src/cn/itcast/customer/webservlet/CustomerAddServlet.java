package cn.itcast.customer.webservlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import cn.itcast.customer.domain.Customer;
import cn.itcast.customer.service.CustomerService;
import cn.itcast.customer.util.IdUtils;

@WebServlet("/CustomerAddServlet")
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置post请求编码
		request.setCharacterEncoding("utf-8");
		
		//得到所有的请求参数，将其封装到javaBean中
		Customer c = new Customer();
		
		//格式转换
		DateConverter dc = new DateConverter();
		dc.setPattern("yyyy-MM-dd");
		try {
			ConvertUtils.register(dc,java.util.Date.class);
			BeanUtils.populate(c, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//上面封装到javaBean中的数据没有Id，所有手动的设置id
		c.setId(IdUtils.getUUId());
		
		//2.调用service中的方法，完成操作
		CustomerService service = new CustomerService();
		try {
			service.add(c);
			
			//如果添加成功,重新查询一下页面
			response.sendRedirect(request.getContextPath()+"/CustomerFindAllServlet");
			return ;
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("add.message", "添加客户信息失败");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return ;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
