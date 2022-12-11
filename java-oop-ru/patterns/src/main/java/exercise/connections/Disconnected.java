package exercise.connections;

import exercise.TcpConnection;

public class Disconnected implements Connection{
    private TcpConnection connection;

    public Disconnected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public void connect() {
        this.connection.setState(new Connected(this.connection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error The connection is already disconnected");
    }

    @Override
    public void write(String data) {
        System.out.println("Error Connect first");
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }
}
