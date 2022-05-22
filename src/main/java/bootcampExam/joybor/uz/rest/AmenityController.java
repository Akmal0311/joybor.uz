package bootcampExam.joybor.uz.rest;

import bootcampExam.joybor.uz.dao.Amenity;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.service.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("amenity")
public class AmenityController {

    private final AmenityService amenityService;

    @GetMapping("/get/{id}")
    public ResponseDTO<Amenity> getById(@PathVariable Integer id){
        return amenityService.getAmenityById(id);
    }

    @GetMapping("/get-all")
    public ResponseDTO<List<Amenity>> getAll(){ return amenityService.getAmenities();}

    @PostMapping("/add")
    public ResponseDTO<Amenity> add(@RequestBody Amenity amenity){ return amenityService.add(amenity);}

    @PutMapping("/update")
    public ResponseDTO<Amenity> update(@RequestBody Amenity amenity){ return amenityService.update(amenity);}

    @DeleteMapping("/delete/{id}")
    public ResponseDTO<Amenity> delete(@PathVariable Integer id){ return amenityService.delete(id);}
}
