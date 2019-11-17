package tests;

import java.util.List;

import machines.*;
import machines.visitors.MachineVisitor;

public class testPC {
	public static void main(String[] args) {
		PCFactoryAdapter adapter = new PCFactoryAdapter();
		List<PC> pcs = adapter.createPC("src/test/java/tests/conf.json");
		System.out.println(pcs);
		PCFactory facto = new PCFactory();
		PC myPC = facto.createStandardPC();
		System.out.println(myPC);
		System.out.println(PCFactory.getNumberOfCreatedPc());
		
		//now lets visit ours objects
		MachineVisitor visitor1 = new MachineVisitor();
		myPC.accept(visitor1);
		myPC.getCpu().accept(visitor1);
		myPC.getRAM().accept(visitor1);
	}


}
