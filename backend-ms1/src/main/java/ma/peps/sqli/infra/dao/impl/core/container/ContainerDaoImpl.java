package ma.peps.sqli.infra.dao.impl.core.container;

import ma.peps.sqli.zynerator.dao.AbstractDaoImpl;

import ma.peps.sqli.infra.dao.repository.core.container.ContainerRepository;
import ma.peps.sqli.infra.bean.core.container.ContainerEntity;
import ma.peps.sqli.infra.converter.container.ContainerInfraConverter;
import ma.peps.sqli.domain.dao.container.ContainerDao;
import ma.peps.sqli.domain.model.container.Container;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ContainerDaoImpl extends AbstractDaoImpl<ContainerEntity, Container, ContainerRepository, ContainerInfraConverter> implements ContainerDao  {


    @Override
    public List<Container> findByTypeId(Long id){
        List<ContainerEntity> list = repository.findByTypeId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByTypeId(Long id){
        return repository.deleteByTypeId(id);
    }
    @Override
    public long countByTypeCode(String code){
        return repository.countByTypeCode(code);
    }



    public ContainerDaoImpl(ContainerRepository  repository, ContainerInfraConverter converter){
        super(repository,converter);
    }
}
