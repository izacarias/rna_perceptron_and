package perceptron_and;

import java.util.ArrayList;

/**
 *
 * @author Iulisloi Zacarias
 */
public class Net {

    private double bias;
    private double alpha;
    private ArrayList<Neuron> neurons;
    private boolean weightChange;

    private static final int MAX_EPOCHS = 200;
    private static final double ACT_LIMIAR = 0.2;

    public Net() {
        this.bias = 0;  // set BIAS to "0"
        this.alpha = 1; // set Alpha or Learning Rate to "1"
        this.neurons = new ArrayList<Neuron>();

        // Um neoronio para cada entrada
        // inicializa cada neuronio com valor e peso "0";
        Neuron n1 = new Neuron(0, 0);
        Neuron n2 = new Neuron(0, 0);
        this.neurons.add(n1);
        this.neurons.add(n2);
    }

    public boolean train(SampleSet sampleSet) {

        int epoch = 0;
        double y_in = 0;
        int y = 0;

        do {
            // indica se houve alteração de pesos
            this.weightChange = false;

            for (Sample s : sampleSet.getSampleSet()) {
                this.neurons.get(0).setValue(s.getX1());
                this.neurons.get(1).setValue(s.getX2());
                int t = (int) s.getDesiredOutput();
                y_in = bias + this.sumOfNeurons();
                y = this.activatcionFunc(y_in);
                if (y != t) {
                    this.neurons.get(0).setWeight(
                            this.neurons.get(0).getWeight() + (alpha * t * s.getX1())
                    );

                    this.neurons.get(1).setWeight(
                            this.neurons.get(1).getWeight() + (alpha * t * s.getX2())
                    );

                    this.bias = this.bias + (alpha * t);
                    this.weightChange = true; // houve alteração de pesos;
                }
            }
            epoch++;
        } while (weightChange && (epoch < MAX_EPOCHS));

        return false;
    }

    public int test(double x1, double x2) {
        int result = 0;
        this.neurons.get(0).setValue(x1);
        this.neurons.get(1).setValue(x2);
        double y_in = bias + this.sumOfNeurons();
        result = this.activatcionFunc(y_in);
        this.imprimeTeste(x1, x2, result);
        return result;
    }

    private double sumOfNeurons() {
        double sum = 0;
        for (Neuron neuron : this.neurons) {
            sum = sum + neuron.getValue() * neuron.getWeight();
        }
        return sum;
    }

    private int activatcionFunc(double value) {
        if (value > ACT_LIMIAR) {
            return 1;
        } else if ((value >= (ACT_LIMIAR * -1)) && (value <= ACT_LIMIAR)) {
            return 0;
        } else if (value < (ACT_LIMIAR * -1)) {
            return -1;
        }
        return 0;
    }
    
    private void imprimeTeste(double x1, double x2, int resultado){
        System.out.printf("%2.0f",x1);
        System.out.print(" | ");
        System.out.printf("%2.0f",x2);
        System.out.print(" | ");
        System.out.printf("%2d",resultado);
        System.out.println();
    }

}
