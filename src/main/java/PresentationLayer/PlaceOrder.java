/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LegoHouseException;
import FunctionLayer.LegoHouseFactory;
import FunctionLayer.LineItem;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mads Voss
 */
public class PlaceOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int h = Integer.parseInt(request.getParameter("height"));
        int l = Integer.parseInt(request.getParameter("length"));
        int w = Integer.parseInt(request.getParameter("width"));
        List<LineItem> list = LegoHouseFactory.buildLegoHouse(l, w, h, user);
        request.setAttribute("LineItems", list);
        return "confirmation";
    }
    
}
