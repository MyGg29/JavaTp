/**
 */
package machines;

import machines.visitors.IVisitable;
import machines.visitors.IVisitor;

public class Memoire implements IVisitable {
	/**
	 * The default value of the capacity attribute in byte
	 */
	protected static final int CAPACITE_EDEFAULT = 100;

	/**
	 * memory capacity in byte
	 */
	protected double capacite = CAPACITE_EDEFAULT;

	/**
	 * by-default constructor
	 */
	public Memoire() {
	}

	/**
	 * capacity getter
	 */
	public double getCapacite() {
		return capacite;
	}

	/**
	 * capacity setter
	 */
	public void setCapacite(double d) {
		capacite = d;
	}

	/**
	 * memory printer
	 */
	@Override
	public String toString() {

		StringBuffer result = new StringBuffer();
		result.append(" (capacite: ");
		result.append(capacite);
		result.append(')');
		return result.toString();
	}

	@Override
	public void accept(IVisitor v) {
		v.visit(this);
	}

} //Memoire
