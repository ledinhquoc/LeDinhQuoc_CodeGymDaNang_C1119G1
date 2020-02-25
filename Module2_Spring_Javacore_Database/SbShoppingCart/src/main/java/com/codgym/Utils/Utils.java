package com.codgym.Utils;

import com.codgym.model.CartInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
    public static CartInfo getCartInSession(HttpServletRequest request){
        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("mayCart");

        if (cartInfo ==null){
            cartInfo = new CartInfo();
            request.getSession().setAttribute("myCart",cartInfo);
        }
        return cartInfo;
    }

    public static void removeCartSession(HttpServletRequest request){
        request.getSession().removeAttribute("myCart");
    }

    public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo){
        request.getSession().setAttribute("lastOrderedCart",cartInfo);
    }

    public static CartInfo getLastOrderedCartInSession(HttpServletRequest request){
        return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
    }
}
