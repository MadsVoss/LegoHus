/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LegoHouseException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mads Voss
 */
public class OrderMapper {
    public static void createOrder(User user) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders set userid = ?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1, user.getId() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LegoHouseException( ex.getMessage() );
        }
    }
    
    public static int getOrder(User user) throws LegoHouseException {
        Statement stm;
        try {
            stm = Connector.connection().createStatement();
            String SQL = "SELECT id FROM orders WHERE currentstatus = 'Open' AND userid = " + user.getId()+ ";";
            ResultSet rs = stm.executeQuery(SQL);
            if ( rs.next() ) {
                return rs.getInt("id");
            } else {
                throw new LegoHouseException( "Could not find order" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoHouseException(ex.getMessage());
        }
    } 
    
    public static void createLineItem(User user) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders set userid = ?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1, user.getId() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LegoHouseException( ex.getMessage() );
        }
    }
    
}
