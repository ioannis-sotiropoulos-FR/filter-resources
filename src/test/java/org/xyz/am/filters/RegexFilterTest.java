package org.xyz.am.filters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.xyz.am.properties.Property;

public class RegexFilterTest {

	@Test
	public void testRegexFilter() throws Exception {
		String propertyName = "date";
		String propertyValue = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

		Property property = new Property.Builder().propertyName(propertyName).propertyValue(propertyValue).build();
		
		RegexFilter regexFilter = new RegexFilter(property);
		
		Map<String, String> resource = createResource("2014-03-25");
		assertTrue(regexFilter.matches(resource));
		
		resource = createResource("442015-03-02");
		assertFalse(regexFilter.matches(resource));
	}

	public Map<String, String> createResource(String date) {
		Map<String, String> resource = new LinkedHashMap<>();

		resource.put("firstname", "Joe");
		resource.put("surname", "Bloggs");
		resource.put("role", "administrator");
		resource.put("date", date);

		return resource;
	}
}
