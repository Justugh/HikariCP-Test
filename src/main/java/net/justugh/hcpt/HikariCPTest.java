package net.justugh.hcpt;

import net.justugh.hcpt.data.DataSource;

import java.sql.SQLException;

public class HikariCPTest {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        try {
            dataSource.getDatabaseServers().forEach(server -> System.out.println(server.toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
