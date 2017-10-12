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
public class LineItem {
    private int id;
    private String brickType;
    private int numberOfBricks;
    private String side;
    private int floorLevel;

    public LineItem(int id, String brickType, int numberOfBricks, String side, int floorLevel) {
        this.id = id;
        this.brickType = brickType;
        this.numberOfBricks = numberOfBricks;
        this.side = side;
        this.floorLevel = floorLevel;
    }

    public int getId() {
        return id;
    }

    public String getBrickType() {
        return brickType;
    }

    public int getNumberOfBricks() {
        return numberOfBricks;
    }

    public String getSide() {
        return side;
    }

    public int getFloorLevel() {
        return floorLevel;
    }

    @Override
    public String toString() {
        return "LineItem{" + "id=" + id + ", brickType=" + brickType + ", numberOfBricks=" + numberOfBricks + ", side=" + side + ", floorLevel=" + floorLevel + '}';
    }
    
    
    
}
