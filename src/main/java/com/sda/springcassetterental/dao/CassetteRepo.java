package com.sda.springcassetterental.dao;

import com.sda.springcassetterental.dao.entity.Cassette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassetteRepo extends CrudRepository<Cassette, Long> {


}
