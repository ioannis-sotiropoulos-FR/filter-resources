package org.xyz.am.properties;

/**
 * A builder for property rules
 */
public class Property {
    private String propertyName;
    private String propertyValue;

    private Property(Builder builder) {
        this.propertyName = builder.propertyName;
        this.propertyValue = builder.propertyValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public static class Builder {
        private String propertyName;
        private String propertyValue;

        public Builder propertyName(String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        public Builder propertyValue(String propertyValue) {
            this.propertyValue = propertyValue;
            return this;
        }

        public Property build() {
            return new Property(this);
        }
    }
}
