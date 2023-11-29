package ma.peps.sqli.domain.service.impl.admin.container;


import ma.peps.sqli.domain.model.container.Slot;
import ma.peps.sqli.infra.dao.criteria.core.container.SlotCriteria;
import ma.peps.sqli.domain.dao.container.SlotDao;
import ma.peps.sqli.infra.dao.specification.core.container.SlotSpecification;
import ma.peps.sqli.domain.service.facade.admin.container.SlotAdminService;
import ma.peps.sqli.zynerator.service.AbstractServiceImpl;
import ma.peps.sqli.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.peps.sqli.domain.service.facade.admin.container.ContainerAdminService ;
import ma.peps.sqli.domain.model.container.Container ;

import java.util.List;
@Service
public class SlotAdminServiceImpl extends AbstractServiceImpl<Slot, SlotCriteria, SlotDao> implements SlotAdminService {






    public List<Slot> findByContainerId(Long id){
        return dao.findByContainerId(id);
    }
    public int deleteByContainerId(Long id){
        return dao.deleteByContainerId(id);
    }
    public long countByContainerId(Long id){
        return dao.countByContainerId(id);
    }





    public void configure() {
        super.configure(Slot.class);
    }

    @Autowired
    private ContainerAdminService containerService ;

    public SlotAdminServiceImpl(SlotDao dao) {
        super(dao);
    }

}
