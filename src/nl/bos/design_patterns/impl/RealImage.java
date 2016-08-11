/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_IMAGE;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_IMAGE_LOAD;
import nl.bos.design_patterns.IImage;

/**
 * @author bosa
 *
 */
public class RealImage implements IImage {

	private String fileName;
	
	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}
	
	private void loadFromDisk(String fileName) {
		System.out.println(String.format(STR_OUTPUT_IMAGE_LOAD, fileName));		
	}

	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.IImage#display()
	 */
	@Override
	public void display() {
		System.out.println(String.format(STR_OUTPUT_IMAGE, fileName));
	}
}
