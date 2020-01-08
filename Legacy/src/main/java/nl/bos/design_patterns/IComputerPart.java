/**
 * 
 */
package nl.bos.design_patterns;

/**
 * @author bosa
 *
 */
public interface IComputerPart {
	public void accept(IComputerPartVisitor computerPartVisitor);
}
