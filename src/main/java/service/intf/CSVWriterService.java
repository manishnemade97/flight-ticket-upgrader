package main.java.service.intf;

import java.io.FileNotFoundException;
import java.util.List;

public interface CSVWriterService {

	void writeCsv(String path, String separator, List<CsvPojo> data, String header) throws FileNotFoundException;
}
