package net.justugh.hcpt.data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.justugh.hcpt.server.Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private HikariConfig config;
    private HikariDataSource dataSource;

    public DataSource() {
        loadConfiguration();
    }

    private void loadConfiguration() {
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/test.sql'");
        config.setUsername("test_username");
        config.setPassword("test_password");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(config);
    }

    public List<Server> getDatabaseServers() throws SQLException {
        List<Server> servers = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM server");
        ResultSet results = statement.executeQuery();

        while(results.next()) {
            Server tempServer = new Server();
            tempServer.setServerId(results.getInt("serverId"));
            tempServer.setServerName(results.getString("serverName"));
            tempServer.setServerDescription(results.getString("serverDescription"));
            tempServer.setServerCPU(results.getString("serverCPU"));
            tempServer.setServerRam(results.getInt("serverRam"));
            tempServer.setContainerId(results.getInt("containerId"));
            servers.add(tempServer);
        }

        return servers;
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
