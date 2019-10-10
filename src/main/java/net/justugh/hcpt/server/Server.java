package net.justugh.hcpt.server;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Server {

    private int serverId, serverRam, containerId;
    private String serverName, serverDescription, serverCPU;


    @Override
    public String toString() {
        return String.format("(%s, %s, %s, %s, %s, %s)", serverId, serverName, serverDescription, serverCPU, serverRam, containerId);
    }
}
