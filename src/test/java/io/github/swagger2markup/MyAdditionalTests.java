package io.github.swagger2markup;

import io.swagger.models.Swagger;
import org.apache.commons.configuration2.Configuration;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * TODO
 */
public class MyAdditionalTests {

    @Test(expected = RuntimeException.class)
    public void testFromMethodThrowsRuntimeExceptionIfURLIsMalformed() throws URISyntaxException {
        URI uri = new URI("httpsss://abc.com");
        Swagger2MarkupConverter.from(uri);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromMethodThrowsIllegalArgumentExceptionIfSwaggerFileDoesNotExist() throws URISyntaxException {
        Path swaggerPath = Paths.get("some", "invalid", "path", "to", "swagger", "file", "swagger.yml");
        Swagger2MarkupConverter.from(swaggerPath);
    }

    @Test(expected = NullPointerException.class)
    public void testFromMethodThrowsNullPointerExceptionIfSwaggerIsNull() throws URISyntaxException {
        Swagger2MarkupConverter.from((Swagger) null);
    }


    ///////// Swagger2MarkupProperties

    @Test(expected = IllegalStateException.class)
    public void testGetRequiredIntThrowsIllegalStateExceptionWhenPrepertyIsNotPresent() {
        String PROPERTY = "test-property";
        Configuration mockedConfigurationObject = mock(Configuration.class);
        when(mockedConfigurationObject.getInteger(PROPERTY, null)).thenReturn(null);

        Swagger2MarkupProperties swagger2MarkupProperties = new Swagger2MarkupProperties(mockedConfigurationObject);
        // should throw IllegalStateException, since property is null
        swagger2MarkupProperties.getRequiredInt(PROPERTY);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetRequiredBooleanThrowsIllegalStateExceptionWhenPrepertyIsNotPresent() {
        String PROPERTY = "test-property";
        Configuration mockedConfigurationObject = mock(Configuration.class);
        when(mockedConfigurationObject.getBoolean(PROPERTY, null)).thenReturn(null);

        Swagger2MarkupProperties swagger2MarkupProperties = new Swagger2MarkupProperties(mockedConfigurationObject);
        // should throw IllegalStateException, since property is null
        swagger2MarkupProperties.getRequiredBoolean(PROPERTY);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetRequiredStringThrowsIllegalStateExceptionWhenPrepertyIsNotPresent() {
        String PROPERTY = "test-property";
        Configuration mockedConfigurationObject = mock(Configuration.class);
        when(mockedConfigurationObject.getString(PROPERTY)).thenReturn(null);

        Swagger2MarkupProperties swagger2MarkupProperties = new Swagger2MarkupProperties(mockedConfigurationObject);
        // should throw IllegalStateException, since property is null
        swagger2MarkupProperties.getRequiredString(PROPERTY);
    }


}
