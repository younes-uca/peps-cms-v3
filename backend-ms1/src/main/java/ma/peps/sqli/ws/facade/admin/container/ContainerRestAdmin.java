package  ma.peps.sqli.ws.facade.admin.container;

import io.swagger.v3.oas.annotations.Operation;

import ma.peps.sqli.domain.model.container.Container;
import ma.peps.sqli.infra.dao.criteria.core.container.ContainerCriteria;
import ma.peps.sqli.domain.service.facade.admin.container.ContainerAdminService;
import ma.peps.sqli.ws.converter.container.ContainerConverter;
import ma.peps.sqli.ws.dto.container.ContainerDto;
import ma.peps.sqli.zynerator.controller.AbstractController;
import ma.peps.sqli.zynerator.dto.AuditEntityDto;
import ma.peps.sqli.zynerator.helper.PaginatedList;



import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.peps.sqli.zynerator.process.Result;



@RestController
@RequestMapping("/api/admin/container/")
public class ContainerRestAdmin  extends AbstractController<Container, ContainerDto, ContainerCriteria, ContainerAdminService, ContainerConverter> {

    @Override
    @Operation(summary = "Finds a list of all containers")
    @GetMapping("")
    public ResponseEntity<List<ContainerDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a container by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ContainerDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  container")
    @PostMapping("")
    public ResponseEntity<ContainerDto> save(@RequestBody ContainerDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  container")
    @PutMapping("")
    public ResponseEntity<ContainerDto> update(@RequestBody ContainerDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified container")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by type id")
    @GetMapping("type/id/{id}")
    public ResponseEntity<List<ContainerDto>> findByTypeId(@PathVariable Long id){
        return getResponse(service.findByTypeId(id));
    }
    @Operation(summary = "delete by type id")
    @DeleteMapping("type/id/{id}")
    public ResponseEntity<Integer> deleteByTypeId(@PathVariable Long id){
        return getResponse(service.deleteByTypeId(id));
    }



    public ContainerRestAdmin (ContainerAdminService service, ContainerConverter converter) {
        super(service, converter);
    }




}
