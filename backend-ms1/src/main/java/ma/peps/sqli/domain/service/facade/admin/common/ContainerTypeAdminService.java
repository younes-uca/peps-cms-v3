package ma.peps.sqli.domain.service.facade.admin.common;

import java.util.List;
import ma.peps.sqli.domain.model.common.ContainerType;
import ma.peps.sqli.infra.dao.criteria.core.common.ContainerTypeCriteria;
import ma.peps.sqli.zynerator.service.IService;





public interface ContainerTypeAdminService extends  IService<ContainerType,ContainerTypeCriteria>  {
    ContainerType findByCode(String code);
    int deleteByCode(String code);




}
