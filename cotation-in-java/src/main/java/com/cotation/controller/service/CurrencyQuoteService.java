package com.cotation.controller.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.cotation.controller.coins.Currency;
import com.google.gson.Gson;

public class CurrencyQuoteService {


	public static Currency GetCurrencies() throws Exception {

		String webService = "https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL";
		int successCode = 200;


		URL url = new URL(webService);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		if(connection.getResponseCode() != successCode) throw new RuntimeException("HTTP error code: " + connection.getResponseCode());

		BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		String jsonInString = Util.convertJsonInString(response);

		Gson gson = new Gson();
		Map jsonObject = gson.fromJson(jsonInString, Map.class);
		Map USDBRL = (Map) jsonObject.get("USDBRL");
		Map EURBRL = (Map) jsonObject.get("EURBRL");
		Map BTCBRL = (Map) jsonObject.get("BTCBRL");
		Currency currency = new Currency();
		currency.setBidDollar(USDBRL.get("bid").toString());
		currency.setBidEuro(EURBRL.get("bid").toString());
		currency.setBidBitcoin(BTCBRL.get("bid").toString());
		return currency;
	}
}