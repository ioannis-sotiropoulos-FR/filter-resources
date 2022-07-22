package org.xyz.am.filters;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.xyz.am.properties.Property;

public class LessThanFilterTest{
	
	@Test
	public void testLessThanFilter() throws Exception {
		String propertyName = "age";
		String propertyValue = "40";

		Map<String, String> resource = createResource();

		Property property = new Property.Builder().propertyName(propertyName).propertyValue(propertyValue).build();
		LessThanFilter lessThanFilter = new LessThanFilter(property);

		assertTrue(lessThanFilter.matches(resource));
	}

	public Map<String, String> createResource() {
		Map<String, String> resource = new LinkedHashMap<>();

		resource.put("firstname", "Joe");
		resource.put("surname", "Bloggs");
		resource.put("role", "administrator");
		resource.put("age", "35");

		return resource;
	}
}
