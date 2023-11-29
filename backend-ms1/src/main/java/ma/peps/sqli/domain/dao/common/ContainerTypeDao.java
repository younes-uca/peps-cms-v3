package ma.peps.sqli.domain.dao.common;

import ma.peps.sqli.domain.model.common.ContainerType;

import ma.peps.sqli.domain.model.common.ContainerType;

import java.util.List;
import ma.peps.sqli.zynerator.dao.IDao;


public interface ContainerTypeDao extends IDao<ContainerType> {

    ContainerType findByCode(String code);
    int deleteByCode(String code);


    List<ContainerType> findAllOptimized();


}
