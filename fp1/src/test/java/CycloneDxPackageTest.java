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

    // Path to the CycloneDX JSON file
    // TODO: Put a relative pathname once location of SBOMs have changed.
    private final String cycloneDxJsonPath = "/Users/kayejayme/Documents/Tri 1/ENGR489/SBOM-Benchmark/log4j/target/CycloneDX-Sbom.json";
    private JSONObject json;

    @BeforeEach
    void setUp() throws IOException {
        // Read CycloneDX JSON file and parse JSON content
        String jsonContent = new String(Files.readAllBytes(Paths.get(cycloneDxJsonPath)));
        json = new JSONObject(jsonContent);
    }

    /** NTIA MINIMUM ELEMENTS tests */
   @Test
    void testSupplierName() {
        JSONObject component = json.getJSONArray("components").getJSONObject(0);
        assertTrue(component.has("publisher"), "The 'publisher' key is missing in the component JSON");
        assertEquals("The Apache Software Foundation", component.getString("publisher"), "The value of 'publisher' key is not as expected");
    }

    @Test
    void testComponentName1() {
        JSONObject component = json.getJSONArray("components").getJSONObject(0);
        assertEquals("log4j-api", component.getString("name"), "Incorrect component name");
    }

    @Test
    void testComponentName2() {
        JSONObject component = json.getJSONArray("components").getJSONObject(1);
        assertEquals("log4j-core", component.getString("name"), "Incorrect component name");
    }

    @Test
    void testComponentVersion() {
        JSONObject component = json.getJSONArray("components").getJSONObject(0);
        assertTrue(component.has("version"), "2.13.0");
    }

    @Test
    void testOtherUniqueIdentifiers() {
        JSONObject component = json.getJSONArray("components").getJSONObject(0);
        assertEquals("org.apache.logging.log4j", component.getString("group"), "Incorrect group or group doesn't exist.");
    }

    @Test
    void testDependencyRelationship() {
        // TODO: INSERT CORRECT DEPENDENCIES
        JSONArray dependencies = json.getJSONArray("dependencies");
        assertTrue(dependencies.length() > 0, "Dependencies are missing");
    }

    @Test
    void testTimestamp() {
        JSONObject metadata = json.getJSONObject("metadata");
        assertTrue(metadata.has("timestamp"), "Timestamp is missing");
    }

    @Test
    void testAuthorOfSBOMData() {
        JSONObject metadata = json.getJSONObject("metadata");
        assertTrue(metadata.has("tools") && metadata.has("vendor") && metadata.has("name"), "Author of SBOM Data is missing");
    }


    /** CYCLONEDX FORMAT SPECIFIC TESTS */
}
