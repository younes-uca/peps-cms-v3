package ma.peps.sqli.domain.service.facade.admin.container;

import java.util.List;
import ma.peps.sqli.domain.model.container.Slot;
import ma.peps.sqli.infra.dao.criteria.core.container.SlotCriteria;
import ma.peps.sqli.zynerator.service.IService;





public interface SlotAdminService extends  IService<Slot,SlotCriteria>  {

    List<Slot> findByContainerId(Long id);
    int deleteByContainerId(Long id);
    long countByContainerId(Long id);



}
