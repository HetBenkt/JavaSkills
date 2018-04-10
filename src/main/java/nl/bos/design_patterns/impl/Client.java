/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_DATA;

/**
 * @author bosa
 *
 */
public class Client {
	private BusinessDelegate businessService;
	private CompositeEntity compositeEntity = new CompositeEntity();
	private FilterManager filterManager;

	public Client() {
	};

	public Client(BusinessDelegate businessService) {
		this.businessService = businessService;
	}

	/**
	 * InterceptingFilterDemo
	 * 
	 * @param filterManager
	 */
	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	/**
	 * InterceptingFilterDemo
	 * 
	 * @param request
	 */
	public void sendRequest(String request) {
		filterManager.filterRequest(request);
	}

	/**
	 * BusinessDelegatePatternDemo
	 */
	public void doTask() {
		businessService.doTask();
	}

	/**
	 * CompositeEntityPatternDemo
	 */
	public void printData() {
		for (int i = 0; i < compositeEntity.getData().length; i++) {
			System.out.println(String.format(STR_OUTPUT_DATA,
					compositeEntity.getData()[i]));
		}
	}

	/**
	 * CompositeEntityPatternDemo
	 * 
	 * @param data1
	 * @param data2
	 */
	public void setData(String data1, String data2) {
		compositeEntity.setData(data1, data2);
	}
}