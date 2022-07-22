package org.xyz.am.filters;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.xyz.am.properties.Property;

public class LiteralBooleanTest {

	@Test
	public void testLiteralBooleanFilter() {
		String propertyName = "isMarried";
		String propertyValue = "true";

		Map<String, String> resource = createResource();
		Property property = new Property.Builder().propertyName(propertyName).propertyValue(propertyValue).build();
		LiteralBooleanFilter literalBooleanFilter = new LiteralBooleanFilter(property);

		assertTrue(literalBooleanFilter.matches(resource));
	}

	public Map<String, String> createResource() {
		Map<String, String> resource = new LinkedHashMap<>();

		resource.put("firstname", "Joe");
		resource.put("surname", "Bloggs");
		resource.put("role", "user");
		resource.put("isMarried", "true");

		return resource;
	}
}
