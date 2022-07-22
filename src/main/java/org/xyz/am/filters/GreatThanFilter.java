package org.xyz.am.filters;

import java.util.Map;

import org.xyz.am.properties.Property;

public class GreatThanFilter extends ComparisonFilter {
	public GreatThanFilter(Property property) {
		propertyName = property.getPropertyName();
		propertyValue = property.getPropertyValue();
	}

	@Override
	public boolean matches(Map<String, String> resource) throws Exception {
		String resourceValue = findResourceValue(resource);
		return checkIsNumbericValue(resourceValue) > checkIsNumbericValue(propertyValue);
	}
}
