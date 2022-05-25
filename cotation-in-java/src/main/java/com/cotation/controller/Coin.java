package com.cotation.controller;

import com.cotation.controller.coins.Currency;
import com.cotation.controller.service.CurrencyQuoteService;

public class Coin {

	public static void main(String[] args) throws Exception {
		System.out.println("****Cotação das moedas****");
		Currency currency = CurrencyQuoteService.GetCurrencies();


		System.out.println("Dollar: R$" + currency.getBidDollar());
		System.out.println("Euro: R$" + currency.getBidEuro());
		System.out.println("Bitcoin: R$" + currency.getBidBitcoin());
	}
}
