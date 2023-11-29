package  ma.peps.sqli.ws.facade.admin.common;

import io.swagger.v3.oas.annotations.Operation;

import ma.peps.sqli.domain.model.common.ContainerType;
import ma.peps.sqli.infra.dao.criteria.core.common.ContainerTypeCriteria;
import ma.peps.sqli.domain.service.facade.admin.common.ContainerTypeAdminService;
import ma.peps.sqli.ws.converter.common.ContainerTypeConverter;
import ma.peps.sqli.ws.dto.common.ContainerTypeDto;
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
@RequestMapping("/api/admin/containerType/")
public class ContainerTypeRestAdmin  extends AbstractController<ContainerType, ContainerTypeDto, ContainerTypeCriteria, ContainerTypeAdminService, ContainerTypeConverter> {

    @Override
    @Operation(summary = "Finds a list of all containerTypes")
    @GetMapping("")
    public ResponseEntity<List<ContainerTypeDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all containerTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<ContainerTypeDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a containerType by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ContainerTypeDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a containerType by code")
    @GetMapping("code/{code}")
    public ResponseEntity<ContainerTypeDto> findByCode(@PathVariable String code){
        return getResponse(service.findByCode(code));
    }

    @Operation(summary = "Deletes a containerType by code")
    @DeleteMapping("code/{code}")
    public ResponseEntity<Integer> deleteByCode(@PathVariable String code){
        return getResponse(service.deleteByCode(code));
    }

    @Override
    @Operation(summary = "Saves the specified  containerType")
    @PostMapping("")
    public ResponseEntity<ContainerTypeDto> save(@RequestBody ContainerTypeDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  containerType")
    @PutMapping("")
    public ResponseEntity<ContainerTypeDto> update(@RequestBody ContainerTypeDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified containerType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public ContainerTypeRestAdmin (ContainerTypeAdminService service, ContainerTypeConverter converter) {
        super(service, converter);
    }




}
