import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CycloneDxPackageTest {

    private final String cycloneDxJsonPath = "/Users/kayejayme/Documents/Tri 1/ENGR489/SBOM-Benchmark/log4j/target/CycloneDX-Sbom.json";
    private JSONObject json;

    @BeforeEach
    void setUp() throws IOException {
        // Read CycloneDX JSON file and parse JSON content
        String jsonContent = new String(Files.readAllBytes(Paths.get(cycloneDxJsonPath)));
        json = new JSONObject(jsonContent);
    }

    // NTIA MINIMUM ELEMENTS tests
    @Test
    void testSupplierName() {
        JSONObject component = json.getJSONObject("metadata").getJSONObject("component");
        assertTrue(component.has("group"), "The 'group' key is missing in the component metadata");
        assertEquals("sbom.benchmark", component.getString("group"), "The value of 'group' key is not as expected");
        assertTrue(component.has("name"), "The 'name' key is missing in the component metadata");
        assertEquals("log4j", component.getString("name"), "The value of 'name' key is not as expected");
    }

    @Test
    void testComponentVersion() {
        JSONObject component = json.getJSONObject("metadata").getJSONObject("component");
        assertTrue(component.has("version"), "The 'version' key is missing in the component metadata");
        assertEquals("1.0-SNAPSHOT", component.getString("version"), "The value of 'version' key is not as expected");
    }

    @Test
    void testTimestamp() {
        JSONObject metadata = json.getJSONObject("metadata");
        assertTrue(metadata.has("timestamp"), "Timestamp is missing in metadata");
    }

    @Test
    void testAuthorOfSBOMData() {
        JSONObject metadata = json.getJSONObject("metadata");
        JSONArray tools = metadata.getJSONArray("tools");
        assertTrue(tools.length() > 0, "Tools array is empty");

        JSONObject tool = tools.getJSONObject(0);
        assertTrue(tool.has("vendor"), "Vendor information is missing in metadata");
        assertTrue(tool.has("name"), "Name information is missing in metadata");
    }


    // Additional tests ...
}
