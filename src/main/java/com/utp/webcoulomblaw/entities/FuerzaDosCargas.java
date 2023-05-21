/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.webcoulomblaw.entities;

/**
 *
 * @author kalu
 */
public class FuerzaDosCargas {

    Carga q1;
    Carga q2;

    public FuerzaDosCargas(Carga q1, Carga q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    public double calcularDistancia() {
        double d;
        d = Math.pow((q2.getX() - q1.getX()), 2) + Math.pow((q2.getY() - q1.getY()), 2);
        d = Math.pow(d, 0.5);
        return d;

    }

    public double calcularFuerza() {
        double k, F;
        k = 9 * Math.pow(10, 9);
        F = k * q1.getQ() * q2.getQ() / Math.pow(this.calcularDistancia(), 2);
        switch (q1.getUnidad()){
          
            case "mC": F *=Math.pow(10,-3);break;
            case "uC": F *=Math.pow(10,-6);break;   
            case "nC": F *=Math.pow(10,-9);break;
            default: ;break;
        }
        
        switch (q2.getUnidad()){
            
            case "mC": F *=Math.pow(10,-3);break;
            case "uC": F *=Math.pow(10,-6);break;   
            case "nC": F *=Math.pow(10,-9);break;
            default: ;break;
        }
        
        return F;
    }
}
