import java.util.List;

import SLUtils.enums.LossFunction;

public class SupervisedLearningModel<T> implements supervisedLearning<T> {
    protected List<T> featureList;
    protected List<T> targetList;
    protected LossFunction lossFunction;
    protected List<LossFunction> acceptableLossFunctions;

    public void setLossFunction(LossFunction lossFunction) {
        this.lossFunction = lossFunction;
    }

    public void setFeatureList(List<T> featureList) {
        this.featureList = featureList;
    }

    public void setTargetList(List<T> targetList) {
        this.targetList = targetList;
    }

    public void setAcceptableLossFunction(List<LossFunction> acceptableLossFunctions) {
        this.acceptableLossFunctions = acceptableLossFunctions;
    }
    
    protected void validateLossFunction() {
        if(!acceptableLossFunctions.contains(lossFunction)) {
            throw new UncompatiableLossFunction(lossFunction,acceptableLossFunctions);
        }
    }

    @Override
    public void predict(T input) {
        throw new UnsupportedOperationException("child class requirement");
    }
}
