package hungvt.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LogoutServlet"})
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Xóa session
		HttpSession session = req.getSession(false); // Không tạo session mới nếu session không tồn tại
        if (session != null) {
            session.removeAttribute("ADMIN");
            session.invalidate(); // Huỷ session
        }
        
        // Xóa cookie
        Cookie cookie = new Cookie("ADMIN", null);
        cookie.setMaxAge(0); // Đặt thời gian sống là 0 để xóa cookie
        resp.addCookie(cookie);

        // Redirect về trang /login hoặc /home
        resp.sendRedirect(req.getContextPath() + "/views/login.jsp");

	}

}
