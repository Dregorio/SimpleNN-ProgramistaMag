public class SimpleNN {
    public static void main(String[] args) {
        ControlPrinter cp = new ControlPrinter();

        ReferenceFrame rf1 = new ReferenceFrame("Referencja");
        rf1.addBarrier(new SimpleLine(1, 0, "linia do góry"));

        ReferenceFrame rf2 = new ReferenceFrame("Inna referencja");
        rf2.addBarrier(new SimpleLine(-0.5, 0.5, "linia lekko do dołu"));

        Perceptron p1 = new Perceptron();
        Perceptron p2 = new Perceptron();

        cp.addAnswerer(rf1);
        cp.addAnswerer(p1);
        cp.addAnswerer(rf2);
        cp.addAnswerer(p2);
        cp.printResults();

        for(int i = 0; i < 5000; ++i){
            double[] d = new double[2];
            d[0] = rf1.getCoord();
            d[1] = rf1.getCoord();
            double a1 = rf1.answer(d), a2 = rf2.answer(d);
            p1.train(d, a1, 0.01);
            p2.train(d, a2, 0.01);
        }
        cp.printResults();
    }
}