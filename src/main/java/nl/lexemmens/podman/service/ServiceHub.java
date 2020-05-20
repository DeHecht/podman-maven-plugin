package nl.lexemmens.podman.service;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.shared.filtering.MavenFileFilter;

/**
 * Context class providing access to runtime requirements, such as support classes, image hash
 */
public final class ServiceHub {

    private final CommandExecutorService cmdExecutor;
    private final FileFilterService fileFilterService;

    /**
     * Constructs a new instance of this class
     *
     * @param log             The log from Maven
     * @param mavenFileFilter The {@link MavenFileFilter} service
     */
    ServiceHub(Log log, MavenFileFilter mavenFileFilter) {
        this.cmdExecutor = new CommandExecutorService(log);
        this.fileFilterService = new FileFilterService(log, mavenFileFilter);
    }

    /**
     * Returns a reference to the CommandExecutor
     */
    public final CommandExecutorService getCommandExecutorService() {
        return cmdExecutor;
    }

    /**
     * Returns a reference to the FilterSupport class
     */
    public final FileFilterService getFileFilterService() {
        return fileFilterService;
    }

}
