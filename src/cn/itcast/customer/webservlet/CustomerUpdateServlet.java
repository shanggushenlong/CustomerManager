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

@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置jsp页面输出编码格式
		response.setContentType("text/html;charset=utf8");
		
		//处理请求编码
		request.setCharacterEncoding("utf-8");
		
		//得到请求参数，将具体用户信息封装到javaBean中
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
		
		//调用service中修改操作
		CustomerService service = new CustomerService();
		try {
			service.update(c);
			//重新查询一次
			response.sendRedirect(request.getContextPath()+"/CustomerFindAllServlet");
			return ;
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("更新失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
