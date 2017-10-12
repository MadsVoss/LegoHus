/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LegoHouseException;
import FunctionLayer.LineItem;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mads Voss
 */
public class OrderMapper {

    public static void createOrder(User user) throws LegoHouseException {
        try {
            String SQL = "INSERT INTO orders set userid = ?;";
            PreparedStatement userPstmt = Connector.connection().prepareStatement(SQL);
            userPstmt.setInt(1, user.getId());
            userPstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoHouseException(ex.getMessage());
        }
    }

    public static int getOrder(User user) throws LegoHouseException {
        Statement stm;
        try {
            stm = Connector.connection().createStatement();
            String SQL = "SELECT id FROM orders WHERE currentstatus = 'Open' AND userid = " + user.getId() + ";";
            ResultSet rs = stm.executeQuery(SQL);
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                throw new LegoHouseException("Could not find order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegoHouseException(ex.getMessage());
        }
    }

    public static void createLineItem(int orderId, int lBrick4, int lBrick2, int lBrick1, int wBrick4, int wBrick2, int wBrick1, int height) throws LegoHouseException {
        try {
            for(int i = 0; i < height; i++) {
            String SQL = "INSERT INTO lineItem VALUES\n"
                    + "(?, '2x4', ?, 'side1&3',"+i+"),\n"
                    + "(?, '2x2', ?, 'side1&3',"+i+"),\n"
                    + "(?, '2x1', ?, 'side1&3',"+i+"),\n"
                    + "(?, '2x4', ?, 'side2&4',"+i+"),\n"
                    + "(?, '2x2', ?, 'side2&4',"+i+"),\n"
                    + "(?, '2x1', ?, 'side2&4',"+i+");";
            PreparedStatement userPstmt = Connector.connection().prepareStatement(SQL);
            userPstmt.setInt(1, orderId);
            userPstmt.setInt(2, lBrick4);
            userPstmt.setInt(3, orderId);
            userPstmt.setInt(4, lBrick2);
            userPstmt.setInt(5, orderId);
            userPstmt.setInt(6, lBrick1);
            userPstmt.setInt(7, orderId);
            userPstmt.setInt(8, wBrick4);
            userPstmt.setInt(9, orderId);
            userPstmt.setInt(10, wBrick2);
            userPstmt.setInt(11, orderId);
            userPstmt.setInt(12, wBrick1);
            userPstmt.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoHouseException(ex.getMessage());
        }
    }
    
    public static List<LineItem> getLineItems(int id) throws LegoHouseException {
        Statement stm;
        List<LineItem> lineItemList = new ArrayList();
        try {
            stm = Connector.connection().createStatement();
            String SQL = "SELECT * FROM lineItem WHERE id = "+id+";";
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                lineItemList.add(new LineItem(rs.getInt("id"), rs.getString("brickType"), rs.getInt("numberOfBricks"), rs.getString("side"), rs.getInt("floorLevel")));
                
            }
            return lineItemList;
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegoHouseException(ex.getMessage());
        }
    }
    

}
