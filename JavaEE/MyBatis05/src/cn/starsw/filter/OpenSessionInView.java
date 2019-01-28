package cn.starsw.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import cn.starsw.util.MyBatisUti;

/**
 * Servlet Filter implementation class OpenSessionInView
 */
@WebFilter("/*")
public class OpenSessionInView implements Filter {

    /**
     * Default constructor. 
     */
    public OpenSessionInView() {
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
		SqlSession sqlSession = MyBatisUti.getSession();
		
		try {
			chain.doFilter(request, response);
			sqlSession.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			sqlSession.rollback();
		}
		finally{
			MyBatisUti.closeSession();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
