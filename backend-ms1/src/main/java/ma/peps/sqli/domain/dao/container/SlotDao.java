package ma.peps.sqli.domain.dao.container;

import ma.peps.sqli.domain.model.container.Slot;


import java.util.List;
import ma.peps.sqli.zynerator.dao.IDao;


public interface SlotDao extends IDao<Slot> {


    List<Slot> findByContainerId(Long id);
    int deleteByContainerId(Long id);
    long countByContainerId(Long id);



}
