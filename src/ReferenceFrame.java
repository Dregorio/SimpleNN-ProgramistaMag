import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Damis on 11-Apr-17.
 */
public class ReferenceFrame implements IAnswerer{
    private static final Random R = new Random();
    private final ArrayList<IAnswerer> answerers = new ArrayList<>();
    private String name;

    public void addBarrier(IAnswerer ans){
        answerers.add(ans);
    }

    public ReferenceFrame(String name){
        this.name = name;
    }

    public double getCoord(){
        return R.nextDouble() * 2 - 1;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double answer(double[] x){
        boolean result  = false;
        for (IAnswerer ans : answerers){
            if (ans.answer(x) > 0){
                return 1;
            }
        }
        return -1;
    }
}
