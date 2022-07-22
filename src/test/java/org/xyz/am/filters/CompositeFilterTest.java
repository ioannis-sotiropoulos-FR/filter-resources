package org.xyz.am.filters;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class CompositeFilterTest {
	// Name Joe AND age > 30 AND role administrator
	private static final String JSON_FILTERS = "{AND=[{Equals={name=firstname, value=[Joe]}}, {GreatThan={name=age, value=[\"30\"]}}, {Equals={name=role, value=[administrator]}}]}";

	@Test
	public void testFilterBuilder() throws Exception {
		CompositeFilter compositeFilter = new CompositeFilter();
		Map<String, String> resource = new LinkedHashMap<>();

		resource.put("firstname", "Joe");
		resource.put("surname", "Bloggs");
		resource.put("role", "administrator");
		resource.put("age", "35");

		Map<String, Object> filters = new Gson().fromJson(JSON_FILTERS, Map.class);
		Filter filter = compositeFilter.createCompositeFilter(filters);
		assertTrue(filter.matches(resource));

		resource.put("firstname", "jOE");
		assertTrue(filter.matches(resource));
	}
}
