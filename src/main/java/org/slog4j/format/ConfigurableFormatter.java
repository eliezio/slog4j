package org.slog4j.format;

import org.joda.convert.StringConverter;
import org.joda.convert.ToStringConverter;

/**
 * A customizable {@link Formatter}.
 */
public interface ConfigurableFormatter extends Formatter {

    /**
     * Changes the label used for the mandatory <code>event</code> property. To avoid any implicit transformation, the
     * provided label cannot contain any space and/or characters that would require quoting (i.e: '\'', '[', ']').
     *
     * @param eventIdLabel The new label.
     * @return this, to enable chaining.
     */
    Formatter eventIdLabel(String eventIdLabel);

    /**
     * Changes the label used for the recommended spanId property.To avoid any implicit transformation, the
     * provided label cannot contain any space and/or characters that would require quoting (i.e: '\'', '[', ']').
     *
     * @param spanIdLabel The new label.
     * @return this, to enable chaining.
     */
    Formatter spanIdLabel(String spanIdLabel);

    /**
     * Adds a new ToStringConverter for a custom type.
     *
     * @param clazz The custom type's class.
     * @param converter The corresponding converter.
     * @param <T> The custom type.
     * @return this, to enable chaining.
     */
    <T> Formatter registerToStringConverter(Class<T> clazz, ToStringConverter<T> converter);

    <T> Formatter registerToPropertiesConverter(Class<T> clazz, ToPropertiesConverter<T> converter);
}
