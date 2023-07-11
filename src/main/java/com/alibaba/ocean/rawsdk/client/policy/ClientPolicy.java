//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.policy;

public class ClientPolicy implements Cloneable {
    private static Integer DEFAULT_HTTP_PORT = 80;
    private static Integer DEFAULT_HTTPS_PORT = 443;
    private static final ClientPolicy CBU_POLICY = new ClientPolicy("gw.open.1688.com");
    private String serverHost;
    private int httpPort;
    private int httpsPort;
    private String appKey;
    private String signingKey;
    private int defaultTimeout;
    private String defaultContentCharset;
    private boolean defaultUseHttps;
    private String agent;

    public static ClientPolicy getDefaultChinaAlibabaPolicy() {
        return CBU_POLICY.clone();
    }

    public ClientPolicy clone() {
        ClientPolicy newObj = this.newPolicy();
        newObj.httpPort = this.httpPort;
        newObj.httpsPort = this.httpsPort;
        newObj.defaultTimeout = this.defaultTimeout;
        newObj.defaultContentCharset = this.defaultContentCharset;
        newObj.defaultUseHttps = this.defaultUseHttps;
        newObj.appKey = this.appKey;
        newObj.signingKey = this.signingKey;
        newObj.agent = this.agent;
        return newObj;
    }

    protected ClientPolicy newPolicy() {
        return new ClientPolicy(this.serverHost);
    }

    public ClientPolicy(String serverHost) {
        this.httpPort = DEFAULT_HTTP_PORT;
        this.httpsPort = DEFAULT_HTTPS_PORT;
        this.defaultTimeout = 5000;
        this.defaultContentCharset = "UTF-8";
        this.defaultUseHttps = false;
        this.agent = "Ocean-SDK-Client";
        if (serverHost != null && serverHost.length() >= 1) {
            this.serverHost = serverHost;
        } else {
            throw new IllegalArgumentException("serverHost can not be empty");
        }
    }

    public int getHttpPort() {
        return this.httpPort;
    }

    public int getHttpsPort() {
        return this.httpsPort;
    }

    public String getServerHost() {
        return this.serverHost;
    }

    public ClientPolicy setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
        return this;
    }

    public ClientPolicy setHttpsPort(Integer httpsPort) {
        this.httpsPort = httpsPort;
        return this;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public ClientPolicy setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    public String getSigningKey() {
        return this.signingKey;
    }

    public ClientPolicy setSigningKey(String signingKey) {
        this.signingKey = signingKey;
        return this;
    }

    public int getDefaultTimeout() {
        return this.defaultTimeout;
    }

    public ClientPolicy setDefaultTimeout(int defaultTimeout) {
        this.defaultTimeout = defaultTimeout;
        return this;
    }

    public String getDefaultContentCharset() {
        return this.defaultContentCharset;
    }

    public ClientPolicy setDefaultContentCharset(String defaultContentCharset) {
        this.defaultContentCharset = defaultContentCharset;
        return this;
    }

    public boolean isDefaultUseHttps() {
        return this.defaultUseHttps;
    }

    public ClientPolicy setDefaultUseHttps(boolean defaultUseHttps) {
        this.defaultUseHttps = defaultUseHttps;
        return this;
    }

    public String getAgent() {
        return this.agent;
    }
}
