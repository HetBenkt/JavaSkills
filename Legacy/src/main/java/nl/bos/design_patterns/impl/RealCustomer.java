/**
 * 
 */
package nl.bos.design_patterns.impl;

/**
 * @author bosa
 *
 */
public class RealCustomer extends AbstractCustomer {

	public RealCustomer(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.impl.AbstractCustomer#isNil()
	 */
	@Override
	public boolean isNil() {
		return false;
	}

	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.impl.AbstractCustomer#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

}
