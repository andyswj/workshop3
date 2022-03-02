package edu.nus.iss.workshop3;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.nus.iss.workshop3.util.IOUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class Workshop3Application {

	private static Logger logger = Logger.getLogger(Workshop3Application.class.getName());
	public static final String DATA_DIR = "dataDir";

	public static void main(String[] args) {
		logger.log(Level.INFO, "start");

		SpringApplication app = new SpringApplication(Workshop3Application.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		
		List<String> optsval = appArgs.getOptionValues(DATA_DIR);

		if(optsval != null){
			IOUtil.createDir((String)optsval.get(0));
		}else{
			// if cannot find any dataDir argument from the program
			// args then abort the program
			logger.log(Level.SEVERE, "No data directory is provided!");
			System.exit(1);
		}

		app.run(args);
	}

}
