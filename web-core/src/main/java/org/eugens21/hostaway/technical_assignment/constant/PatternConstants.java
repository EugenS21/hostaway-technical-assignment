package org.eugens21.hostaway.technical_assignment.constant;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class PatternConstants {

    public Pattern LOCATORS_RESOLVER_PATTERN = Pattern.compile("^(ID|XPATH|CLASS_NAME|CSS_SELECTOR|TAG_NAME|LINK_TEXT|NAME|PARTIAL_LINK_TEXT)@(.+)$");

}
