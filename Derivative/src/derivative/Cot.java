
package derivative;

import static derivative.MultiplyDivide.multiply;

/**
 *
 * @author leijurv
 */
public class Cot extends Function{
Function of;
static boolean simplifyToCosSin=false;
public Cot(Function Of){
    of=Of;
}
    @Override
    public Function derivitive() {
        return new Subtract(new Constant(0),multiply(new ToThePower(new Csc(of),new Constant(2)),of.derivitive()));
    }

    @Override
    public String toString() {
        return "Cot["+of+"]";
    }

    @Override
    public Function simplify() {
        if (simplifyToCosSin){
            return new MultiplyDivide(new Function[]{new Cos(of)},new Function[]{new Sin(of)}).simplify();
        }
        return new Cot(of.simplify());
    }

    @Override
    public boolean equal(Function f) {
        if (f instanceof Cot){
            Cot c=(Cot)f;
            if (c.of.equals(of)){
                return true;
            }
        }
        return false;
    }

    @Override
    public double eval(double d) {
        return 1/Math.tan(of.eval(d));
    }
    public Function clone(){
        return new Cot(of.clone());
    }
}


