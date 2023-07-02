package teamwork.com.controller;

import teamwork.com.mapper.ProductMapper;
import teamwork.com.pojo.Product;
import teamwork.com.utils.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

@WebServlet("/api/product")
public class ProductController extends BaseServlet {
    private static ProductMapper productMapper = new ProductMapper();

    static void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
//       获取实体类字段
        String productName = req.getParameter("productName");
        String productCategory = req.getParameter("productCategory");
        String origin = req.getParameter("origin");
        String price = req.getParameter("price");
//        赋值
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(Integer.parseInt(price));
        product.setProductCategory(productCategory);
        product.setOrigin(origin);
//        调用方法
        productMapper.insertOne(product);
        sendJsonResponse(resp, new ApiResult(200, "添加成功", null));
    }

    static void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        productMapper.deleteOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "删除成功", null));
    }

    static void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        //       获取实体类字段
        String id = req.getParameter("id");
        String productName = req.getParameter("productName");
        String price = req.getParameter("price");
        String productCategory = req.getParameter("productCategory");
        String origin = req.getParameter("origin");
//        赋值
        Product product = new Product();
        product.setId(Integer.parseInt(id));
        product.setProductName(productName);
        product.setPrice(Integer.parseInt(price));
        product.setProductCategory(productCategory);
        product.setOrigin(origin);
//        调用方法
        productMapper.updateByOne(product);
        sendJsonResponse(resp, new ApiResult(200, "修改成功", null));
    }

    static void selectOne(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        Product product = productMapper.selectOneById(Integer.parseInt(id));
        sendJsonResponse(resp, new ApiResult(200, "查询成功", product));
    }

    static void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String pageNum = req.getParameter("page");
        String pageSize = req.getParameter("limit");
        String param = req.getParameter("searchParams");

        int records = productMapper.getRecords(param);
        if (param == null||param.equals("null")) {
            param = "";
        }
        if (pageNum == null) {
            pageNum = "1";
        }
        if (pageSize == null) {
            pageSize = "10";
        }
        sendJsonResponse(resp, new ApiResult(0, "查询成功",records, productMapper.selectByProductName(param,Integer.parseInt(pageNum),Integer.parseInt(pageSize))));
    }


    public void getRecords(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        sendJsonResponse(resp, new ApiResult(200, "查询成功", productMapper.getRecords("")));
    }


}