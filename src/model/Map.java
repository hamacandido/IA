/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author murilo
 */
public class Map extends JPanel{
    private static final int Y = 500, X = 500;
    private Tile[][] tiles;
    private int sizeX;
    private int sizeY;
    private int sizeXTile;
    private int sizeYTile;
    private boolean debug = false;

    public Map(Tile[][] Tiles, int sizeX, int sizeY) {
        this.tiles = Tiles;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeXTile = this.X / sizeX;
        this.sizeYTile = this.Y / sizeY;
    }

    public Map(int size) {
        this.sizeX = size;
        this.sizeY = size;
        this.tiles = new Tile[sizeX][sizeY];
        this.sizeXTile = this.X / sizeX;
        this.sizeYTile = this.Y / sizeY;
        this.GenerateTiles();
    }

    public Map() {
        this.sizeX = 1;
        this.sizeY = 1;
        this.tiles = new Tile[sizeX][sizeY];
        this.sizeXTile = this.X / sizeX;
        this.sizeYTile = this.Y / sizeY;
        this.GenerateTiles();
    }
    
    public void GenerateTiles(){
        int id = 0;
        Tile aux;
        Color green = new Color(0,128,0);
        Color red = new Color(178,34,34);
        Color blue = new Color(65,105,225);
        Color brown = new Color(92,51,23);
        for(int i=0; i<sizeX; i++){
            for(int j=0; j<sizeY; j++){
                aux = new Tile(i, j, id, green, 1, false);
                tiles[i][j] = aux;
                id++;
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i=0; i < this.sizeX*this.sizeXTile; i += sizeXTile){
            for(int j=0; j < this.sizeX*this.sizeXTile; j += sizeYTile){
                g.setColor(tiles[i/sizeXTile][j/sizeYTile].getColor());
                g.fillRect(i, j, sizeXTile, sizeYTile);
                
                if(debug){
                    g.setColor(Color.black);
                    g.drawString(Integer.toString(tiles[i/sizeXTile][j/sizeYTile].getCost()),i+sizeXTile/2,j+sizeXTile/2);

                    g.setColor(Color.black);
                    g.drawString(Integer.toString(tiles[i/sizeXTile][j/sizeYTile].getHeuristicCost()),i+sizeXTile-10, j+10);

                    g.setColor(Color.black);
                    g.drawString(Integer.toString(tiles[i/sizeXTile][j/sizeYTile].getGlobalCost()),i+10,j+10);

                    g.setColor(Color.black);
                    g.drawString(Integer.toString(tiles[i/sizeXTile][j/sizeYTile].getTotalCost()),i+sizeXTile-10,j+sizeXTile-10);

                    g.setColor(Color.black);
                    g.drawString(Integer.toString(tiles[i/sizeXTile][j/sizeYTile].getId()),i+10,j+sizeXTile-10);
                }
            }
        }
        for(int i=0; i<this.sizeX*this.sizeXTile; i += sizeXTile){
            g.setColor(Color.black);
            g.drawLine(0, i, this.sizeX*this.sizeXTile, i);
            g.drawLine(i, 0, i, this.sizeX*this.sizeXTile);
        }
        //notifyAll();
    }
    
    public ArrayList<Tile> getNeighbor(Tile tile){
        ArrayList<Tile> neighbors = new ArrayList<>();
        //Norte
        if(tile.getY() > 0){
            neighbors.add(tiles[tile.getX()][tile.getY()-1]);
            
        }
        //Leste
        if(tile.getX() < this.getSizeX()-1){
            neighbors.add(tiles[tile.getX()+1][tile.getY()]);
        }
        //Sul
        if(tile.getY() < this.getSizeX()-1){
            neighbors.add(tiles[tile.getX()][tile.getY()+1]);
        }
        //Oeste
        if(tile.getX() > 0){
            neighbors.add(tiles[tile.getX()-1][tile.getY()]);
        }
        
        return neighbors;
    }

    public int getSizeXTile() {
        return sizeXTile;
    }

    public void setSizeXTile(int sizeXTile) {
        this.sizeXTile = sizeXTile;
    }

    public int getSizeYTile() {
        return sizeYTile;
    }

    public void setSizeYTile(int sizeYTile) {
        this.sizeYTile = sizeYTile;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
        this.sizeY = sizeX;
        this.tiles = new Tile[sizeX][sizeY];
        this.sizeXTile = this.X / sizeX;
        this.sizeYTile = this.Y / sizeY;
        //System.out.println("sizeXTile: "+ this.sizeXTile);
        this.GenerateTiles();
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void EnableDebug(){
        this.debug = true;
    }
    public void DisableDebug(){
        this.debug = false;
    }
    
    
    
}
