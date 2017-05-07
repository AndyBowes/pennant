package co.jfactory.pennant;

import co.jfactory.pennant.store.FeatureStore;

public class FeatureFlagService {

    final FeatureStore store;

    public FeatureFlagService(FeatureStore store) {
        this.store = store;
    }

    public boolean enabled(FeatureFlag feature) {
        final String featureName = feature.getFeatureName();
        return store.containsFeature(featureName) && store.isEnabled(featureName);
    }

}
