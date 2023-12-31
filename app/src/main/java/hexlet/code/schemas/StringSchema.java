package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        Predicate<Object> stringRule = input -> input == null || input instanceof String;
        addRules("string", stringRule);
    }

    public StringSchema required() {
        Predicate<Object> requiredRule = input -> input != null && !((String) input).isEmpty();
        addRules("required", requiredRule);

        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<Object> minLangthRule = input -> ((String) input).length() >= length;
        addRules("minLength", minLangthRule);

        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<Object> containsRule = input -> ((String) input).contains(substring);
        addRules("contains", containsRule);

        return this;
    }
}
