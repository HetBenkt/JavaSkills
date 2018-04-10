/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IImage;

/**
 * @author bosa
 *
 */
public class ProxyImage implements IImage {

	private RealImage realImage;
	private String fileName;
	
	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}
	
	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.IImage#display()
	 */
	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}
