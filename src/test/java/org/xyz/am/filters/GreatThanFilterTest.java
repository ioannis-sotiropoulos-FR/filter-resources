package org.xyz.am.filters;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.xyz.am.properties.Property;

public class GreatThanFilterTest {

	@Test
	public void testGreatThanFilter() throws Exception {
		String propertyName = "loginAttemps";
		String propertyValue = "5";

		Map<String, String> resource = createResource();
		Property property = new Property.Builder().propertyName(propertyName).propertyValue(propertyValue).build();
		GreatThanFilter greatThanFilter = new GreatThanFilter(property);

		assertTrue(greatThanFilter.matches(resource));
	}

	public Map<String, String> createResource() {
		Map<String, String> resource = new LinkedHashMap<>();

		resource.put("firstname", "Joe");
		resource.put("surname", "Bloggs");
		resource.put("role", "user");
		resource.put("loginAttemps", "7");

		return resource;
	}
}
