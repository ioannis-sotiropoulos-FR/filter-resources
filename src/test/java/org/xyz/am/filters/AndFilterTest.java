package org.xyz.am.filters;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.xyz.am.properties.Property;

/**
 * Test filter which matches all administrators older than 30
 */
public class AndFilterTest {
    @Test
    public void testAndFilter() throws Exception {
        Map<String, String> resource = createResource();

        Filter leftFilter = new GreatThanFilter(createPropertyRule("age", "30"));
        Filter rightFilter = new EqualsFilter(createPropertyRule("role", "Administrator"));
        AndFilter andFilter = new AndFilter(leftFilter, rightFilter);
        assertTrue(andFilter.matches(resource));
    }

    public Map<String, String> createResource() {
        Map<String, String> resource = new LinkedHashMap<>();

        resource.put("firstname", "Joe");
        resource.put("surname", "Bloggs");
        resource.put("role", "administrator");
        resource.put("age", "35");

        return resource;
    }

    Property createPropertyRule(String propertyName, String propertyValue) {
        return new Property.Builder().propertyName(propertyName).propertyValue(propertyValue).build();
    }
}
