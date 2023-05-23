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
        return Math.round(d*100.0)/100.0;

    }

    public double calcularFuerza() {
        double k, F;
        k = 9 * Math.pow(10, 9);
        F = k * q1.getQ() * q2.getQ() / Math.pow(this.calcularDistancia(), 2);
        switch (q1.getUnidad()) {

            case "mC":
                F *= Math.pow(10, -3);
                break;
            case "uC":
                F *= Math.pow(10, -6);
                break;
            case "nC":
                F *= Math.pow(10, -9);
                break;
            default: ;
                break;
        }

        switch (q2.getUnidad()) {

            case "mC":
                F *= Math.pow(10, -3);
                break;
            case "uC":
                F *= Math.pow(10, -6);
                break;
            case "nC":
                F *= Math.pow(10, -9);
                break;
            default: ;
                break;
        }

        return Math.round(F * 100.0) / 100.0;
    }

    public String tipoFuerza(){
        if (this.calcularFuerza()<0){
            return "Debido a que las cargas presenten signos opuestos, la fuerza eléctrica será de atracción";
        }else{
            return "Debido a que las cargas presentan signos iguales, la fuerza eléctrica será de repulsión";
        }
    }
    public double fuerzaAbs(){
        return Math.abs(this.calcularFuerza());
    }
    public String mostrarDesarrollo() {
        return "PRIMER PASO: Identificamos nuestros datos: \n" + "q1 = " + q1.getQ()
                + q1.getUnidad() + " y q2 = " + q2.getQ() + q2.getUnidad() + " \n"
                + "d = " + this.calcularDistancia() + " m \n"
                +"\n"
                +"SEGUNDO PASO: Analizamos el tipo de fuerza eléctrica: \n"
                +this.tipoFuerza()+"\n\n"
                + "TERCER PASO: Utilizamos nuestra fórmula de la Ley de Coulomb: \n"
                + "F = k * (q1 * q2) / (d * d) \n"
                + "Donde: \n"
                + "F es la fuerza eléctrica \n"
                + "k es la constante de Coulomb \n"
                + "q1 y q2 son las cargas \n"
                + "d es la distancia entre las cargas \n"
                +"\n"
                + "CUARTO PASO: Sustituyendo los valores: \n"
                +"Recordar que en la sustitución de los valores, se toma solo los valores positivos de las cargas \n"
                + "F = " + "9 * " + "10⁹" + "*" + Math.abs(q1.getQ())
                + q1.getUnidad() + "*" + Math.abs(q2.getQ()) + q2.getUnidad() + "/" + "(" 
                + this.calcularDistancia() + " *" + this.calcularDistancia() + ")" + " \n"
                +"\n"
                + "Operando, tendremos que la fuerza eléctrica entre la carga q1 =" + q1.getQ()
                + q1.getUnidad() + " y la carga q2 = " + q2.getQ() + q2.getUnidad() + " es: "
                + this.fuerzaAbs() + " N";
    }
}
