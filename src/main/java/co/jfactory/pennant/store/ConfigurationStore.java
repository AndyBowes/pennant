package co.jfactory.pennant.store;

import org.apache.commons.configuration2.Configuration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Implementation of the @link(FeatureStore) which loads the list of enabled features from the System Configuration
 *
 * This uses Apache commons-configuration to load options from the System Environment & an optional Properties file
 *
 */
public class ConfigurationStore implements FeatureStore {

    private static final String DEFAULT_PREFIX = "feature.toggle.";

    private final String keyPrefix;
    private final Configuration config;

    public ConfigurationStore(Configuration config) {
        this(DEFAULT_PREFIX, config);
    }

    public ConfigurationStore(String keyPrefix, Configuration config) {
        this.keyPrefix = keyPrefix;
        this.config = config.subset(keyPrefix);
    }

    @Override
    public boolean containsFeature(String featureName) {
        return config.containsKey(featureName);
    }

    @Override
    public boolean isEnabled(String featureName) {
        return config.getBoolean(featureName, false);
    }

    @Override
    public Map<String, Boolean> listAll() {
        Map<String, Boolean> features = new HashMap<>();
        Iterator<String> keys = config.getKeys();
        keys.forEachRemaining( key -> features.put(key,isEnabled(key)));
        return features;
    }
}
