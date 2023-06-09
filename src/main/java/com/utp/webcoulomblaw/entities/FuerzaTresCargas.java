/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.webcoulomblaw.entities;

/**
 *
 * @author kalu
 */
public class FuerzaTresCargas extends FuerzaDosCargas {

 
    private Carga q3;

    public FuerzaTresCargas(Carga q1, Carga q2, Carga q3) {
        super(q1, q2);
        this.q3=q3;
    }
    
public double[] calcularDistanciaTri() {
    double distanciaQ1Q2 = Math.pow((q2.getX() - q1.getX()), 2) + Math.pow((q2.getY() - q1.getY()), 2);
    distanciaQ1Q2 = Math.pow(distanciaQ1Q2, 0.5);
    
    double distanciaQ1Q3 = Math.pow((q3.getX() - q1.getX()), 2) + Math.pow((q3.getY() - q1.getY()), 2);
    distanciaQ1Q3 = Math.pow(distanciaQ1Q3, 0.5);
    
    double distanciaQ2Q3 = Math.pow((q3.getX() - q2.getX()), 2) + Math.pow((q3.getY() - q2.getY()), 2);
    distanciaQ2Q3 = Math.pow(distanciaQ2Q3, 0.5);
    
   
    
    double[] distancias = {distanciaQ1Q2, distanciaQ1Q3, distanciaQ2Q3};
    
    return distancias;
}

public double[] calcularFuerzaTri() {
    double k = 9 * Math.pow(10, 9);
    
    double[] fuerzas = new double[3];
    
    fuerzas[0] = k * q1.getQ() * q2.getQ() / Math.pow(this.calcularDistanciaTri()[0], 2);
    
   
    fuerzas[1] = k * q1.getQ() * q3.getQ() / Math.pow(this.calcularDistanciaTri()[1], 2);
        

    fuerzas[2] = k * q2.getQ() * q3.getQ() / Math.pow(this.calcularDistanciaTri()[2], 2);
    
    
    
    return fuerzas;
}

public double calcularFuerzaq1q2() {
        double k, F;
        k = 9 * Math.pow(10, 9);
        F = k * q1.getQ() * q2.getQ() / Math.pow(this.calcularDistanciaTri()[0], 2);
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
        

        
        return Math.round(F*1000000.0)/1000000.0;
    }

public double calcularFuerzaq1q3() {
        double k, F;
        k = 9 * Math.pow(10, 9);
        F = k * q1.getQ() * q3.getQ() / Math.pow(this.calcularDistanciaTri()[1], 2);
        switch (q1.getUnidad()){
          
            case "mC": F *=Math.pow(10,-3);break;
            case "uC": F *=Math.pow(10,-6);break;   
            case "nC": F *=Math.pow(10,-9);break;
            default: ;break;
        }
        
        switch (q3.getUnidad()){
            
            case "mC": F *=Math.pow(10,-3);break;
            case "uC": F *=Math.pow(10,-6);break;   
            case "nC": F *=Math.pow(10,-9);break;
            default: ;break;
        }
        
        return Math.round(F*1000000.0)/1000000.0;
    }

public double calcularFuerzaq2q3() {
        double k, F;
        k = 9 * Math.pow(10, 9);
        F = k * q2.getQ() * q3.getQ() / Math.pow(this.calcularDistanciaTri()[2], 2);
        switch (q2.getUnidad()){
          
            case "mC": F *=Math.pow(10,-3);break;
            case "uC": F *=Math.pow(10,-6);break;   
            case "nC": F *=Math.pow(10,-9);break;
            default: ;break;
        }
        
        switch (q3.getUnidad()){
            
            case "mC": F *=Math.pow(10,-3);break;
            case "uC": F *=Math.pow(10,-6);break;   
            case "nC": F *=Math.pow(10,-9);break;
            default: ;break;
        }
        
        return Math.round(F*1000000.0)/1000000.0;
    }

public String mostrarDesarrolloTri(){
        return "La fuerza eléctrica entre la carga q1 ="+q1.getQ()
                +q1.getUnidad()+" y la carga q2 = "+q2.getQ()+q2.getUnidad()+" es: "
                +this.calcularFuerzaq1q2()+" N \n"+
                "La fuerza eléctrica entre la carga q1 ="+q1.getQ()
                +q1.getUnidad()+" y la carga q3 = "+q3.getQ()+q3.getUnidad()+" es: "
                +this.calcularFuerzaq1q3()+" N \n"+
                "La fuerza eléctrica entre la carga q2 ="+q2.getQ()
                +q2.getUnidad()+" y la carga q3 = "+q3.getQ()+q3.getUnidad()+" es: "
                +this.calcularFuerzaq2q3()+" N \n";
    }

}
