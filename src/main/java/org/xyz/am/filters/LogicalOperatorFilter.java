package org.xyz.am.filters;

public abstract class LogicalOperatorFilter implements Filter {
	protected Filter left;
	protected Filter right;
}
