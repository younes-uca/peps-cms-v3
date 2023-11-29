package ma.peps.sqli.infra.dao.impl.core.common;

import ma.peps.sqli.zynerator.dao.AbstractDaoImpl;

import ma.peps.sqli.infra.dao.repository.core.common.ContainerTypeRepository;
import ma.peps.sqli.infra.bean.core.common.ContainerTypeEntity;
import ma.peps.sqli.infra.converter.common.ContainerTypeInfraConverter;
import ma.peps.sqli.domain.dao.common.ContainerTypeDao;
import ma.peps.sqli.domain.model.common.ContainerType;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ContainerTypeDaoImpl extends AbstractDaoImpl<ContainerTypeEntity, ContainerType, ContainerTypeRepository, ContainerTypeInfraConverter> implements ContainerTypeDao  {

    @Override
    public ContainerType findByCode(String code){
        ContainerTypeEntity entity = repository.findByCode(code);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByCode(String code){
        return repository.deleteByCode(code);
    }

    @Override
    public List<ContainerType> findAllOptimized(){
    List<ContainerTypeEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }




    public ContainerTypeDaoImpl(ContainerTypeRepository  repository, ContainerTypeInfraConverter converter){
        super(repository,converter);
    }
}
