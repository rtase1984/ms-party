//package com.weecover.msparty.adapter.inboud.rest.converter;
//
//import com.weecover.msparty.adapter.inboud.rest.dto.MsPartyRequest;
//import com.weecover.msparty.domain.model.MsParty;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static com.weecover.msparty.domain.model.MsPartyState.NEW;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class MsPartyRequestToMsPartyConverterTest {
//
//    private MsPartyRequestToMsPartyConverter sut;
//
//    @Before
//    public void setUp() {
//        sut = new MsPartyRequestToMsPartyConverter();
//    }
//
//    @Test
//    public void givenMsPartyRequestWhenConvertThenReturnMsParty() {
//        final int expectedValue = 100;
//        final var msPartyRequest = mock(MsPartyRequest.class);
//        when(msPartyRequest.getValue()).thenReturn(expectedValue);
//
//        final var result = sut.convert(msPartyRequest);
//
//        final var expected = MsParty.builder().state(NEW).value(expectedValue).build();
//
//        assertThat(result, is(expected));
//    }
//}