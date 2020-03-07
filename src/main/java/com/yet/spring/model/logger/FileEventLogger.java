package com.yet.spring.model.logger;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yet.spring.model.Event;

import static com.yet.spring.util.message.ExceptionMessages.CANNOT_WRITE_TO_FILE;
import static java.lang.String.format;

@Component
public class FileEventLogger extends AbstractLogger {

	private File file;

	@Value("${event.file:target/events_log.txt}")
	private String fileName;
	
	public FileEventLogger() {}
	
	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}
	
	@PostConstruct
	private void init() throws IOException {
		file = new File(fileName);
		if (file.exists() && !file.canWrite()) {
			throw new IllegalArgumentException(format(CANNOT_WRITE_TO_FILE, fileName));
		} else if (!file.exists()) {
			file.createNewFile();
		}
	}
	
	@Override
	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(file, event.toString(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Value("File logger")
	@Override
	public void setName(String name) {
		this.name = name;
	}

}
