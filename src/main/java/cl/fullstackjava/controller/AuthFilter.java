package cl.fullstackjava.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Aplica el filtro a todas las URLs que empiecen con /views/

@WebFilter("/views/*")
public class AuthFilter extends HttpFilter implements Filter {
       
    public AuthFilter() {
        super();
    }

	public void destroy() {
	}
	
	// Método principal del filtro que intercepta las solicitudes
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		
		// Cache
		httpResponse.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
		httpResponse.setHeader("Pragma", "no-cache");
		httpResponse.setDateHeader("Expires", 0);
		
		// Verificar si el usuario está autenticado
		boolean loggedIn = (session != null && session.getAttribute("username") != null);
		String loginURI = httpRequest.getContextPath() + "/user?view=login";
		String registerURI = httpRequest.getContextPath() + "/user?view=create";
		
		// Verificar si la solicitud es para la página de login o de registro
		boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean registerRequest = httpRequest.getRequestURI().equals(registerURI);
		boolean registerPage = httpRequest.getRequestURI().endsWith("registro.jsp");
		boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
		
		// Permitir la solicitud si el usuario está autenticado, o si es una solicitud de login o registro
		if (loggedIn || loginRequest || registerRequest || registerPage || loginPage) {
			chain.doFilter(request, response);
		} else {
			// Redirigir a la página de login si el usuario no está autenticado
			httpResponse.sendRedirect(loginURI);
		}
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	
}
