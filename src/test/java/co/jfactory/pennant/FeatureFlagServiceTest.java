package co.jfactory.pennant;

import co.jfactory.pennant.store.InMemoryStore;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FeatureFlagServiceTest {

    private FeatureFlagService featureFlagService;

    @Before
    public void setup() {
        Map<String, Boolean> features = new HashMap<>();
        features.put(TestFeatureFlags.ENABLED.getFeatureName(), true);
        features.put(TestFeatureFlags.DISABLED.getFeatureName(), false);

        InMemoryStore featureStore = new InMemoryStore(features);

        featureFlagService = new FeatureFlagService(featureStore);
    }

    @Test
    public void whenNonExistentFlagCheckedThenFalse() {
        assertThat(featureFlagService.enabled(TestFeatureFlags.UNKNOWN), equalTo(false));
    }

    @Test
    public void whenEnabledFeatureFlagCheckedThenTrue() {
        assertThat(featureFlagService.enabled(TestFeatureFlags.ENABLED), equalTo(true));
    }

    @Test
    public void whenDisabledFeatureFlagCheckedThenFalse() {
        assertThat(featureFlagService.enabled(TestFeatureFlags.DISABLED), equalTo(false));
    }


    enum TestFeatureFlags implements FeatureFlag {
        UNKNOWN("unknown"), ENABLED("enabled"), DISABLED("disabled");

        private final String name;

        TestFeatureFlags(String name) {
            this.name = name;
        }

        @Override
        public String getFeatureName() {
            return name;
        }
    }
}
