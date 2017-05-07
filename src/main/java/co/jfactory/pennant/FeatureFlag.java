package co.jfactory.pennant;

/**
 * Interface which is used as the base class for the Feature Flag enumerations.
 *
 * Enumerations are preferred to Strings to avoid issues due to mistyped feature names and to simplify the
 * removal of feature flags during refactoring (i.e. the code will not compile unless ALL uses of a feature flag
 * are removed from the code.
 *
 */
public interface FeatureFlag {
    String getFeatureName();
}
