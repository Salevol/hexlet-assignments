package exercise;

import java.util.Map;

class FileKV implements KeyValueStorage {
    private final String path;

    FileKV(String path, Map<String, String> map) {
        this.path = path;
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> map = Utils.unserialize(Utils.readFile(this.path));
        map.put(key, value);
        Utils.writeFile(this.path, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        Map<String, String> map = Utils.unserialize(Utils.readFile(this.path));
        map.remove(key);
        Utils.writeFile(this.path, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> map = Utils.unserialize(Utils.readFile(this.path));
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(this.path));
    }
}
