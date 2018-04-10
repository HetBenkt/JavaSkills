/**
 * 
 */
package nl.bos.design_patterns.impl;

/**
 * @author bosa
 *
 */
public class CoarseGrainedObject {
	DependentObject do1 = new DependentObject();
	DependentObject do2 = new DependentObject();

	public void setData(String data1, String data2) {
		do1.setData(data1);
		do2.setData(data2);
	}

	public String[] getData() {
		return new String[] { do1.getData(), do2.getData() };
	}
}
