package org.odata4j.test.unit.format;

import java.io.StringWriter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.odata4j.core.OProperties;
import org.odata4j.core.OProperty;
import org.odata4j.edm.EdmSimpleType;
import org.odata4j.format.FormatType;
import org.odata4j.format.FormatWriter;
import org.odata4j.format.FormatWriterFactory;
import org.odata4j.producer.PropertyResponse;

public abstract class AbstractPropertyFormatWriterTest {

  protected static final OProperty<LocalDateTime> DATETIME = OProperties.simple("DateTime", EdmSimpleType.DATETIME, new LocalDateTime(2005, 4, 3, 1, 2));
  protected static final OProperty<LocalDateTime> DATETIME_WITH_SECONDS = OProperties.simple("DateTime", EdmSimpleType.DATETIME, new LocalDateTime(2006, 5, 4, 1, 2, 3));
  protected static final OProperty<LocalDateTime> DATETIME_WITH_MILLIS = OProperties.simple("DateTime", EdmSimpleType.DATETIME, new LocalDateTime(2007, 6, 5, 1, 2, 3, 4));

  protected static final OProperty<DateTime> DATETIME_BEFORE_1970_NO_OFFSET = OProperties.simple("DateTimeOffset", EdmSimpleType.DATETIMEOFFSET, new DateTime(1969, 8, 7, 5, 6, 0, 0, DateTimeZone.UTC));
  protected static final OProperty<DateTime> DATETIME_WITH_SECONDS_POSITIVE_OFFSET = OProperties.simple("DateTimeOffset", EdmSimpleType.DATETIMEOFFSET, new DateTime(2006, 5, 4, 1, 2, 3, 0, DateTimeZone.forOffsetHours(7)));
  protected static final OProperty<DateTime> DATETIME_WITH_MILLIS_NEGATIVE_OFFSET = OProperties.simple("DateTimeOffset", EdmSimpleType.DATETIMEOFFSET, new DateTime(2007, 6, 5, 1, 2, 3, 4, DateTimeZone.forOffsetHours(-8)));

  protected static final OProperty<LocalTime> TIME = OProperties.simple("Time", EdmSimpleType.TIME, new LocalTime(1, 2, 3));
  protected static final OProperty<LocalTime> TIME_WITH_MILLIS = OProperties.simple("Time", EdmSimpleType.TIME, new LocalTime(1, 2, 3, 4));

  protected static final OProperty<Boolean> BOOLEAN_PROPERTY = OProperties.simple("Boolean", EdmSimpleType.BOOLEAN, Boolean.FALSE);

  protected static FormatWriter<PropertyResponse> formatWriter;

  protected StringWriter stringWriter;

  protected static void createFormatWriter(FormatType format) {
    formatWriter = FormatWriterFactory.getFormatWriter(PropertyResponse.class, null, format.toString(), null);
  }

  @Before
  public void setup() throws Exception {
    stringWriter = new StringWriter();
  }
}