package com.weecover.msparty.adapter.outboud.persistence.repository;

import com.weecover.msparty.adapter.outboud.persistence.dto.MsPartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresMsPartyEntityRepository extends JpaRepository<MsPartyEntity, Long> { }
