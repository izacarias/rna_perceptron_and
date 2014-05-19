package perceptron_and;

import java.util.ArrayList;

/**
 *
 * @author Iulisloi Zacarias
 * http://www.generation5.org/content/2004/simple_ocr.asp
 * http://www.generation5.org/content/1999/perceptron.asp
 * http://en.literateprograms.org/Perceptron_%28Java%29
 * http://www.cms.waikato.ac.nz/~abifet/MOA/API/_perceptron_8java_source.html
 */
public class Perceptron_AND {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SampleSet setAnd = new SampleSet();
        SampleSet setXor = new SampleSet();
        Net net = new Net();
        Net netXor = new Net();
        
        /* Amostras para porta AND */
        setAnd.addSample(0, 0, -1);
        setAnd.addSample(0, 1, -1);
        setAnd.addSample(1, 0, -1);
        setAnd.addSample(1, 1,  1);
        
        net.train(setAnd);
        
        net.test(0, 0);
        net.test(0, 1);
        net.test(1, 0);
        net.test(1, 1);
        
        setXor.addSample(0, 0, -1);
        setXor.addSample(0, 1,  1);
        setXor.addSample(1, 0,  1);
        setXor.addSample(1, 1, -1);
        
        net.train(setXor);
        
        net.test(0, 0);
        net.test(0, 1);
        net.test(1, 0);
        net.test(1, 1);

    }

}
