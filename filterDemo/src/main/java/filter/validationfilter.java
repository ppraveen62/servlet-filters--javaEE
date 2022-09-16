package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Filter implementation class validationfilter
 */
public class validationfilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public validationfilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String pan = request.getParameter("pan");
		System.out.println("hai from filter");
		
		if (pan== null || !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			
			PrintWriter writer=response.getWriter();
			request.getRequestDispatcher("index.html").include(request, response);
			writer.println("<span style = 'color:red'> invalid pan no </span>");
		}
		else {
			request.setAttribute("pan", pan);	
			chain.doFilter(request, response);
			
			System.out.println("bye from filter");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
