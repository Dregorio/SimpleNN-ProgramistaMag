import java.util.ArrayList;


public class ControlPrinter {
    private final ArrayList<IAnswerer> answerers = new ArrayList<>();

    public void addAnswerer(IAnswerer ans){
        answerers.add(ans);
    }

    public void printResults(){
        printDivisionLine();
        printPaddedNames();
        printAnswerFields();
    }

    private void printDivisionLine(){
        for(IAnswerer a : answerers){
            System.out.print(String.format("%-46s", "=").replace(' ', '='));
        }
        System.out.println("");
    }

    private void printAnswerFields(){
        for (double y = 1.0; y > -1.1; y -= 0.1){
            for (IAnswerer ans : answerers){
                for (double x = -1.0; x < 1.0; x +=0.1){
                    printSingleAnswer(ans, x, y);
                }
                System.out.println("     ");
            }
            System.out.printf("");
        }
    }

    private void printSingleAnswer(IAnswerer ans, double x, double y){
        double[] d = new double[2];
        d[0] = x;
        d[1] = y;
        if (ans.answer(d) > 0){
            System.out.printf("\033[31m1\033[39m ");
        }else {
            System.out.printf("\033[32m0\033[39m ");
        }
    }

    private void printPaddedNames(){
        for(IAnswerer ans : answerers){
            System.out.printf(String.format("%-46s", ans.getName()));
        }
        System.out.printf("");
    }
}
