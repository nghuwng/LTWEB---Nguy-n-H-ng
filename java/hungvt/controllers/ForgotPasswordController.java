package hungvt.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ForgotPasswordServlet"})
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
        String alertMsg;
        
        if (email == null || email.isEmpty()) {
            alertMsg = "Email không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
            return;
        }
        
        // Tạo logic giả lập đặt lại mật khẩu (không gửi email)
        boolean isTokenCreated = true; // Giả lập rằng token đã được tạo thành công

        if (isTokenCreated) {
            alertMsg = "Liên kết đặt lại mật khẩu đã được tạo thành công! Vui lòng kiểm tra email của bạn.";
        } else {
            alertMsg = "Có lỗi xảy ra, vui lòng thử lại!";
        }

        req.setAttribute("alert", alertMsg);
        req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}

}
