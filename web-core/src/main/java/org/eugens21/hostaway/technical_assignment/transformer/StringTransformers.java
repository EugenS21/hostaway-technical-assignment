package org.eugens21.hostaway.technical_assignment.transformer;

import io.vavr.control.Try;
import org.eugens21.hostaway.technical_assignment.model.MonetaryAmount;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.function.Function;

import static java.lang.Integer.valueOf;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.eugens21.hostaway.technical_assignment.constant.CurrencyConstants.DEFAULT_CURRENCY;

public final class StringTransformers {

    public static final Function<String, MonetaryAmount> getCurrencyFromString = (string) -> {
        Currency foundCurrency = Currency.getAvailableCurrencies().stream()
                .filter(currency -> currency.getSymbol().equals(string.replaceAll("[0-9.,]", EMPTY)))
                .findFirst()
                .orElse(DEFAULT_CURRENCY);
        String amount = string.replaceAll("[^\\d.]", EMPTY);
        return MonetaryAmount.builder()
                .currency(foundCurrency)
                .amount(new BigDecimal(amount))
                .build();
    };

    public static final Function<String, Integer> getIntegerFromString = (string) ->
            Try.of(() -> valueOf(string.trim().replaceAll("[^\\d.]", EMPTY)))
                    .getOrElse(0);
}
