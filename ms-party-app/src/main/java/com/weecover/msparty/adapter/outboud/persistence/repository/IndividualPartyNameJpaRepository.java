package com.weecover.msparty.adapter.outboud.persistence.repository;

import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IndividualPartyNameJpaRepository extends JpaRepository<IndividualPartyName, UUID> {
    Optional<IndividualPartyName> findByFirstFamilyNameAndSecondFamilyNameAndDeletedDateIsNull(String firstFamilyName, String secondFamilyName);

    Optional<IndividualPartyName> findByLastNameAndDeletedDateIsNull(String lastName);

    // Consulta para búsqueda por 'with_family_names'
    @Query("""
        SELECT ipn FROM IndividualPartyName ipn
        WHERE (:firstName IS NULL OR ipn.firstName = :firstName)
          AND (:middleName IS NULL OR ipn.middleName = :middleName)
          AND (:firstFamilyName IS NULL OR ipn.firstFamilyName = :firstFamilyName)
          AND (:secondFamilyName IS NULL OR ipn.secondFamilyName = :secondFamilyName)
          AND (:otherFamilyName IS NULL OR ipn.otherFamilyName = :otherFamilyName)
    """)
    List<IndividualPartyName> findWithFamilyNames(@Param("firstName") String firstName,
                                                  @Param("middleName") String middleName,
                                                  @Param("firstFamilyName") String firstFamilyName,
                                                  @Param("secondFamilyName") String secondFamilyName,
                                                  @Param("otherFamilyName") String otherFamilyName
    );

    // Consulta para búsqueda por 'with_last_name'
    @Query("""
        SELECT ipn FROM IndividualPartyName ipn
        WHERE (:firstName IS NULL OR ipn.firstName = :firstName)
          AND (:middleName IS NULL OR ipn.middleName = :middleName)
          AND (:lastName IS NULL OR ipn.lastName = :lastName)
    """)
    List<IndividualPartyName> findWithLastName(@Param("firstName") String firstName,
                                               @Param("middleName") String middleName,
                                               @Param("lastName") String lastName
    );

    @Query("""
        SELECT DISTINCT ip FROM IndividualParty ip
        JOIN FETCH ip.partyNames pn
        WHERE function('SOUNDEX', pn.firstName) = function('SOUNDEX', :firstName)
          AND (:middleName IS NULL OR function('SOUNDEX', pn.middleName) = function('SOUNDEX', :middleName))
          AND (:lastName IS NULL OR function('SOUNDEX', pn.lastName) = function('SOUNDEX', :lastName))
          AND (:firstFamilyName IS NULL OR function('SOUNDEX', pn.firstFamilyName) = function('SOUNDEX', :firstFamilyName))
          AND (:secondFamilyName IS NULL OR function('SOUNDEX', pn.secondFamilyName) = function('SOUNDEX', :secondFamilyName))
          AND (:otherFamilyName IS NULL OR function('SOUNDEX', pn.otherFamilyName) = function('SOUNDEX', :otherFamilyName))
    """)
    List<IndividualParty> findBySoundexName(
            @Param("firstName") String firstName,
            @Param("middleName") String middleName,
            @Param("lastName") String lastName,
            @Param("firstFamilyName") String firstFamilyName,
            @Param("secondFamilyName") String secondFamilyName,
            @Param("otherFamilyName") String otherFamilyName
    );

    // Búsqueda por email
    @Query("""
        SELECT DISTINCT ip FROM IndividualParty ip
        JOIN FETCH ip.partyEmails pe
        WHERE pe.email = :email
    """)
    List<IndividualParty> findByEmail(@Param("email") String email);

    // Búsqueda por teléfono
    @Query("""
        SELECT DISTINCT ip FROM IndividualParty ip
        JOIN FETCH ip.partyPhones pp
        WHERE pp.phoneNumber = :phoneNumber
    """)
    List<IndividualParty> findByPhone(@Param("phoneNumber") String phoneNumber);
}
