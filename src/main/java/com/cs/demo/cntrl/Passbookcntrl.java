package com.cs.demo.cntrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs.demo.Entity.Rdpassbook;
import com.cs.demo.pdto.UserPassbookDTO;
import com.cs.demo.repo.Passbookrepo;
import com.cs.demo.service.PassbookService;

@RestController
@RequestMapping("/rdpassbook")
public class Passbookcntrl {

    @Autowired
    private Passbookrepo prepo;

    @Autowired
    private PassbookService service;

    // ✅ Get all passbook records (Entity)
    // URL: http://localhost:8080/rdpassbook
    @GetMapping
    public List<Rdpassbook> getAllPassbook() {
        return prepo.findAll();
    }

    // ✅ Get passbook by RID
    // URL: http://localhost:8080/rdpassbook/rid/1
    @GetMapping("/passbookById/{rid}")
    public List<Rdpassbook> getPassbookByRid(@PathVariable("rid") int rid) {
        return prepo.getAllByRid(rid);
    }

    // ✅ Get JOIN data using DTO (BEST PRACTICE)
    // URL: http://localhost:8080/rdpassbook/details
    @GetMapping("/details")
    public List<UserPassbookDTO> getDetails() {
        return service.getDetail();
    }

    // ✅ Get JOIN data by RID (DTO)
    // URL: http://localhost:8080/rdpassbook/details/1
    @GetMapping("/details/{rid}")
    public List<UserPassbookDTO> getDetailsByRid(@PathVariable("rid") int rid) {
        return service.getUserPassbookDetailById(rid);
    }

    // ✅ Total amount
    // URL: http://localhost:8080/rdpassbook/total
    @GetMapping("/total")
    public Map<String, Object> getSummary() {
        Long total = prepo.getTotalAmt();
        Map<String, Object> result = new HashMap<>();
        result.put("total", total != null ? total : 0);
        return result;
    }

    // ✅ Save
    // URL: POST http://localhost:8080/rdpassbook
    @PostMapping
    public Rdpassbook psave(@RequestBody Rdpassbook p) {
        return prepo.save(p);
    }

    // ✅ Update
    // URL: PUT http://localhost:8080/rdpassbook
    @PutMapping
    public Rdpassbook pupdate(@RequestBody Rdpassbook p) {
        return prepo.save(p);
    }

    // ✅ Delete
    // URL: DELETE http://localhost:8080/rdpassbook/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        if (!prepo.existsById(id)) {
            return "Record not found";
        }
        prepo.deleteById(id);
        return "Record Deleted Successfully";
    }
}