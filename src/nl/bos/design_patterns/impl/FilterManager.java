/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IFilter;

/**
 * @author bosa
 *
 */
public class FilterManager {
	private FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(IFilter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(String request) {
		filterChain.execute(request);
	}
}
