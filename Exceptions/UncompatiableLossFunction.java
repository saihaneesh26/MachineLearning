import java.util.List;

import SLUtils.enums.LossFunction;

public class UncompatiableLossFunction extends RuntimeException {
    public UncompatiableLossFunction(LossFunction providedLossFunction, List<LossFunction> acceptableLossFunctions) {
        System.out.println(String.format("%s loss function is not acceptable for this model. Acceptable loss functions are : %s", providedLossFunction, acceptableLossFunctions));
    }
    public UncompatiableLossFunction() {}
}
