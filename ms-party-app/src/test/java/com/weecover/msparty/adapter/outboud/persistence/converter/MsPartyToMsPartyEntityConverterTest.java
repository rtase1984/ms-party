package com.weecover.msparty.adapter.outboud.persistence.converter;

import com.weecover.msparty.domain.model.MsParty;
import org.junit.Before;
import org.junit.Test;

import static com.weecover.msparty.domain.model.MsPartyState.NEW;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class MsPartyToMsPartyEntityConverterTest {

    private MsPartyToMsPartyEntityConverter sut;

    @Before
    public void setUp() {
        sut = new MsPartyToMsPartyEntityConverter();
    }

    @Test
    public void givenMsPartyWhenConvertThenReturnMsPartyEntity() {
        final int expectedValue = 100;
        final var expected = MsParty.builder().state(NEW).value(expectedValue).build();

        final var result = sut.convert(expected);

        assertThat(result.getId(), is(nullValue()));
        assertThat(result.getState(), is("NEW"));
        assertThat(result.getValue(), is(expectedValue));
        assertThat(result.getCreation(), is(notNullValue()));
    }
}