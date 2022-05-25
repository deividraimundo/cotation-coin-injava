package com.cotation.controller.service;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
	public static String convertJsonInString(BufferedReader bufferedReader) throws IOException {
		String response, jsonInString = "";
		while ((response = bufferedReader.readLine()) != null) {
			jsonInString += response;
			jsonInString += System.getProperty("line.separator");
		}
		
		return jsonInString;
	}
}
