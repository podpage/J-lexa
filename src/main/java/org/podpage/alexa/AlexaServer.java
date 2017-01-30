package org.podpage.alexa;

import org.podpage.alexa.skills.Header;
import org.podpage.alexa.skills.Skill;
import org.podpage.alexa.skills.defaultskills.DebugSkill;
import org.podpage.alexa.skills.defaultskills.DemoSkill;
import org.podpage.alexa.skills.defaultskills.NoSkill;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class AlexaServer {

    private HashMap<String, Class<? extends Skill>> pages = new HashMap<>();
    private HashMap<Pattern, String> paths = new HashMap<>();
    private String domain;
    private SSLWebHandler httpsServer;

    public AlexaServer(String domain) {
        this.domain = domain;
        initPages();
    }

    private void initPages() {
        addWebPage("404", NoSkill.class);
        addWebPage("test", DemoSkill.class);
        addWebPage("debug", DebugSkill.class);
    }


    public void start() {
        httpsServer = new SSLWebHandler(WebManager.sslport);
        new Thread(httpsServer).start();
    }

    public void stop() {
        if (httpsServer != null) {
            httpsServer.kill();
        }
    }

    public String getDomain() {
        return domain;
    }

    public boolean addWebPage(String path, Class<? extends Skill> page) {
        path = Util.fixUrl(path);
        if (!pages.containsKey(path)) {
            pages.put(path, page);
            if (path.contains("*")) {
                paths.put(Util.urlToPattern(path), path);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean addWebPage(String path, Class<? extends Skill> page, String... webpaths) {
        for (String p : webpaths) {
            paths.put(Util.urlToPattern(p), path);
        }
        return addWebPage(path, page);
    }

    public void removeWebPage(String path) {
        path = Util.fixUrl(path);
        if (pages.containsKey(path)) {
            pages.remove(path);
            for (Entry<Pattern, String> entry : paths.entrySet()) {
                if (entry.getValue().equals(path)) {
                    paths.remove(entry.getKey());
                }
            }
        }
    }

    public Skill getWebPage(String path) {
        path = Util.fixUrl(path);
        if (pages.containsKey(path)) {
            Class<? extends Skill> c = pages.get(path);
            try {
                return c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public Skill getPagebyPath(String path) {
        if (path == null) {
            return null;
        }
        Skill page = getWebPage(path);
        if (page != null) {
            return page;
        }
        for (Pattern p : paths.keySet()) {
            if (p.matcher(path).find()) {
                String resolvedpath = paths.get(p);
                return getWebPage(resolvedpath);
            }
        }
        return null;
    }

    public Skill getPagebyHeader(Header header) {
        return getPagebyPath(header.getRequestURL());
    }
}
