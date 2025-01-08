//package com.weecover.msparty.adapter.outboud.persistence;
//
//import com.weecover.msparty.adapter.outboud.persistence.dto.MsPartyEntity;
//import com.weecover.msparty.adapter.outboud.persistence.repository.PostgresMsPartyEntityRepository;
//import com.weecover.msparty.domain.model.MsParty;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.core.convert.ConversionService;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class MsPartyRepositoryAdapterTest {
//
//    private MsPartyRepositoryAdapter sut;
//
//    private PostgresMsPartyEntityRepository repository;
//    private ConversionService conversionService;
//
//    @Before
//    public void setUp() {
//        repository = mock(PostgresMsPartyEntityRepository.class);
//        conversionService = mock(ConversionService.class);
//
//        sut = new MsPartyRepositoryAdapter(repository, conversionService);
//    }
//
//    @Test
//    public void givenMsPartyWhenCreateThenSave() {
//        final var msParty = mock(MsParty.class);
//        final var expected = mock(MsPartyEntity.class);
//        when(conversionService.convert(msParty, MsPartyEntity.class)).thenReturn(expected);
//
//        sut.create(msParty);
//
//        verify(conversionService).convert(msParty, MsPartyEntity.class);
//        verify(repository).save(expected);
//    }
//}