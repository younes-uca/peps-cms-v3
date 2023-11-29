package ma.peps.sqli.domain.service.impl.admin.container;


import ma.peps.sqli.domain.model.container.Container;
import ma.peps.sqli.infra.dao.criteria.core.container.ContainerCriteria;
import ma.peps.sqli.domain.dao.container.ContainerDao;
import ma.peps.sqli.infra.dao.specification.core.container.ContainerSpecification;
import ma.peps.sqli.domain.service.facade.admin.container.ContainerAdminService;
import ma.peps.sqli.zynerator.service.AbstractServiceImpl;
import ma.peps.sqli.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.peps.sqli.domain.service.facade.admin.container.SlotAdminService ;
import ma.peps.sqli.domain.model.container.Slot ;
import ma.peps.sqli.domain.service.facade.admin.common.ContainerTypeAdminService ;
import ma.peps.sqli.domain.model.common.ContainerType ;

import java.util.List;
@Service
public class ContainerAdminServiceImpl extends AbstractServiceImpl<Container, ContainerCriteria, ContainerDao> implements ContainerAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Container save(Container t) {
    
        super.save(t);
        if (t.getSlots() != null) {
                t.getSlots().forEach(element-> {
                    element.setContainer(t);
                    slotService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += slotService.deleteByContainerId(id);
        result += dao.deleteById(id);
        return result;
    }


    public List<Container> findByTypeId(Long id){
        return dao.findByTypeId(id);
    }
    public int deleteByTypeId(Long id){
        return dao.deleteByTypeId(id);
    }
    public long countByTypeCode(String code){
        return dao.countByTypeCode(code);
    }





    public void configure() {
        super.configure(Container.class);
    }

    @Autowired
    private SlotAdminService slotService ;
    @Autowired
    private ContainerTypeAdminService containerTypeService ;

    public ContainerAdminServiceImpl(ContainerDao dao) {
        super(dao);
    }

}
