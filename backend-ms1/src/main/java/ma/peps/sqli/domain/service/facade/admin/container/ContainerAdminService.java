package ma.peps.sqli.domain.service.facade.admin.container;

import java.util.List;
import ma.peps.sqli.domain.model.container.Container;
import ma.peps.sqli.infra.dao.criteria.core.container.ContainerCriteria;
import ma.peps.sqli.zynerator.service.IService;





public interface ContainerAdminService extends  IService<Container,ContainerCriteria>  {

    List<Container> findByTypeId(Long id);
    int deleteByTypeId(Long id);
    long countByTypeCode(String code);



}
