/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bluecode.businessObjects;

/**
 *
 * @author Laser Marker
 */
public class Zone {
    
    private int id;
    private int area;
    private String name;
    private double xesi;
    private double yesi;
    private double xeid;
    private double yeid;

    public Zone() {
    }

    public Zone(int id) {
        this.id = id;
    }

    public Zone(int id, int area, String name, double xesi, double yesi, double xeid, double yeid) {
        this.id = id;
        this.area = area;
        this.name = name;
        this.xesi = xesi;
        this.yesi = yesi;
        this.xeid = xeid;
        this.yeid = yeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getXesi() {
        return xesi;
    }

    public void setXesi(double xesi) {
        this.xesi = xesi;
    }

    public double getYesi() {
        return yesi;
    }

    public void setYesi(double yesi) {
        this.yesi = yesi;
    }

    public double getXeid() {
        return xeid;
    }

    public void setXeid(double xeid) {
        this.xeid = xeid;
    }

    public double getYeid() {
        return yeid;
    }

    public void setYeid(double yeid) {
        this.yeid = yeid;
    }

    @Override
    public String toString() {
        return "Zone{" + "id=" + id + ", area=" + area + ", name=" + name + ", xesi=" + xesi + ", yesi=" + yesi + ", xeid=" + xeid + ", yeid=" + yeid + '}';
    }
    
    
    
}
