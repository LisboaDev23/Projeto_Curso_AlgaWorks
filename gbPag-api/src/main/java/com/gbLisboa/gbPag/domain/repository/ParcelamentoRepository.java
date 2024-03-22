package com.gbLisboa.gbPag.domain.repository;

import com.gbLisboa.gbPag.domain.model.Parcelamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelamentoRepository extends JpaRepository<Parcelamento,Long> {

}
