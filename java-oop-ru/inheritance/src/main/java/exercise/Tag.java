package exercise;

import java.util.stream.Collectors;
import java.util.Map;

public abstract class Tag {
    protected String name;
    protected Map<String, String> attributes;

    Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    protected Tag() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.name);
        for (Map.Entry e: attributes.entrySet()) {
            sb.append(" ").append(e.getKey()).append("=\"").append(e.getValue()).append("\"");
        }
        return sb.append(">").toString();
    }
}
