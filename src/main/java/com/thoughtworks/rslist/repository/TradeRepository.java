package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.dto.RsEventDto;
import com.thoughtworks.rslist.dto.TradeDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface TradeRepository extends CrudRepository<TradeDto, Integer> {
    List<TradeDto> findAll();

    @Transactional
    @Query(value = "select * from trade where trade.rank = ?1",nativeQuery = true)
    List<TradeDto> findByRank(int eventId);
}