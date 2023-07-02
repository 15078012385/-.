package teamwork.com.controller;

import teamwork.com.mapper.OrderMapper;
import teamwork.com.pojo.Order;
import teamwork.com.utils.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/api/order")
public class OrderController extends BaseServlet {
    protected static OrderMapper orderMapper = new OrderMapper();

    static void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
//        获取实体类参数
        Order order = new Order();
        order.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        order.setTotalPrice(Integer.parseInt(req.getParameter("totalPrice")));
        order.setProductId(Integer.parseInt(req.getParameter("productId")));
        order.setUserId(Integer.parseInt(req.getParameter("userId")));
        order.setProductName(req.getParameter("productName"));
        order.setNickname(req.getParameter("nickname"));
        order.setAddress(req.getParameter("address"));
        orderMapper.insertOne(order);
        sendJsonResponse(resp, new ApiResult(200, "添加成功", null));
    }

    static void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        orderMapper.deleteOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "删除成功", null));
    }

    static void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        //        获取实体类参数
        Order order = new Order();
        order.setProductId(Integer.parseInt(req.getParameter("productId")));
        order.setUserId(Integer.parseInt(req.getParameter("userId")));
        order.setId(Integer.valueOf(req.getParameter("id")));
        order.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        order.setTotalPrice(Integer.parseInt(req.getParameter("totalPrice")));
        order.setProductName(req.getParameter("productName"));
        order.setNickname(req.getParameter("nickname"));
        order.setAddress(req.getParameter("address"));
        orderMapper.updateByOne(order);
        sendJsonResponse(resp, new ApiResult(200, "修改成功", null));
    }

    static void selectOne(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        Order order = orderMapper.selectOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "查询成功", order));
    }

    static void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String pageNum = req.getParameter("page");
        String pageSize = req.getParameter("limit");
        String param = req.getParameter("searchParams");

        int records = orderMapper.getRecords(param);
        if (param == null || param.equals("null")) {
            param = "";
        }
        if (pageNum == null) {
            pageNum = "1";
        }
        if (pageSize == null) {
            pageSize = "10";
        }

        sendJsonResponse(resp, new ApiResult(0, "查询成功", records, orderMapper.selectByNickname(param, Integer.parseInt(pageNum), Integer.parseInt(pageSize))));
    }

    public void getRecords(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        sendJsonResponse(resp, new ApiResult(200, "查询成功", orderMapper.getRecords("")));
    }

}
