package amt.loginwebpages.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * This class implements the configuration of the REST api
 * and defines its path as '/api'
 * 
 * @author Antony Ciani & Thomas Hernandez
 */
@ApplicationPath("/api")
public class RESTApplication extends Application{
    
    /**
     *
     * @return properties - the desired configuration
     */
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.disableMoxyJson", true);
        return properties;
    }
    
}
