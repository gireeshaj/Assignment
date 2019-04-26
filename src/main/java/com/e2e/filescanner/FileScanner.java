package com.e2e.filescanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.e2e.utils.*;

@Component
public class FileScanner {

	private static final String FILE_EXT_PATTERN = "([^\\s]+(\\.(?i)(csv|xls|xlsx))$)";
	public static List<FileInformation> fileInfoList;

	public FileScanner() {
		fileInfoList = new ArrayList<FileInformation>();
	}

	public void readFileScanner(String fileDir) {
		scanFileDirectories(new File(fileDir), Pattern.compile(FILE_EXT_PATTERN));
		System.out.println(fileInfoList);
	}

	private void scanFileDirectories(final File dir, final Pattern pattern) {
		final File[] files = dir.listFiles();
		if (files != null) {
			for (final File file : files) {
				if (file.isDirectory()) {
					scanFileDirectories(file, pattern);
				} else if (pattern.matcher(file.getName()).matches()) {
					try {
						FileInformation x = getFileInformation(file.getAbsolutePath());
						fileInfoList.add(x);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private FileInformation getFileInformation(String fileUrl) throws IOException {
		FileInformation fileInfo = new FileInformation();
		Path file = Paths.get(fileUrl);
		BasicFileAttributes basicFileAttributes = Files.getFileAttributeView(file, BasicFileAttributeView.class)
				.readAttributes();
		fileInfo.setFileName(file.getFileName().toString());
		fileInfo.setFileExtension(getFileExtension(new File(fileUrl)));
		fileInfo.setFileSize(basicFileAttributes.size());
		fileInfo.setFileMimeType(Files.probeContentType(file));
		return fileInfo;
	}

	private String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}

	public List<Vehicles> getDataFromCsv() {
		List<Vehicles> listOfVehicles=new ArrayList<Vehicles>();
		String csvFile = new File("").getAbsolutePath() + File.separatorChar + "src/test/resources" + File.separatorChar
				+ "vehicles.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			int count = 0;
			while ((line = br.readLine()) != null) {
				if (count != 0) {
					Vehicles vehicles=new Vehicles();
					String[] vehicleDetails = line.split(cvsSplitBy);
					vehicles.setVehicleName(vehicleDetails[0]);
					vehicles.setVehicleColor(vehicleDetails[1]);
					listOfVehicles.add(vehicles);
				}
				count = count + 1;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Done");
		return listOfVehicles;

	}
}
