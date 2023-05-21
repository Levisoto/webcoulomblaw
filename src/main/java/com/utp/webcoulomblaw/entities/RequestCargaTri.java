package com.utp.webcoulomblaw.entities;

/** RequestCarga */
public class RequestCargaTri extends RequestCarga{

  private double q3;
  private String unidad3;
  private double  x3;
  private double y3;
   
  
      public String getUnidad3() {
        return unidad3;
    }

    public void setUnidad3(String unidad3) {
        this.unidad3 = unidad3;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    

  public double getQ3() {
    return q3;
  }

  public void setQ3(double q3) {
    this.q3 = q3;
  }

  
 
  public Carga getCarga3 (){
      return new Carga(this.q3, this.unidad3,this.x3, this.y3); 
  }


  }


