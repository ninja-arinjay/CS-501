// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "PlanetInfo.txt" and computes different result
//						based on the user's input.
package com.example.planetinfo;

public class PlanetEntry {
    private String name;
    private double radius;
    private double wRatio;
    private double distance;

    public PlanetEntry(String n, double r, double wr, double d){
        name = n;
        radius = r;
        wRatio = wr;
        distance = d;
    }

    //Accessors
    public String getName(){
        return  name;
    }
    public double getRadius(){
        return radius;
    }
    public double getwRatio(){
        return wRatio;
    }
    public double getDistance(){
        return distance;
    }
}
