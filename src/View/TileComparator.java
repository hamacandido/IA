/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Comparator;
import model.Tile;

/**
 *
 * @author murilo
 */
public class TileComparator implements Comparator<Tile>{

    @Override
    public int compare(Tile o1, Tile o2) {
        return (o1.getGlobalCost() - o2.getGlobalCost());
    }
    
}
