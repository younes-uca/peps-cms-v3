package ma.peps.sqli.infra.dao.impl.core.container;

import ma.peps.sqli.zynerator.dao.AbstractDaoImpl;

import ma.peps.sqli.infra.dao.repository.core.container.SlotRepository;
import ma.peps.sqli.infra.bean.core.container.SlotEntity;
import ma.peps.sqli.infra.converter.container.SlotInfraConverter;
import ma.peps.sqli.domain.dao.container.SlotDao;
import ma.peps.sqli.domain.model.container.Slot;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SlotDaoImpl extends AbstractDaoImpl<SlotEntity, Slot, SlotRepository, SlotInfraConverter> implements SlotDao  {


    @Override
    public List<Slot> findByContainerId(Long id){
        List<SlotEntity> list = repository.findByContainerId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByContainerId(Long id){
        return repository.deleteByContainerId(id);
    }
    @Override
    public long countByContainerId(Long id){
        return repository.countByContainerId(id);
    }



    public SlotDaoImpl(SlotRepository  repository, SlotInfraConverter converter){
        super(repository,converter);
    }
}
