package javabean.generate;

import com.beust.jcommander.JCommander;
import javabean.generate.bean.Connection;
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
                new Connection(options.host, options.port, options.db,options.schema, options.user, options.passwd))
                .getParseTables();
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
                new Connection(options.host, options.port, options.db, options.user, options.passwd))
                .getParseTables();
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