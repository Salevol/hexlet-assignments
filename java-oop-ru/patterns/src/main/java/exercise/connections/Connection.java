package exercise.connections;

public interface Connection {
    public void connect();
    public void disconnect();
    public void write(String data);
    public String getCurrentState();
}
