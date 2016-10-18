package amt.loginwebpages.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Thomas Hernandez
 */
@ApplicationPath("/api")
public class RESTApplication extends Application{
    
    /**
     *
     * @return
     */
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.disableMoxyJson", true);
        return properties;
    }
    
}
