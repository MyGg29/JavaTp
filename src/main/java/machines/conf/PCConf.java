package machines.conf;

import java.util.ArrayList;
import java.util.List;

public class PCConf {
    public String marque = "superPC";
    public String model = "PC4";
    public CPUConf cpu = new CPUConf();
    public RAMConf ram = new RAMConf();
    public List<DDConf> dd = new ArrayList<DDConf>(){{
        add(new DDConf());
    }};
	public FlashConf flash = new FlashConf();
}
