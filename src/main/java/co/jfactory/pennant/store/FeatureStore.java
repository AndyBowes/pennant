package co.jfactory.pennant.store;

import java.util.Map;

public interface FeatureStore {
    boolean containsFeature(String featureName);
    boolean isEnabled(String featureName);
    Map<String, Boolean> listAll();
}
