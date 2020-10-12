package net.sigmainfo.lf.automation.common;

import java.io.FileWriter;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by : Rengarajan.m on 07-12-2017. Test class : WriteFile.java Description
 * : This class used for write Value into file
 */

public class WriteFile {
	private String path;
	private boolean append_to_file = false;

	public WriteFile(String file_path) {
		path = file_path;
	}

	public WriteFile(String file_path, boolean append_value) {
		path = file_path;
		append_to_file = append_value;

	}

	public void writeToFile(String textLine) throws IOException {
		FileWriter writer = new FileWriter(path, append_to_file);
		PrintWriter print_write = new PrintWriter(writer);
		print_write.printf("%s" + "%n", textLine);
		print_write.close();

	}
}

