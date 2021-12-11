package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> getCoinAmounts() {
		return Arrays.stream(Coin.values())
				.map(coin -> coin.amount)
				.collect(Collectors.toList());
	}

	public static Coin getCoinByAmount(int amount) {
		return Arrays.stream(Coin.values())
				.filter(coin -> coin.amount == amount)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException());
	}

	public static int getCoinTypes() {
		return Coin.values().length;
	}

	public int getAmount() {
		return amount;
	}
}
