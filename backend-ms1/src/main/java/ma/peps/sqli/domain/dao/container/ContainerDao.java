package ma.peps.sqli.domain.dao.container;

import ma.peps.sqli.domain.model.container.Container;


import java.util.List;
import ma.peps.sqli.zynerator.dao.IDao;


public interface ContainerDao extends IDao<Container> {


    List<Container> findByTypeId(Long id);
    int deleteByTypeId(Long id);
    long countByTypeCode(String code);



}
