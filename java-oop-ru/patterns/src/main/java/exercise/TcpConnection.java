package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;
import exercise.connections.Connected;

import java.util.List;
import java.util.ArrayList;

public class TcpConnection{
    private Connection state;
    private String ip;
    private int port;

    TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.state = new Disconnected(this);
    }

    public void connect() {
        this.state.connect();
    }

    public void write(String data) {
        this.state.write(data);
    }

    public void disconnect() {
        this.state.disconnect();
    }

    public String getCurrentState() {
        return this.state.getCurrentState();
    }

    public void setState(Connection state) {
        this.state = state;
    }
}
