package teamwork.com.controller;

import teamwork.com.mapper.UserMapper;
import teamwork.com.pojo.User;
import teamwork.com.utils.ApiResult;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/api/user")
public class UserController extends BaseServlet {
    static UserMapper userMapper = new UserMapper();

    static void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String phone = req.getParameter("phone");
        String identity = req.getParameter("identity");
        userMapper.insertOne(new User(null, username, password, nickname, phone, identity));
        sendJsonResponse(resp, new ApiResult(200, "添加成功", null));
    }

    static void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        userMapper.deleteOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "删除成功", null));
    }

    static void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String phone = req.getParameter("phone");
        String identity = req.getParameter("identity");
        userMapper.updateByOne(new User(Integer.parseInt(id), username, password, nickname, phone, identity));
        sendJsonResponse(resp, new ApiResult(200, "修改成功", null));
    }

    static void selectOne(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        User user = userMapper.selectOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "查询成功", user));
    }

    static void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String pageNum = req.getParameter("page");
        String pageSize = req.getParameter("limit");
        String param = req.getParameter("searchParams");
        if (param == null || param.equals("null")) {
            param = "";
        }
        if (pageNum == null) {
            pageNum = "1";
        }
        if (pageSize == null) {
            pageSize = "10";
        }
        int records = userMapper.getRecords(param);
        sendJsonResponse(resp, new ApiResult(0, "查询成功", records, userMapper.selectByNickname(param, Integer.parseInt(pageNum), Integer.parseInt(pageSize))));
    }

    public void getRecords(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        sendJsonResponse(resp, new ApiResult(200, "查询成功", userMapper.getRecords("")));
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int login = userMapper.login(req.getParameter("username"), req.getParameter("password"));
        if (login == 1) {
            req.getSession().setAttribute("username", req.getParameter("username"));
            sendJsonResponse(resp, new ApiResult(200, "登录成功", null));
        } else {
            sendJsonResponse(resp, new ApiResult(500, "登录失败", null));
        }
    }


}
