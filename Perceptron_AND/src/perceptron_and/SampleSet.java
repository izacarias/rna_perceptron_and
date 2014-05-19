/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron_and;

import java.util.ArrayList;

/**
 *
 * @author Iulisloi Zacarias
 */
public class SampleSet {

    private ArrayList<Sample> sampleSet;

    public SampleSet() {
        this.sampleSet = new ArrayList<Sample>();
    }

    public void addSample(double x1, double x2, double desiredOutput) {
        Sample s = new Sample(x1, x2, desiredOutput);
        this.sampleSet.add(s);
    }

    public ArrayList<Sample> getSampleSet() {
        return sampleSet;
    }

    public void setSampleSet(ArrayList<Sample> sampleSet) {
        this.sampleSet = sampleSet;
    }

}
