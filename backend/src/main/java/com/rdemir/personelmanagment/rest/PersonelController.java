package com.rdemir.personelmanagment.rest;

import com.rdemir.personelmanagment.model.Personnel;
import com.rdemir.personelmanagment.service.PersonnelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personnel")
@AllArgsConstructor
@Api(value = "Personnel Rest Services")
@CrossOrigin
public class PersonelController {

    private final PersonnelService personnelService;

    @GetMapping("/all")
    @ApiOperation(value = "Get All Personels")
    public ResponseEntity<List<Personnel>> getPersonelList() {
        return new ResponseEntity<>(personnelService.getPersonnelList(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Get One Personel")
    public ResponseEntity<Personnel> getPersonel(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(personnelService.getPersonel(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save One Personel")
    public ResponseEntity<Personnel> savePersonnel(@RequestBody Personnel personnel) {
        return new ResponseEntity<>(personnelService.savePersonnel(personnel), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update One Personel")
    public ResponseEntity<Personnel> updatePersonel(@RequestBody Personnel personnel) {
        return new ResponseEntity<>(personnelService.savePersonnel(personnel), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete One Personel")
    public ResponseEntity<Boolean> updatePersonel(@PathVariable Long id) {
        return new ResponseEntity<>(personnelService.deletePersonel(id), HttpStatus.OK);
    }
}
