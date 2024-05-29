package sbom.benchmark;

import org.json.JSONObject;
import org.json.XML;

/**
 * Reads XML and converts it to JSON.
 *  org.json library has a dependency on json-path (CVE-2023-51074)
 */
public class XMLJsonConverter {
    public static void main(String[] args) {
        // Sample XML string
        String xmlString = "<person><name>John Doe</name><age>30</age><city>New York</city></person>";
        // Convert XML to JSON using org.json.XML class
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        System.out.println("JSON format: " + jsonObject.toString(4));

        // Convert JSON back to XML using org.json.XML class
        String backToXml = XML.toString(jsonObject);
        System.out.println("Back to XML: " + backToXml);
    }
}
