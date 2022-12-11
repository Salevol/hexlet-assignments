package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    @Test
    void fileKVTest() {
        KeyValueStorage storage = new FileKV(filepath.toString(), Map.of("k1", "v1", "k2", "v2"));
        storage.set("k3", "v3");
        assertThat(storage.toMap()).isEqualTo(Map.of("k1", "v1", "k2", "v2", "k3", "v3"));
        storage.unset("k1");
        assertThat(storage.toMap()).isEqualTo(Map.of("k2", "v2", "k3", "v3"));
        storage.set("k2", "v2.1");
        assertThat(storage.toMap()).isEqualTo(Map.of("k2", "v2.1", "k3", "v3"));
    }
}
