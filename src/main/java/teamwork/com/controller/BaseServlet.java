package teamwork.com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import teamwork.com.utils.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(operation)) {
                try {
                    method.invoke(this, req, resp);
                } catch (Exception e) {
                    // 全局异常处理
                    sendJsonResponse(resp, new ApiResult(500, "服务器内部错误", e.getMessage()));
                    e.printStackTrace();
                }
            }
        }
    }

    //    响应json
    protected static void sendJsonResponse(HttpServletResponse response, Object responseObject) throws IOException {
        // 使用 ObjectMapper 将 Java 对象转换为 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(responseObject);
        // 设置响应的内容类型为 "application/json"
        response.setContentType("application/json");
        // 将 JSON 字符串作为响应的内容写入输出流
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

}
