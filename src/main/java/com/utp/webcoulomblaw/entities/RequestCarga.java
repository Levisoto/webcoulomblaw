package com.utp.webcoulomblaw.entities;

/** RequestCarga */
public class RequestCarga {

  private double q1;
  private double q2;
  private double  x1;
  private double x2;
  private double y1;
  private double y2;
  private String unidad; 
  private String unidad2; 

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad2() {
        return unidad2;
    }

    public void setUnidad2(String unidad2) {
        this.unidad2 = unidad2;
    }

    
    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

  public double getQ1() {
    return q1;
  }

  public void setQ1(double q1) {
    this.q1 = q1;
  }

  public double getQ2() {
    return q2;
  }

  public void setQ2(double q2) {
    this.q2 = q2;
  }
 
  public Carga getCarga1 (){
      return new Carga(this.q1, this.unidad, this.x1, this.y1); 
  }

  public Carga getCarga2 (){
      return new Carga(this.q2, this.unidad2, this.x2, this.y2); 
  }  
  }


