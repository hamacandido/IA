/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import static java.lang.Math.abs;
import java.util.Comparator;

/**
 *
 * @author murilo
 */
public class Tile implements Comparable<Tile>{
    private int x;
    private int y;
    private int id;
    private Color color;
    private int cost;
    private boolean visited;
    private Tile pai;
    
    //A* ---------------------
    private int heuristicCost;
    private int globalCost;
    private int fCost; // heuristic + global
    //------------------------

    public Tile(int x, int y, int id, Color color, int cost, boolean visited) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.color = color;
        this.cost = cost;
        this.visited = visited;
        this.pai = null;
        this.heuristicCost = 0;
        this.globalCost = 0;
    }

    public Tile() {
        this.x =0;
        this.y=0;
        this.id = 0;
        this.color = new Color(0,255,0);
        this.cost = 1;
        this.visited = false;
        this.pai = null;
        this.heuristicCost = 0;
        this.globalCost = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
    public Tile getPai() {
        return pai;
    }

    public void setPai(Tile pai) {
        this.pai = pai;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public void setHeuristicCost(int cost){
        this.heuristicCost = cost;
        this.fCost = globalCost + heuristicCost;
    }
    
    public void setHeuristicCost(Tile destino){
        this.heuristicCost = abs((destino.x - this.x)) + abs((destino.y - this.y));
        this.fCost = globalCost + heuristicCost;
    }
    
    public void setGlobalCost(int cost){
        this.globalCost = cost;
        this.fCost = globalCost + heuristicCost;
    }
    
    public int getGlobalCost(){
        return this.globalCost;
    }
    
    public int getHeuristicCost(){
        return this.heuristicCost;
    }
    
    public int getTotalCost(){
        return fCost;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.x;
        hash = 37 * hash + this.y;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tile other = (Tile) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tile{id:"+ id+" G:"+globalCost+ " F: "+ fCost+"}";
    }

    @Override
    public int compareTo(Tile o) {
        return this.fCost - o.fCost;
    }

    
    
}
