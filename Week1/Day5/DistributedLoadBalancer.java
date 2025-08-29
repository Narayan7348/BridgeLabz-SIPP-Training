/*class LoadBalancer {
    Queue<String> servers;

    LoadBalancer(List<String> serverList) {
        servers = new LinkedList<>(serverList);
    }

    void addServer(String server) {
        servers.add(server);
    }

    void removeServer(String server) {
        servers.remove(server);
    }

    String assignRequest(String request) {
        String server = servers.poll();   // get first
        servers.add(server);              // rotate to back
        print(request + " -> " + server);
        return server;
    }
}

main() {
    LoadBalancer lb = new LoadBalancer(["S1", "S2", "S3"]);

    lb.assignRequest("R1"); // S1
    lb.assignRequest("R2"); // S2
    lb.assignRequest("R3"); // S3

    lb.addServer("S4");
    lb.assignRequest("R4"); // S1
    lb.removeServer("S2");
    lb.assignRequest("R5"); // S3
}
*/