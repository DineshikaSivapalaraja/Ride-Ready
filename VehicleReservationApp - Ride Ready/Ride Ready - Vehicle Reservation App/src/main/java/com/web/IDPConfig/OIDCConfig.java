package com.web.IDPConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OIDCConfig {
    private static final Properties properties = new Properties();
    
    static {
        try (InputStream input = OIDCConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //OIDC configuration with Asgardeo
    public static String getClientId() {
        return properties.getProperty("oidc_clientId");
    }

    public static String getClientSecret() {
        return properties.getProperty("oidc_clientSecret");
    }

    public static String getRedirectUri() {
        return properties.getProperty("oidc_redirectUri");
    }

    public static String getTokenEndpoint() {
        return properties.getProperty("oidc_tokenUrl");
    }
    
    public static String getUserinfoEndpoint() {
        return properties.getProperty("oidc_userinfoUrl");
    }
}


