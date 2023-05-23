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
        this.q3 = q3;
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

        return Math.round(F * 1000.0) / 1000.0;
    }

    public double calcularFuerzaq1q3() {
        double k, F;
        k = 9 * Math.pow(10, 9);
        F = k * q1.getQ() * q3.getQ() / Math.pow(this.calcularDistanciaTri()[1], 2);
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

        switch (q3.getUnidad()) {

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

        return Math.round(F * 1000.0) / 1000.0;
    }

    public double calcularFuerzaq2q3() {
        double k, F;
        k = 9 * Math.pow(10, 9);
        F = k * q2.getQ() * q3.getQ() / Math.pow(this.calcularDistanciaTri()[2], 2);
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

        switch (q3.getUnidad()) {

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

        return Math.round(F * 1000.0) / 1000.0;
    }

    public double[] calcularAngulos(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calcular los lados del triángulo
        double ladoA = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double ladoB = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double ladoC = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // Calcular los ángulos usando la ley de cosenos
        double anguloQ1 = Math.toDegrees(Math.acos((ladoB * ladoB + ladoC * ladoC - ladoA * ladoA) / (2 * ladoB * ladoC)));
        double anguloQ2 = Math.toDegrees(Math.acos((ladoA * ladoA + ladoC * ladoC - ladoB * ladoB) / (2 * ladoA * ladoC)));
        double anguloQ3 = Math.toDegrees(Math.acos((ladoA * ladoA + ladoB * ladoB - ladoC * ladoC) / (2 * ladoA * ladoB)));

        // Devolver los ángulos en un arreglo
        double[] angulos = {anguloQ1, anguloQ2, anguloQ3};
        return angulos;
    }

    public double FR1() {
        double F;
        F = Math.pow(this.calcularFuerzaq1q2(), 2) + Math.pow(this.calcularFuerzaq1q3(), 2);
        F += 2 * this.calcularFuerzaq1q2() * this.calcularFuerzaq1q3() * Math.cos(this.calcularAngulos(q1.getX(), q1.getY(), q2.getX(), q2.getY(), q3.getX(), q3.getY())[0]);
        F = Math.pow(F, 0.5);
        return Math.round(F*100.0)/100.0;
    }

    public double FR2() {
        double F;
        F = Math.pow(this.calcularFuerzaq1q2(), 2) + Math.pow(this.calcularFuerzaq2q3(), 2);
        F += 2 * this.calcularFuerzaq1q2() * this.calcularFuerzaq2q3() * Math.cos(this.calcularAngulos(q1.getX(), q1.getY(), q2.getX(), q2.getY(), q3.getX(), q3.getY())[2]);
        F = Math.pow(F, 0.5);
        return Math.round(F*100.0)/100.0;
    }

    public double FR3() {
        double F;
        F = Math.pow(this.calcularFuerzaq1q3(), 2) + Math.pow(this.calcularFuerzaq2q3(), 2);
        F += 2 * this.calcularFuerzaq1q3() * this.calcularFuerzaq2q3() * Math.cos(this.calcularAngulos(q1.getX(), q1.getY(), q2.getX(), q2.getY(), q3.getX(), q3.getY())[1]);
        F = Math.pow(F, 0.5);
        return Math.round(F*100.0)/100.0;
    }

    public double fuerzaAbsq1q2() {
        return Math.abs(this.calcularFuerzaq1q2());
    }

    public double fuerzaAbsq2q3() {
        return Math.abs(this.calcularFuerzaq2q3());
    }

    public double fuerzaAbsq1q3() {
        return Math.abs(this.calcularFuerzaq1q3());
    }

    public String mostrarDesarrolloTri() {
        return "PRIMER PASO: Identificamos nuestros datos: \n" + "q1 = " + q1.getQ()
                + q1.getUnidad() + ", q2 = " + q2.getQ() + q2.getUnidad()
                +" y q3"+ "= " + q3.getQ() + q3.getUnidad() + " \n"
                + "la distancia entre q1 y q2 es d12 = " + this.calcularDistanciaTri()[0] + " m \n"
                + "la distancia entre q1 y q3 es d13 = " + this.calcularDistanciaTri()[2] + " m \n"
                + "la distancia entre q2 y q3 es d23 = " + this.calcularDistanciaTri()[1] + " m \n\n"
               
                + "SEGUNDO PASO: Utilizamos nuestra fórmula de la Ley de Coulomb: \n"
                + "F = k * (q1 * q2) / (d * d) \n"
                + "Donde: \n"
                + "F es la fuerza eléctrica \n"
                + "k es la constante de Coulomb \n"
                + "q1 y q2 son las cargas \n"
                + "d es la distancia entre las cargas \n"
                +"\n"
                + "TERCER PASO: Sustituyendo los valores: \n"
                +"Recordar que en la sustitución de los valores, se toma solo los valores positivos de las cargas \n"
                +"Para Q1 y Q2"
                 +"\n"
                + "F = " + "9 * " + "10⁹" + "*" + Math.abs(q1.getQ())
                + q1.getUnidad() + "*" + Math.abs(q2.getQ()) + q2.getUnidad() + "/" + "(" 
                + this.calcularDistancia() + " *" + this.calcularDistanciaTri()[0] + ")" + " \n"
                +"\n"
                + "Operando, tendremos que la fuerza eléctrica entre la carga q1 =" + q1.getQ()
                + q1.getUnidad() + " y la carga q2 = " + q2.getQ() + q2.getUnidad() + " es: "
                + this.fuerzaAbsq1q2() + " N"
                 +"\n"
                +"Para Q2 y Q3"
                 +"\n"
                + "F = " + "9 * " + "10⁹" + "*" + Math.abs(q2.getQ())
                + q2.getUnidad() + "*" + Math.abs(q3.getQ()) + q3.getUnidad() + "/" + "(" 
                + this.calcularDistanciaTri()[2] + " *" + this.calcularDistanciaTri()[2] + ")" + " \n"
                +"\n"
                
                + "Operando, tendremos que la fuerza eléctrica entre la carga q2 =" + q2.getQ()
                + q2.getUnidad() + " y la carga q3 = " + q3.getQ() + q3.getUnidad() + " es: "
                + this.fuerzaAbsq2q3() + " N"
                 +"\n"
                +"Para Q1 y Q3"
                 +"\n"
                + "F = " + "9 * " + "10⁹" + "*" + Math.abs(q1.getQ())
                + q1.getUnidad() + "*" + Math.abs(q3.getQ()) + q3.getUnidad() + "/" + "(" 
                + this.calcularDistanciaTri()[1] + " *" + this.calcularDistanciaTri()[1] + ")" + " \n"
                +"\n"
                
                + "Operando, tendremos que la fuerza eléctrica entre la carga q1 =" + q1.getQ()
                + q1.getUnidad() + " y la carga q3 = " + q3.getQ() + q3.getUnidad() + " es: "
                + this.fuerzaAbsq1q3() + " N"
                 +"\n"
                + "La fuerza resultante en la carga q1 será: "+this.FR1() +"N"+ "\n\n"
                +"La fuerza resultante en la carga q2 será: " +this.FR2() + "N"+"\n\n"
                + "La fuerza resultante en la carga q3 será: "+this.FR3()+"N"+"\n\n";
    }

}
