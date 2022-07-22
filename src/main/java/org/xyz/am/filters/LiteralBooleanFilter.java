package org.xyz.am.filters;

import java.util.Map;

import org.xyz.am.properties.Property;

public class LiteralBooleanFilter extends BooleanFilter {
	public LiteralBooleanFilter(Property property) {
		propertyName = property.getPropertyName();
		propertyValue = property.getPropertyValue();
	}

	@Override
	public boolean matches(Map<String, String> resource) {
		String resourceValue = findResourceValue(resource);
		return Boolean.parseBoolean(resourceValue) == Boolean.parseBoolean(propertyValue);
	}
}
