/**
 * 
 */
package nl.bos.design_patterns.impl;

import java.util.ArrayList;
import java.util.List;

import nl.bos.design_patterns.IFilter;

/**
 * @author bosa
 *
 */
public class FilterChain {
	private List<IFilter> filters = new ArrayList<IFilter>();
	private Target target;

	public void addFilter(IFilter filter) {
		filters.add(filter);
	}

	public void execute(String request) {
		for (IFilter filter : filters) {
			filter.execute(request);
		}
		target.execute(request);
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}
