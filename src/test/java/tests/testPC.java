package tests;

import java.util.List;

import machines.*;

public class testPC {
	public static void main(String[] args) {


		PCFactoryAdapter adapter = new PCFactoryAdapter();
		List<PC> pcs = adapter.createPC("src/test/java/tests/conf.json");
		System.out.println(pcs);
		PCFactory facto = new PCFactory();
		PC myPC = facto.createStandardPC();
		System.out.println(myPC);
		System.out.println(PCFactory.getNumberOfCreatedPc());
	}


}
