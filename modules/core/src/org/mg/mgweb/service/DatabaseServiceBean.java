package org.mg.mgweb.service;

import com.haulmont.cuba.core.sys.AppContext;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* derivado de https://github.com/jgilsonsi/backup-postgresql */

@Service(DatabaseService.NAME)
public class DatabaseServiceBean implements DatabaseService {

    public void backup(){
        executeCommand(AppContext.getProperty("cuba.dataSource.dbName"), AppContext.getProperty("cuba.dataSource.password"), "backup");
    }

    public void restore(){
        executeCommand(AppContext.getProperty("cuba.dataSource.dbName"), AppContext.getProperty("cuba.dataSource.password"), "restore");
    }

    private void executeCommand(String databaseName, String databasePassword, String type) {

        File backupFilePath = new File(System.getProperty("user.home")
                + File.separator + "backup_" + databaseName);

        if (!backupFilePath.exists()) {
            File dir = backupFilePath;
            dir.mkdirs();
        }

        String backupFileName = "backup_" + databaseName + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".sql";

        List<String> commands = getPgComands(databaseName, backupFilePath, backupFileName, type);
        if (!commands.isEmpty()) {
            try {
                ProcessBuilder pb = new ProcessBuilder(commands);
                pb.environment().put("PGPASSWORD", databasePassword);

                Process process = pb.start();

                try (BufferedReader buf = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()))) {
                    String line = buf.readLine();
                    while (line != null) {
                        System.err.println(line);
                        line = buf.readLine();
                    }
                }

                process.waitFor();
                process.destroy();

                System.out.println("===> Success on " + type + " process.");
            } catch (IOException | InterruptedException ex) {
                System.out.println("Exception: " + ex);
            }
        } else {
            System.out.println("Error: Invalid params.");
        }
    }

    private List<String> getPgComands(String databaseName, File backupFilePath, String backupFileName, String type) {

        ArrayList<String> commands = new ArrayList<>();
        switch (type) {
            case "backup":
                commands.add("pg_dump");
                commands.add("-h"); //database server host
                commands.add(AppContext.getProperty("cuba.dataSource.host"));
                commands.add("-p"); //database server port number
                commands.add(AppContext.getProperty("cuba.dataSource.port"));
                commands.add("-U"); //connect as specified database user
                commands.add(AppContext.getProperty("cuba.dataSource.username"));
                commands.add("-F"); //output file format (custom, directory, tar, plain text (default))
                commands.add("c");
                commands.add("-b"); //include large objects in dump
                commands.add("-v"); //verbose mode
                commands.add("-f"); //output file or directory name
                commands.add(backupFilePath.getAbsolutePath() + File.separator + backupFileName);
                commands.add("-d"); //database name
                commands.add(databaseName);
                break;
            case "restore":
                commands.add("pg_restore");
                commands.add("-h");
                commands.add("localhost");
                commands.add("-p");
                commands.add("5432");
                commands.add("-U");
                commands.add("postgres");
                commands.add("-d");
                commands.add(databaseName);
                commands.add("-v");
                commands.add(backupFilePath.getAbsolutePath() + File.separator + backupFileName);
                break;
            default:
                return Collections.EMPTY_LIST;
        }
        return commands;
    }


}