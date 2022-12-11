package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PairedTag extends Tag{

    private final String text;
    private final List<Tag> tags;

    PairedTag(String name, Map<String, String> attributes, String text, List<Tag> tags) {
        this.name = name;
        this.attributes = attributes;
        this.text = text;
        this.tags = tags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(this.tags.stream().map(x -> x.toString()).collect(Collectors.joining()))
                .append(text)
                .append("</")
                .append(name)
                .append(">");
        return sb.toString();
    }
}
