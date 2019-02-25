package br.com.codenation.mapfood.resource;

import br.com.codenation.mapfood.document.Motorcyclist;
import br.com.codenation.mapfood.service.MotorcyclistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Motorcyclist", description = "Manipulating Motorcyclist")
@RestController
@RequestMapping(value = "/motorcyclists")
public class MotorcyclistResource {

    private final MotorcyclistService motorcyclistService;

    @Autowired
    public MotorcyclistResource (MotorcyclistService motorcyclistService) {
        this.motorcyclistService = motorcyclistService;
    }

    @ApiOperation(value = "Find all registered motorcyclists")
    @GetMapping(value = "")
    public List<Motorcyclist> getAll() {

        return motorcyclistService.findAll();
    }

    @ApiOperation(value = "Find all available motorcyclists near a point")
    @GetMapping(value = "/available-{distance}")
    public Motorcyclist getTheNearestMotorcyclist(@PathVariable double distance) {

        GeoJsonPoint point = new GeoJsonPoint(-51.210998,-30.034283 );

        return motorcyclistService.findTheNearestMotorcyclist(point,distance);
    }

    @ApiOperation(value = "Turn on Find the a motorcyclist by id")
    @PutMapping(value = "/{id}")
    public Motorcyclist getById(@PathVariable("id") String id) {
        return motorcyclistService.findById(id);
    }
//
//    @ApiOperation(value = "Update the available value of a motorcyclist")
//    @PutMapping(value = "/{id}")
//    public void updateById(@PathVariable("id") String id, @Valid @RequestBody Motorcyclist motorcyclist) {
//        motorcyclist.set_id(id);
//        service.save(motorcyclist);
//    }



}
