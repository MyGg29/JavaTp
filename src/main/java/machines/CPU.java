/**
 */
package machines;

import java.util.ArrayList;
import java.util.List;

import machines.visitors.IVisitable;
import machines.visitors.IVisitor;

public class CPU implements IVisitable {
	/**
	 * The default value of the frequence attribute in hertz
	 */
	protected static final double FREQUENCE_EDEFAULT = 200.0;

	/**
	 * The frequence of cpu in hertz
	 */
	protected double frequence = FREQUENCE_EDEFAULT;

	/**
	 * The model of cpu
	 */
	protected String modele;

	/**
	 * The name of cpu
	 */
	protected String marque;

	/**
	 * the cache memory
	 */
	protected List<Memoire> caches;

	/**
	 * by-default constructor
	 */
	public CPU() {
		caches = new ArrayList<Memoire>();
	}

	/**
	 * frequence getter
	 */
	public double getFrequence() {
		return frequence;
	}

	/**
	 * frequence setter
	 */
	public void setFrequence(double newFrequence) {
		frequence = newFrequence;
	}

	/**
	 * model getter
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * model setter
	 */
	public void setModele(String newModele) {
		modele = newModele;
	}

	/**
	 * name getter
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * name setter
	 */
	public void setMarque(String newMarque) {
		marque = newMarque;
	}

	/**
	 * cache getter
	 * 
	 * @generated
	 */
	public List<Memoire> getCaches() {
		return caches;
	}

	/**
	 * CPU printer
	 */
	@Override
	public String toString() {

		StringBuffer result = new StringBuffer();
		result.append(" (frequence: ");
		result.append(frequence);
		result.append(", modele: ");
		result.append(modele);
		result.append(", marque: ");
		result.append(marque);
		result.append(", caches: ");
		result.append(caches);
		result.append(')');
		return result.toString();
	}

	@Override
	public void accept(IVisitor v) {
		v.visit(this);
	}

} //CPUI
