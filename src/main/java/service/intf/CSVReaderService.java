package main.java.service.intf;

import java.util.List;

public interface CSVReaderService {
	
	List<String[]> readData(String filePath, String separator);
}
