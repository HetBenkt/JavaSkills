/**
 * 
 */
package nl.bos.java8.common;

/**
 * @author bosa
 *
 */
public class MyObject implements IMyObject {
	String status = "";

	public MyObject(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
