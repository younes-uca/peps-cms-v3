package  ma.peps.sqli.ws.facade.admin.container;

import io.swagger.v3.oas.annotations.Operation;

import ma.peps.sqli.domain.model.container.Slot;
import ma.peps.sqli.infra.dao.criteria.core.container.SlotCriteria;
import ma.peps.sqli.domain.service.facade.admin.container.SlotAdminService;
import ma.peps.sqli.ws.converter.container.SlotConverter;
import ma.peps.sqli.ws.dto.container.SlotDto;
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
@RequestMapping("/api/admin/slot/")
public class SlotRestAdmin  extends AbstractController<Slot, SlotDto, SlotCriteria, SlotAdminService, SlotConverter> {

    @Override
    @Operation(summary = "Finds a list of all slots")
    @GetMapping("")
    public ResponseEntity<List<SlotDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a slot by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SlotDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  slot")
    @PostMapping("")
    public ResponseEntity<SlotDto> save(@RequestBody SlotDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  slot")
    @PutMapping("")
    public ResponseEntity<SlotDto> update(@RequestBody SlotDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified slot")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by container id")
    @GetMapping("container/id/{id}")
    public ResponseEntity<List<SlotDto>> findByContainerId(@PathVariable Long id){
        return getResponse(service.findByContainerId(id));
    }
    @Operation(summary = "delete by container id")
    @DeleteMapping("container/id/{id}")
    public ResponseEntity<Integer> deleteByContainerId(@PathVariable Long id){
        return getResponse(service.deleteByContainerId(id));
    }



    public SlotRestAdmin (SlotAdminService service, SlotConverter converter) {
        super(service, converter);
    }




}
