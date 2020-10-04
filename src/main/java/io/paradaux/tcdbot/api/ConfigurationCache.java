package io.paradaux.tcdbot.api;

public class ConfigurationCache {

    String token;

    public ConfigurationCache(String token) {
        this.token = token;
    }

    public ConfigurationCache() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ConfigurationCache: [ token: " + token + "]";
    }
}
