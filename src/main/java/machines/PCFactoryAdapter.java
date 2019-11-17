package machines;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import machines.conf.PCConf;

public class PCFactoryAdapter {
    private PCFactory adaptee;
    public PCFactoryAdapter() {
        adaptee = new PCFactory();
    }
    public List<PC> createPC(String pathToJson) {
        List<PC> result = new ArrayList<>();
        List<PCConf> pcConfListFromJson = convertJsonToConfList(pathToJson);
        pcConfListFromJson.forEach(pcConf -> {
            result.add(this.adaptee.createPC(pcConf));
        });
        return result;
    }
    private List<PCConf> convertJsonToConfList(String pathToJson){
        List<PCConf> confList = new ArrayList<PCConf>();

		JSONParser parser = new JSONParser();
		JSONArray jsonPCConf = new JSONArray();
		try {
			FileReader reader = new FileReader(pathToJson);
            jsonPCConf = (JSONArray)parser.parse(reader);
            jsonPCConf.forEach(pcConf -> confList.add(parseConfObject((JSONObject)pcConf)));
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} catch(ParseException e){
			e.printStackTrace();
        }
        System.out.println(confList);
        return confList;
    }
	private static PCConf parseConfObject(JSONObject jsonConf) {
        PCConf conf = new PCConf();
        JSONObject cpuConfObject = (JSONObject) jsonConf.get("cpu");
        JSONObject cpuCacheConfObject = (JSONObject) cpuConfObject.get("cache");
        JSONObject ramConfObject = (JSONObject) jsonConf.get("ram");
        JSONObject ddConfObject = (JSONObject) jsonConf.get("dd");
        JSONObject flashConfObject = (JSONObject) jsonConf.get("flash");
        conf.marque = (String)jsonConf.get("marque");
        conf.model = (String)jsonConf.get("model");
        conf.cpu.marque = (String) cpuConfObject.get("marque");
        conf.cpu.model = (String) cpuConfObject.get("model");
        //the parser gives us longs when he sees numbers, 
        //we need to convert them to double to fill our interface
        conf.cpu.frequence = new Long((long) cpuConfObject.get("frequence")).doubleValue();
        conf.cpu.cache.capacite = new Long((long) cpuCacheConfObject.get("capacite")).doubleValue();
        conf.ram.capacite = new Long((long) ramConfObject.get("capacite")).doubleValue();
        conf.dd.capacite = new Long((long) ddConfObject.get("capacite")).doubleValue();
        conf.flash.capacite = new Long((long) flashConfObject.get("capacite")).doubleValue();

        return conf;
    }

}