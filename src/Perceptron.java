import java.util.Random;

/**
 * Created by Damis on 11-Apr-17.
 */
public class Perceptron implements IAnswerer{
    private static final Random R = new Random();
    private static int cnt = 0;
    private final String name;
    private double[] weights;

    public Perceptron(){
        name = "Perceptron " + cnt++;
        weights = new double[3];
        generateWeigthValues();
    }

    public Perceptron(int size){
        name = "Perceptron " + cnt++;
        weights = new double[size + 1];
        generateWeigthValues();
    }

    private void generateWeigthValues(){
        for (int i = 0; i < weights.length; ++i){
            weights[i] = R.nextDouble() * 2 - 1;
        }
    }

    public void train(double[] x, double expectedAnswer, double learnRate){
        double adjustedError = (expectedAnswer - answer(x)) * learnRate;
        for (int i = 0; i < weights.length - 1; ++i){
            weights[i] += adjustedError * x[i];
        }
        weights[weights.length - 1] += adjustedError;
    }

    @Override
    public double answer(double[] x){
        double sum = 0;
        for (int i = 0; i < weights.length - 1; ++i){
            sum += x[i] * weights[i];
        }
        sum += weights[weights.length - 1];
        return activate(sum);
    }

    @Override
    public String getName(){
        return name;
    }

    private double activate(double sum){
        return (sum > 0) ? 1 : -1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(name + ": ");
        for (double d : weights){
            sb.append(d).append(" ");
        }
        return sb.toString();
    }
    public double compute(double[] x){
        double sum = 0.0;
        for(int i =0; i < x.length; ++i){
            sum += x[i] * weights[i];
        }
        sum += weights[x.length + 1];
        return (sum >0) ? 1 : -1;
    }
}
