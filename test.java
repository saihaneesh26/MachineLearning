import java.util.ArrayList;

import SLUtils.enums.LossFunction;

public class test {
    public static void main(String[] args) {
        
    }

    private void testLinearRegression() {
        LinearRegression<Double> model = new LinearRegression<Double>();
        model.setInitialIntercept(0);
        model.setInitialSlope(0);
        model.setLearningRate(0.00000002);
        
        model.setLossFunction(LossFunction.MSE);
        ArrayList<LossFunction> acceptableLossFunctions = new ArrayList<>();
        acceptableLossFunctions.add(LossFunction.MSE);
        model.setAcceptableLossFunction(acceptableLossFunctions);
        ArrayList<Double> featureArrayList = new ArrayList<>();
        featureArrayList.add(0,(double)1792);
        featureArrayList.add(1,(double)1714);
        featureArrayList.add(2,(double)1664);
        featureArrayList.add(3,(double)1760);
        featureArrayList.add(4,(double)1685);
        featureArrayList.add(5,(double)1693);
        featureArrayList.add(6,(double)1670);
        featureArrayList.add(7,(double)1764);
      


        ArrayList<Double> targetArrayList = new ArrayList<>();
        targetArrayList.add(0,(double)3.01);
        targetArrayList.add(1,(double)2.4);
        targetArrayList.add(2,(double)2.52);
        targetArrayList.add(3,(double)2.54);
        targetArrayList.add(4,(double)2.74);
        targetArrayList.add(5,(double)2.83);
        targetArrayList.add(6,(double)2.91);
        targetArrayList.add(7,(double)3);
       

        model.setFeatureList(featureArrayList);
        model.setTargetList(targetArrayList);

        model.build(20);

        System.out.println("Intercept : "+model.getIntercept());
        System.out.println("Slope : "+model.getSlope());

        System.out.println("Loss (MSE): "+model.MSE(model.getIntercept(), model.getSlope()));
        model.predict(new Double(1735));
    }
}
