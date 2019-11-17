/**
 */
package machines;

import java.util.ArrayList;
import java.util.List;

public class PC  {
	
	/**
	 * The flash memory
	 */
	protected Memoire flash;

	/**
	 * The cpu
	 */
	protected CPU cpu;

	/**
	 * The model of PC
	 */
	protected String modele;

	/**
	 * The name of PC
	 */
	protected String marque;

	/**
	 * the ram memory
	 */
	protected Memoire ram;

	/**
	 * The list of disks
	 */
	protected List<Memoire> dd;

	/**
	 * by-default constructor
	 */
	public PC() {
		dd = new ArrayList<Memoire>();
	}

	/**
	 * flash getter
	 */
	public Memoire getFlash() {
		return flash;
	}

	/**
	 * flash setter
	 */
	public void setFlash(Memoire newFlash) {
		flash = newFlash;
	}

	/**
	 * cpu getter
	 */
	public CPU getCpu() {
		return cpu;
	}

	/**
	 * cpu setter
	 */
	public void setCpu(CPU newCpu) {
		cpu = newCpu ;
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
	 * ram getter
	 */
	public Memoire getRAM() {
		return ram;
	}

	/**
	 * ram setter
	 */
	public void setRAM(Memoire newRAM) {
		ram = newRAM ;
	}

	/**
	 * List of disk getter
	 */
	public List<Memoire> getDD() {
		return dd;
	}

	/**
	 * PC printer
	 */
	public String toString() {
		String result  ="PC [\n"
				+ "marque = " + marque + ",\n"
				+ "modele = " + modele + ",\n"
				+ "cpu = " + cpu.toString() + ",\n";
		
		if (flash!=null) {
				result+= "flash = " + flash.toString() + ",\n";
		}
			result+=  "ram = " + ram.toString() + ",\n";
		if (dd.size()>0) {	
				for (Memoire memoire : dd) {
					result+= "dd = " + memoire.toString();
				}
		}
		return result;
	}

} //PC
