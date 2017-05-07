package co.jfactory.pennant.store;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ImmutableConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.BasicConfigurationBuilder;
import org.apache.commons.configuration2.builder.ConfigurationBuilder;
import org.apache.commons.configuration2.event.EventListener;
import org.apache.commons.configuration2.event.EventType;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Before;

public class ConfigurationStoreTest {

    private ConfigurationStore store;

    @Before
    public void setup(){

        ConfigurationBuilder builder = new BasicConfigurationBuilder<PropertiesConfiguration>()

        final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
        Configuration config = propertiesConfiguration;
        store = new ConfigurationStore()
    }



}
