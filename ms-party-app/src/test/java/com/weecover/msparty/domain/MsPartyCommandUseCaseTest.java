//package com.weecover.msparty.domain;
//
//import com.weecover.msparty.provider.MsPartyRepository;
//import com.weecover.msparty.provider.ThirdPartyProvider;
//import com.weecover.boot.base.exception.BusinessException;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertThrows;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.verify;
//
//public class MsPartyCommandUseCaseTest {
///*
//    private MsPartyCommandUseCase sut;
//
//    private MsPartyRepository msPartyRepository;
//    private ThirdPartyProvider thirdPartyProvider;
//
//    @Before
//    public void setUp() {
//        msPartyRepository = mock(MsPartyRepository.class);
//        thirdPartyProvider = mock(ThirdPartyProvider.class);
//        sut = new MsPartyCommandUseCase(msPartyRepository, thirdPartyProvider);
//    }
//
//    @Test
//    public void givenValidMsPartyWhenCommandThenPersist() {
//        final var msParty = MsParty.builder().value(100).build();
//
//        sut.command(msParty);
//
//        verify(thirdPartyProvider).evaluate(msParty);
//        verify(msPartyRepository).create(msParty);
//    }
//
//    @Test
//    public void givenInValidMsPartyWhenCommandThenThrowException() {
//        final var msParty = MsParty.builder().value(101).build();
//
//        assertThrows(BusinessException.class, () -> sut.command(msParty));
//
//        verify(thirdPartyProvider, never()).evaluate(msParty);
//        verify(msPartyRepository, never()).create(msParty);
//    }
//
// */
//}