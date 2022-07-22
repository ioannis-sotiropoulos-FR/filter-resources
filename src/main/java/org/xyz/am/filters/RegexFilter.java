package org.xyz.am.filters;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xyz.am.properties.Property;

public class RegexFilter extends ComparisonFilter {
	public RegexFilter(Property property) {
		propertyName = property.getPropertyName();
		propertyValue = property.getPropertyValue();
	}

	@Override
	public boolean matches(Map<String, String> resource) throws Exception {
		String resourceValue = findResourceValue(resource);
		Pattern pattern = Pattern.compile(propertyValue);
		Matcher matcher = pattern.matcher(resourceValue);
		return matcher.matches();
	}
}
