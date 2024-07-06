import java.util.List;

public interface supervisedLearning<T> {
    void setFeatureList(List<T> featureList);
    void setTargetList(List<T> targetList);
    void predict(T input);
}
