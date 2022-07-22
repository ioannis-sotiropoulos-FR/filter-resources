package org.xyz.am.filters;

import java.util.Map;

public interface Filter {
	boolean matches(Map<String, String> resource) throws Exception;
}
