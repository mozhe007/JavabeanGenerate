package javabean.generate;

import com.beust.jcommander.Parameter;

public class CommandOptions {

    private static final String DEAFULT_DB = "Oracle";
    private static final String DEFAULT_HOST = "192.168.150.152";
    private static final String DEFAULT_PORT = "1521";
    private static final String DEFAULT_DB_NAME = "zrrwtshkf01";
    private static final String DEFAULT_USER = "DKFP_NW";
    private static final String DEFAULT_PASSWD = "dkfp_nw";
    private static final String DEFAULT_PKG = "com.example";
    private static final String DEFAULT_DIR = "D://";

    public String db = DEAFULT_DB;

    @Parameter(names = {"-host", "-h"})
    public String host = DEFAULT_HOST;

    @Parameter(names = {"-port", "-p"})
    public String port = DEFAULT_PORT;

    @Parameter(names = {"-database", "-dbName"})
    public String dbName = DEFAULT_DB_NAME;

    @Parameter(names = {"-user", "-u"})
    public String user = DEFAULT_USER;

    @Parameter(names = {"-passwd", "-pw"})
    public String passwd = DEFAULT_PASSWD;

    @Parameter(names = {"-dir", "-d"})
    public String dir = DEFAULT_DIR;

    @Parameter(names = {"-package", "-pkg"})
    public String pkg = DEFAULT_PKG;


}
