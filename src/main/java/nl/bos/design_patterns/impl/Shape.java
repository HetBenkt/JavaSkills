/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IDrawAPI;

/**
 * @author bosa
 *
 */
public abstract class Shape implements Cloneable {
	private String id;
	protected String type;
	protected IDrawAPI drawAPI;
	
	public Shape() {
		//Do nothing
	}
	
	public Shape(IDrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}
	
	public abstract void draw();

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Object clone() {
		Object clone = null;
		
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		
		return clone;
	}
}
