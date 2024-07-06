import java.util.ArrayList;
import java.util.List;

import SLUtils.enums.LossFunction;

public class LinearRegression<T> extends SupervisedLearningModel<T> {

    private double learningRate;
    private double intercept;
    private double slope;
    
    // user builder
    public LinearRegression() {
        this.learningRate = 0.1;
        this.intercept = 100;
        this.slope = 10;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public void setInitialIntercept(double intercept) {
        this.intercept = intercept;
    }

    public void setInitialSlope(double slope) {
        this.slope = slope;
    }

    //builder
    public void build(int epochs) {
        trainUsingGradientDescent(epochs);
    }

    public double getIntercept() {
        return intercept;
    }

    public double getSlope() {
        return slope;
    }

    @Override
    public void predict(T input) {
        System.out.println(String.valueOf(intercept+(slope * (double) input)));
    }

    //model
    // prediction = intercept + slope * input
    private void trainUsingGradientDescent(int epochs) {
        
        for(int epoch = 0; epoch <= epochs; epoch ++) {
            List<Double> y_pred = pred(intercept, slope);

            double derivateOfIntercept = 0;
            double derivateOfSlope = 0;
            
            for(int index = 0;index<y_pred.size();index++) {
                derivateOfSlope += ((double)featureList.get(index)) * ((double)targetList.get(index) - (double)y_pred.get(index));
                derivateOfIntercept += ((double)targetList.get(index) - (double)y_pred.get(index));
            }

            intercept = intercept - ((learningRate)*((-2/(double)y_pred.size()) * derivateOfIntercept));
            slope = slope - ((learningRate) * ((-2/(double)y_pred.size()) * derivateOfSlope));
          
            double loss = getLoss(intercept, slope);
            System.out.print(String.format("Epoch %s, loss : %s; ", epoch, loss));
            System.out.println(String.format("Intercept: %s; slope %s ", intercept, slope));
        }
    }

    private List<Double> pred(double intercept, double slope) {
        List<Double> predictions = new ArrayList<Double>();
        double size =(double) featureList.size();
        for(int index = 0; index < size; index++) {
            predictions.add(intercept + (slope * (double)(featureList.get(index))));
        }
        return predictions;
    }


    protected double getLoss(double intercept, double slope) {
        if(lossFunction.equals(LossFunction.MSE)) {
            return MSE(intercept, slope);   
        }
        throw new UncompatiableLossFunction();
    }


    double MSE(double intercept, double slope) {
        double result = 0;
        int size = featureList.size();
        for(int index = 0; index < size; index++) {
            double y2  = predict(intercept, slope, featureList.get(index));
            double diff = (y2-(double)targetList.get(index));
            result += (diff*diff);
        }
        return result/size;
    }

    double predict(double intercept, double slope, T feature) {
        return intercept + (slope * (double)feature);
    }

    @Override
    public String toString() {
        return String.format("Intercept %s\nslope %s\nlearning rate %s\n", intercept, slope, learningRate);
    }
}
