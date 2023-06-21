package turtleboi.experiments;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Properties;

public final class Experiments extends JavaPlugin {
    private String version;

    public String propertiesGrab() {
        final Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty("version");
    }

    @Override
    public void onEnable() {
        version = propertiesGrab();
        // Plugin startup logic
        Bukkit.getLogger().info("TurtleBoi Experiments working as expected. Version: " + version);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("TurtleBoi Experiments shutting down. Version: " + version);
    }
}

