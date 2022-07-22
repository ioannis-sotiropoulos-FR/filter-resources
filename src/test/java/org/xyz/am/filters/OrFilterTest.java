package org.xyz.am.filters;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.xyz.am.properties.Property;

/**
 * Test filter which matches all users with the name Joe or their role is user
 */
public class OrFilterTest {
    @Test
    public void testOrFilter() throws Exception {
        Map<String, String> resourceTestMatch = createResourceMatch();
        Map<String, String> resourceTestMismatch = createResourceMismatch();

        Filter leftFilter = new EqualsFilter(createPropertyRule("firstname", "Joe"));
        Filter rightFilter = new EqualsFilter(createPropertyRule("role", "user"));
        OrFilter orFilter = new OrFilter(leftFilter, rightFilter);
        assertTrue(orFilter.matches(resourceTestMatch));
        assertFalse(orFilter.matches(resourceTestMismatch));
    }

    public Map<String, String> createResourceMatch() {
        Map<String, String> resource = new LinkedHashMap<>();

        resource.put("firstname", "Joe");
        resource.put("surname", "Bloggs");
        resource.put("role", "administrator");
        resource.put("age", "35");
        return resource;
    }

    public Map<String, String> createResourceMismatch() {
        Map<String, String> resource = new LinkedHashMap<>();

        resource.put("firstname", "Steve");
        resource.put("surname", "Bloggs");
        resource.put("role", "administrator");
        resource.put("age", "45");
        return resource;
    }

    Property createPropertyRule(String propertyName, String propertyValue) {
        return new Property.Builder().propertyName(propertyName).propertyValue(propertyValue).build();
    }
}
