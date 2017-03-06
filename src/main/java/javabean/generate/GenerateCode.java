package javabean.generate;

import com.beust.jcommander.JCommander;
import javabean.generate.bean.ConnectionBean;
import javabean.generate.bean.Table;
import javabean.generate.parse.GenerateJavaBean;
import javabean.generate.parse.Parse;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GenerateCode {
    public static void main(String[] args) {
        CommandOptions options = new CommandOptions();
        new JCommander(options, args);

        List<Table> tables = new Parse(
                new ConnectionBean(options.host, options.port, options.dbName,options.user, options.passwd))
                .getParseTables("Oracle");
        try {
            List<File> outFiles = new GenerateJavaBean(tables).generate(new File(options.dir), options.pkg);
            for(File outFile : outFiles){
                System.out.println(outFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args) {
        CommandOptions options = new CommandOptions();
        new JCommander(options, args);

        List<Table> tables = new Parse(
                new ConnectionBean(options.host, options.port, options.dbName, options.user, options.passwd))
                .getParseTables("mysql");
        try {
            List<File> outFiles = new GenerateJavaBean(tables).generate(new File(options.dir), options.pkg);
            for(File outFile : outFiles){
                System.out.println(outFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}