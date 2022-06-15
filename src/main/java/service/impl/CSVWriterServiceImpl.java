package main.java.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import main.java.service.intf.CSVWriterService;
import main.java.service.intf.CsvPojo;

public class CSVWriterServiceImpl implements CSVWriterService {

	@Override
	public void writeCsv(String path, String separator, List<CsvPojo> data, String header) throws FileNotFoundException {

		File csvOutputFile = new File(path);
	    
		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
	    	pw.println(header);
	    	data.stream()
	          .map(t->t.convertToCSVLine(separator))
	          .forEach(pw::println);
	    }
	}

}
