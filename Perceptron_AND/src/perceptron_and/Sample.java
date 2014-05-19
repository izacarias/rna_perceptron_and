/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perceptron_and;

/**
 * Classe com amostras para o treinamento
 * @author iulisloi
 */
public class Sample {
    
    private double x1;
    private double x2;
    private double desiredOutput;

    public Sample(double x1, double x2, double desiredOutput) {
        this.x1 = x1;
        this.x2 = x2;
        this.desiredOutput = desiredOutput;
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

    public double getDesiredOutput() {
        return desiredOutput;
    }

    public void setDesiredOutput(double desiredOutput) {
        this.desiredOutput = desiredOutput;
    }
}
