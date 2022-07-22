package org.xyz.am.filters;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.xyz.am.properties.Property;

public class PropertyMissingTest {

	@Test
	public void testPropertyNameIsMissing() {
		String propertyName = "surname";
		String propertyValue = "Cameron";

		Map<String, String> resource = createResource();
		Property property = new Property.Builder().propertyName(propertyName).propertyValue(propertyValue).build();
		EqualsFilter equalsFilter = new EqualsFilter(property);

		try {
			equalsFilter.matches(resource);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Property name cannot be found."));
		}
	}

	@Test
	public void testPropertyValueIsMissing() {
		String propertyName = "role";
		String propertyValue = "user";

		Map<String, String> resource = createResource();
		Property property = new Property.Builder().propertyName(propertyName).propertyValue(propertyValue).build();
		EqualsFilter equalsFilter = new EqualsFilter(property);

		try {
			equalsFilter.matches(resource);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Property value cannot be found."));
		}
		
	}
	
	public Map<String, String> createResource() {
		Map<String, String> resource = new LinkedHashMap<>();

		resource.put("firstname", "Joe");
		resource.put("role", "");
		resource.put("loginAttemps", "7");

		return resource;
	}

}
