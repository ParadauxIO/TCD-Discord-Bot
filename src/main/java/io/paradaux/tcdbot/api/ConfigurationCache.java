package io.paradaux.tcdbot.api;

import java.util.List;

public class ConfigurationCache {

    String token;
    String prefix;
    List<String> courseSelectionChannels;

    public ConfigurationCache(String token, String prefix, List<String> courseSelectionChannels) {
        this.token = token;
        this.prefix = prefix;
        this.courseSelectionChannels = courseSelectionChannels;
    }

    public ConfigurationCache() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<String> getCourseSelectionChannels() {
        return courseSelectionChannels;
    }

    public void setCourseSelectionChannels(List<String> courseSelectionChannels) {
        this.courseSelectionChannels = courseSelectionChannels;
    }

    @Override
    public String toString() {
        return "ConfigurationCache: [ token: " + token + "]";
    }
}
