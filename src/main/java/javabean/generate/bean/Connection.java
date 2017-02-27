package javabean.generate.bean;

public class Connection {
    private String host;
    private String port;
    private String db;
    private String schema;
    private String user;
    private String passwd;

    public Connection() {
        super();
    }

    public Connection(String host, String port, String db, String schema, String user, String passwd) {
        super();
        this.host = host;
        this.port = port;
        this.db = db;
        this.schema = schema;
        this.user = user;
        this.passwd = passwd;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
