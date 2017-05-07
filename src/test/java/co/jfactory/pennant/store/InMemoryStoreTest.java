package co.jfactory.pennant.store;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InMemoryStoreTest {

    private InMemoryStore store;

    @Before
    public void setup() {
        store = new InMemoryStore();
    }

    @Test
    public void testEmptyStore() {
        Map<String, Boolean> features = store.listAll();
        assertThat(features.size(), equalTo(0));
    }

}
