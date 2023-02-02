package com.dh.bank.web;

import com.dh.bank.exceptions.MoneyNotEnough;
import com.dh.bank.exceptions.TransferException;
import com.dh.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private AccountServiceImpl accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置请求的编码格式
        request.setCharacterEncoding("UTF-8");
        //取出转账的相关信息
        String fromActNo = request.getParameter("fromActNo");
        String toActNo = request.getParameter("toActNo");
        double money = Double.parseDouble(request.getParameter("money"));

        try {
            accountService.transfer(fromActNo, toActNo, money);
            //运行到这，说明转账成功
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnough e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");
        }
    }
}
