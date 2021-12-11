package vendingmachine.util;

import vendingmachine.message.Error;
import vendingmachine.model.Product;

public class ProductBuilder {
	private static final String LEFT_BRACKET = "[";
	private static final String RIGHT_BRACKET = "]";
	private static final String INFO_DELIM = ",";
	private static final int INFO_NAME_INDEX = 0;
	private static final int INFO_PRICE_INDEX = 1;
	private static final int INFO_STOCK_INDEX = 2;

	public Product makeProductFromInfo(String rawInfo) {
		String[] info = rawInfo.replace(LEFT_BRACKET, "")
				.replace(RIGHT_BRACKET, "").split(INFO_DELIM);
		validatePrice(info[INFO_PRICE_INDEX]);
		validateStock(info[INFO_STOCK_INDEX]);
		return new Product(info[INFO_NAME_INDEX], Integer.parseInt(info[INFO_PRICE_INDEX]), Integer.parseInt(info[INFO_STOCK_INDEX]));
	}

	private void validatePrice(String priceString) {
		if (!Validator.isOnlyNums(priceString)) {
			throw new IllegalArgumentException(Error.NOT_ONLY_NUMS_IN_PRICE);
		}
		Validator.rightPrice(priceString);
	}

	private void validateStock(String stockString) {
		if (!Validator.isOnlyNums(stockString)) {
			throw new IllegalArgumentException(Error.NOT_ONLY_NUMS_IN_STOCK);
		}
	}
}
