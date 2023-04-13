package org.eugens21.hostaway.technical_assignment.properties.service;

import io.vavr.API;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.hostaway.technical_assignment.constant.PatternConstants;
import org.eugens21.hostaway.technical_assignment.enums.ByStrategies;
import org.eugens21.hostaway.technical_assignment.exceptions.InvalidLocatorExpressionException;
import org.openqa.selenium.By;

import java.util.regex.Matcher;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static org.eugens21.hostaway.technical_assignment.enums.ByStrategies.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class LocatorsResolverService {

    private Pair<ByStrategies, String> resolveExpression(String stringToResolve) {
        Matcher matcher = PatternConstants.LOCATORS_RESOLVER_PATTERN.matcher(stringToResolve);
        if (matcher.find()) {
            ByStrategies byStrategies = ByStrategies.valueOf(matcher.group(1));
            return Pair.of(byStrategies, matcher.group(2));
        }
        throw new InvalidLocatorExpressionException(String.format("Invalid locator provided %s, it should follow the format " +
                "[(ID|XPATH|CLASS_NAME|CSS_SELECTOR|TAG|LINK_TEXT|NAME|PARTIAL_LINK_TEXT)]<>expression", stringToResolve));
    }

    public By resolve(String stringToResolve) {
        var strategieExpressionPair = resolveExpression(stringToResolve);
        return API.Match(strategieExpressionPair.getKey()).of(
                Case($(ID), () -> By.id(strategieExpressionPair.getValue())),
                Case($(XPATH), () -> By.xpath(strategieExpressionPair.getValue())),
                Case($(CSS_SELECTOR), () -> By.cssSelector(strategieExpressionPair.getValue())),
                Case($(CLASS_NAME), () -> By.className(strategieExpressionPair.getValue())),
                Case($(TAG_NAME), () -> By.tagName(strategieExpressionPair.getValue())),
                Case($(NAME), () -> By.name(strategieExpressionPair.getValue())),
                Case($(LINK_TEXT), () -> By.linkText(strategieExpressionPair.getValue())),
                Case($(PARTIAL_LINK_TEXT), () -> By.partialLinkText(strategieExpressionPair.getValue()))
        );
    }

}
