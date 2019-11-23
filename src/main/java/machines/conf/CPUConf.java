package machines.conf;

import java.util.ArrayList;
import java.util.List;

public class CPUConf {
    public String marque = "deuxMob";
    public String model = "10C";
    public Double frequence = 10000.0;
    public List<CacheConf> caches = new ArrayList<CacheConf>() {
        {
        add(new CacheConf());
    }};
}
