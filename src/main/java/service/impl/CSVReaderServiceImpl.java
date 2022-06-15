package main.java.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.service.intf.CSVReaderService;

public class CSVReaderServiceImpl implements CSVReaderService {

	@Override
	public List<String[]> readData(String filePath, String separator) {

		String line = "";

		List<String[]> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			line = br.readLine();//to skip header
			while ((line = br.readLine()) != null)
				data.add(line.split(separator));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}

}
