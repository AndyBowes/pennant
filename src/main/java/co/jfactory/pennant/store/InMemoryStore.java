package co.jfactory.pennant.store;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryStore implements FeatureStore {

    private final Map<String,Boolean> features;

    public InMemoryStore() {
        this(new HashMap<>());
    }

    public InMemoryStore(Map<String, Boolean> features) {
        this.features = features;
    }

    @Override
    public boolean containsFeature(String featureName) {
        return features.containsKey(featureName);
    }

    @Override
    public boolean isEnabled(String featureName) {
        return features.getOrDefault(featureName, false);
    }

    @Override
    public Map<String, Boolean> listAll(){
        return Collections.unmodifiableMap(new LinkedHashMap<>(features));
    }

    public void addFeature(String featureName, boolean enabled){
        synchronized (features) {
            features.put(featureName,enabled);
        }
    }

    public void removeFeature(String featureName){
        synchronized (features){
            features.remove(featureName);
        }
    }
}
