package teamwork.com.controller;

import teamwork.com.mapper.SystemLogMapper;
import teamwork.com.utils.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

@WebServlet("/api/system-log")
public class SystemLogController extends BaseServlet {
    private static SystemLogMapper mapper = new SystemLogMapper();


    static void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
//        获取实体类字段
        sendJsonResponse(resp, new ApiResult(200, "添加成功", null));
    }

    static void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        mapper.deleteOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "删除成功", null));
    }

    static void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        sendJsonResponse(resp, new ApiResult(200, "修改成功", null));
    }

    static void selectOne(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        sendJsonResponse(resp, new ApiResult(200, "查询成功", null));
    }

    static void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String pageNum = req.getParameter("page");
        String pageSize = req.getParameter("limit");
        String param = req.getParameter("searchParams");

        int records = mapper.getRecords(param);
        if (param == null||param.equals("null")) {
            param = "";
        }
        if (pageNum == null) {
            pageNum = "1";
        }
        if (pageSize == null) {
            pageSize = "10";
        }

        sendJsonResponse(resp, new ApiResult(0, "查询成功", records,mapper.selectByAccessUrl(param, Integer.parseInt(pageNum), Integer.parseInt(pageSize))));
    }


}
