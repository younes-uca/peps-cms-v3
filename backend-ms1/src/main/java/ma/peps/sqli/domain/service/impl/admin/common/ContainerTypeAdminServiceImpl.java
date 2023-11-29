package ma.peps.sqli.domain.service.impl.admin.common;


import ma.peps.sqli.domain.model.common.ContainerType;
import ma.peps.sqli.infra.dao.criteria.core.common.ContainerTypeCriteria;
import ma.peps.sqli.domain.dao.common.ContainerTypeDao;
import ma.peps.sqli.infra.dao.specification.core.common.ContainerTypeSpecification;
import ma.peps.sqli.domain.service.facade.admin.common.ContainerTypeAdminService;
import ma.peps.sqli.zynerator.service.AbstractServiceImpl;
import ma.peps.sqli.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ContainerTypeAdminServiceImpl extends AbstractServiceImpl<ContainerType, ContainerTypeCriteria, ContainerTypeDao> implements ContainerTypeAdminService {





    public ContainerType findByCode(String code){
        return dao.findByCode(code);
    }
    public int deleteByCode(String code){
        return dao.deleteByCode(code);
    }


    public List<ContainerType> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(ContainerType.class);
    }


    public ContainerTypeAdminServiceImpl(ContainerTypeDao dao) {
        super(dao);
    }

}
