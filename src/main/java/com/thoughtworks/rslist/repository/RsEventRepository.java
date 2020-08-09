package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.dto.RsEventDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RsEventRepository extends CrudRepository<RsEventDto, Integer> {
    List<RsEventDto> findAll();

    @Transactional
    void deleteAllByUserId(int userId);

    @Transactional
    @Query(value = "select * from rs_event order by rank",nativeQuery = true)
    List<RsEventDto> findAllEventByRank();

//    @Transactional
//    @Query(value = "select * from rs_event where rs_event.id = ?1",nativeQuery = true)
//    List<RsEventDto> findByEventId(int rank);
}
