package sbom.benchmark;

import org.json.JSONObject;
import org.json.XML;

/**
 * Reads XML and converts it to JSON.
 */
public class XMLJsonConverter {
        public static void main(String[] args) {
        JSONObject json = XML.toJSONObject(args[0]);
        System.out.println(json.toString(4));
    }
}