package teamwork.com.controller;

import teamwork.com.mapper.AddressMapper;
import teamwork.com.pojo.Address;
import teamwork.com.utils.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

@WebServlet(value = "/api/address")
public class AddressController extends BaseServlet {
    public static AddressMapper addressMapper = new AddressMapper();

    static void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
//        获取参数
        String userId = req.getParameter("userId");
        String recipientName = req.getParameter("recipientName");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
//       赋值给对象
        Address address1 = new Address(null, Integer.parseInt(userId), recipientName, address, phone);
//        调用mapper
        addressMapper.insertOne(address1);
        sendJsonResponse(resp, new ApiResult(200, "添加成功", null));
    }

    static void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        addressMapper.deleteOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "删除成功", null));
    }

    static void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        //        获取参数
        String userId = req.getParameter("userId");
        String recipientName = req.getParameter("recipientName");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String id = req.getParameter("id");
//       赋值给对象
        Address address1 = new Address(Integer.parseInt(id), Integer.parseInt(userId), recipientName, address, phone);
        addressMapper.updateByOne(address1);
        sendJsonResponse(resp, new ApiResult(200, "修改成功", null));
    }

    static void selectOne(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        Address address = addressMapper.selectOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "查询成功", address));
    }

    static void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String pageNum = req.getParameter("page");
        String pageSize = req.getParameter("limit");
        String param = req.getParameter("searchParams");
        int records = addressMapper.getRecords(param);
        if (param == null||param.equals("null")) {
            param = "";
        }
        if (pageNum == null) {
            pageNum = "1";
        }
        if (pageSize == null) {
            pageSize = "10";
        }
        sendJsonResponse(resp, new ApiResult(0, "查询成功", records, addressMapper.selectByAddress(param, Integer.parseInt(pageNum), Integer.parseInt(pageSize))));
    }


}
