package edu.nus.iss.workshop3.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IOUtil {
    private static final Logger logger = Logger.getLogger(IOUtil.class.getName()); 

    public static void createDir(String path) {

        logger.log(Level.INFO, "create directory");

        File dir = new File(path); //instantiation

        dir.mkdir(); //make directory

        String osName = System.getProperty("os.name");
        if(!osName.contains("Windows")){ //To handle for non window user, window user actually no need

            try{
                    String perm = "rwxrwx---";
                    Set<PosixFilePermission> permissions 
                            = PosixFilePermissions.fromString(perm);
                    Files.setPosixFilePermissions(dir.toPath(), permissions);

            }catch(IOException e){
                    logger.log(Level.SEVERE, "Error creating directory"); //SEVERE for error, logging category to label the log information
            }
        }

    }
}
