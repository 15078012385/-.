package teamwork.com.filter;

import teamwork.com.mapper.SystemLogMapper;
import teamwork.com.pojo.SystemLog;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebFilter("/*")
public class CustomFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CustomFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        统一全站编码
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        // 设置允许跨域的域名，可以根据需要进行修改
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        try {
//            记录访问日志
            signAccessLog(servletRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    private void signAccessLog(ServletRequest servletRequest) throws SQLException {
        //        获取访问uri
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if (requestURI.contains("html")||requestURI.contains("js")||requestURI.contains("css")||requestURI.contains("jpg")||requestURI.contains("png")||requestURI.contains("ico")) {
            return;
        }
//        获取协议、端口、ip
        String scheme = servletRequest.getScheme();
        String serverName = servletRequest.getServerName();
        int serverPort = servletRequest.getServerPort();
        String url = scheme + "://" + serverName + ":" + serverPort + requestURI;
        System.out.println("访问url=====>" + url);
        SystemLog systemLog = new SystemLog();
        systemLog.setAccessUrl(url);
        SystemLogMapper.insertOne(systemLog);
    }

    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy");
    }

}
