package hungvt.controllers;

import java.io.IOException;

import hungvt.models.UserModel;
import hungvt.services.IUserService;
import hungvt.services.impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public IUserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");        
		String password = req.getParameter("password");       
		String confirmPassword = req.getParameter("confirmPassword");
		String alertMsg = "";
		
		if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            alertMsg = "Các ô không được rỗng";
        } else if (!password.equals(confirmPassword)) {
            alertMsg = "Mật khẩu xác nhận không khớp";
        } else if (service.checkUserExist(username)) {
            alertMsg = "Tên tài khoản đã tồn tại";
        } else {
            UserModel user = new UserModel();
            service.register(user);
            alertMsg = "Đăng ký thành công!";
            resp.sendRedirect(req.getContextPath() + "/LoginServlet");
            
        }		
		req.setAttribute("alert", alertMsg);
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);        
        return;
        }
	}


