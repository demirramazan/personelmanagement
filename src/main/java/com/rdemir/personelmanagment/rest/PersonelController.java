package com.rdemir.personelmanagment.rest;

import com.rdemir.personelmanagment.model.Personnel;
import com.rdemir.personelmanagment.service.PersonnelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personnel")
@AllArgsConstructor
public class PersonelController {

    private final PersonnelService personnelService;

    @GetMapping("/all")
    public ResponseEntity<List<Personnel>> getPersonelList() {
        return new ResponseEntity<>(personnelService.getPersonnelList(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Personnel> getPersonel(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(personnelService.getPersonel(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Personnel> savePersonnel(@RequestBody Personnel personnel) {
        return new ResponseEntity<>(personnelService.savePersonnel(personnel), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Personnel> updatePersonel(@RequestBody Personnel personnel) {
        return new ResponseEntity<>(personnelService.savePersonnel(personnel), HttpStatus.OK);
    }

    @PostMapping("save2")
    public ResponseEntity<Personnel> savePersonel2(@RequestBody Personnel personnel) {
        return new ResponseEntity<>(personnelService.savePersonnel(personnel), HttpStatus.OK);
    }
}
