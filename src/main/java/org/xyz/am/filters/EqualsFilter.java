package org.xyz.am.filters;

import java.util.Map;

import org.xyz.am.properties.Property;

public class EqualsFilter extends ComparisonFilter {

	public EqualsFilter(Property property) {
		propertyName = property.getPropertyName();
		propertyValue = property.getPropertyValue();
	}

	@Override
	public boolean matches(Map<String, String> resource) throws Exception {
		String resourceValue = findResourceValue(resource);
		return resourceValue.equalsIgnoreCase(propertyValue);
	}
}
