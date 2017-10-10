/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Mads Voss
 */
public class LegoHouseFactory {
    
    public static void buildLegoHouse(int length, int width, int height) {
        //
        int lbrick4 = length / 4;
        int lbrick2 = (length % 4) / 2;
        int lbrick1 = (length % 2);
        width = width - 4; 
        int wbrick4 = width / 4;
        int wbrick2 = (width % 4) / 2;
        int wbrick1 = (width % 2);
        
        
    }
    
    public static void main(String[] args) {
        LegoHouseFactory.buildLegoHouse(13, 12, 6);
    }
}
