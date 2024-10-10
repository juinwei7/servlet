package org.example.user.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 啟動時先執行
 */
@WebListener
public class DateBase implements ServletContextListener {

    private static HikariDataSource dataSource = null;

    // 默認構造函數（無參）
    public DateBase() {
        // 無需任何操作，Tomcat 會自動調用
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // 延遲一秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("啟動中");
        ServletContext servletContext = sce.getServletContext();
        if (dataSource == null) {
            initializeDataSource(servletContext);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeDataSource(ServletContext servletContext) {
        Map<String, Object> configMap = getSqlConfig(servletContext);

        String host = (String) configMap.get("host");
        int port = (int) configMap.get("port");
        String database = (String) configMap.get("database");
        String username = (String) configMap.get("username");
        String password = (String) configMap.get("password");

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=utf8");
        config.setUsername(username);
        config.setPassword(password);
        config.setPoolName("UserHikariPool");
        config.setConnectionTestQuery("SELECT 1;");
        dataSource = new HikariDataSource(config);
        System.out.println("Database has been connected");
    }

    private Map<String, Object> getSqlConfig(ServletContext servletContext) {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/db.yml")) {
            if (inputStream == null) {
                throw new RuntimeException("Could not find db.yml in classpath");
            }
            return yaml.load(inputStream);
        } catch (IOException e) {
            System.err.println("Error loading SQL config: " + e.getMessage());
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    public static HikariDataSource getDataSource() {
        if (dataSource == null) {
            throw new RuntimeException("DataSource is not initialized");
        }
        return dataSource;
    }
}