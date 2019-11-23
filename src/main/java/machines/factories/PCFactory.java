package machines.factories;

import java.util.ArrayList;
import java.util.List;

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
        List<Memoire> caches = getCaches(conf.cpu.caches);
        CPU cpu = getCPU(conf.cpu, caches);
        Memoire ram = getRam(conf.ram);
        List<Memoire> dds = getDDs(conf.dd);
        Memoire flash = getFlash(conf.flash);
        myPC.setMarque(conf.marque);
        myPC.setModele(conf.model);
        myPC.setCpu(cpu);
        myPC.setRAM(ram);
        myPC.setFlash(flash);
        myPC.getDD().addAll(dds);

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
    private List<Memoire> getDDs(List<DDConf> confList){
        List<Memoire> dds = new ArrayList<>();
        for (DDConf ddConf : confList) {
            Memoire myDD = new Memoire();
            myDD.setCapacite(ddConf.capacite);
            dds.add(myDD);
        }
        return dds;
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
    private List<Memoire> getCaches(List<CacheConf> confList){
        List<Memoire> caches = new ArrayList<>();
        for (CacheConf conf : confList) {
            Memoire myCache = new Memoire();
            myCache.setCapacite(conf.capacite);
            caches.add(myCache);
        }
        return caches;
    }
    private CPU getCPU(CPUConf conf, List<Memoire> caches){
		CPU myCPU = new CPU();
		myCPU.setMarque(conf.marque);
		myCPU.setModele(conf.model);
        myCPU.setFrequence(conf.frequence);
        myCPU.getCaches().addAll(caches);
        return myCPU;
    }
}