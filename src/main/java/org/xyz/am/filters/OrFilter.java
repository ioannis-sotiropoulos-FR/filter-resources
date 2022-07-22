package org.xyz.am.filters;

import java.util.Map;

public class OrFilter extends LogicalOperatorFilter {

	public OrFilter(Filter leftFilter, Filter rightFilter) {
		left = leftFilter;
		right = rightFilter;
	}

	@Override
	public boolean matches(Map<String, String> resource) throws Exception {
		return left.matches(resource) || right.matches(resource);
	}
}
