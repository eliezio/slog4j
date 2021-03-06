package org.slog4j;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slog4j.format.Formatter;
import org.slog4j.format.FormatterFactory;

@UtilityClass
public class SLoggerFactory {

    public static SLogger getLogger(String name) {
        return getLogger(name, FormatterFactory.getInstance());
    }

    public static SLogger getLogger(Class<?> clazz) {
        return getLogger(clazz, FormatterFactory.getInstance());
    }

    static SLogger getLogger(String name, Formatter formatter) {
        return getLogger(LoggerFactory.getLogger(name), formatter);
    }

    static SLogger getLogger(Class<?> clazz, Formatter formatter) {
        return getLogger(LoggerFactory.getLogger(clazz), formatter);
    }

    static SLogger getLogger(Logger log, Formatter formatter) {
        return new Slf4jSLogger(log, formatter);
    }
}
