package com.utp.webcoulomblaw.entities;

/** RequestCarga */
public class RequestCargaCuatro extends RequestCargaTri{

  private double q4;
  private String unidad4;
  private double  x4;
  private double y4;

    public String getUnidad4() {
        return unidad4;
    }

    public void setUnidad4(String unidad4) {
        this.unidad4 = unidad4;
    }
   

    public double getX4() {
        return x4;
    }

    public void setX4(double x4) {
        this.x4 = x4;
    }

    

    public double getY4() {
        return y4;
    }

    public void setY4(double y4) {
        this.y4 = y4;
    }

    

  public double getQ4() {
    return q4;
  }

  public void setQ4(double q4) {
    this.q4 = q4;
  }

  
 
  public Carga getCarga4 (){
      return new Carga(this.q4, this.unidad4,this.x4, this.y4); 
  }


  }


