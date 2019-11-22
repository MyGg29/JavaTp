package machines.factories;

import machines.CPU;
import machines.Memoire;
import machines.PC;
import machines.conf.CPUConf;
import machines.conf.CacheConf;
import machines.conf.DDConf;
import machines.conf.FlashConf;
import machines.conf.PCConf;
import machines.conf.RAMConf;

public class PCFactory {

    private static int createdObjects = 0;

    // Build a pc based on a given conf
    public PC createPC(PCConf conf) {
        PC myPC = new PC();
        // Create the standardConfig
        Memoire cache = getCache(conf.cpu.cache);
        CPU cpu = getCPU(conf.cpu, cache);
        Memoire ram = getRam(conf.ram);
        Memoire dd = getDD(conf.dd);
        Memoire flash = getFlash(conf.flash);
        myPC.setMarque(conf.marque);
        myPC.setModele(conf.model);
        myPC.setCpu(cpu);
        myPC.setRAM(ram);
        myPC.setFlash(flash);
        myPC.getDD().add(dd);

        createdObjects++;
        return myPC;
    }


    // Build a standard PC based on a default conf
    public PC createStandardPC() {
        return createPC(new PCConf());
    }
    public static int getNumberOfCreatedPc(){
        return createdObjects;
    }
    private Memoire getDD(DDConf conf){
		Memoire myDD = new Memoire();
        myDD.setCapacite(conf.capacite);
        return myDD;
    }
    private Memoire getFlash(FlashConf conf) {
        Memoire myFlash = new Memoire();
        myFlash.setCapacite(conf.capacite);
        return myFlash;
    }
    private Memoire getRam(RAMConf conf){
		Memoire myRAM = new Memoire();
        myRAM.setCapacite(conf.capacite);
        return myRAM;
    }
    private Memoire getCache(CacheConf conf){
		Memoire myCache = new Memoire();
        myCache.setCapacite(conf.capacite);
        return myCache;
    }
    private CPU getCPU(CPUConf conf, Memoire cache){
		CPU myCPU = new CPU();
		myCPU.setMarque(conf.marque);
		myCPU.setModele(conf.model);
        myCPU.setFrequence(conf.frequence);
        myCPU.getCache().add(cache);
        return myCPU;
    }
}