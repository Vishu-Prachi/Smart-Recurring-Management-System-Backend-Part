package com.cs.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.demo.pdto.UserPassbookDTO;
import com.cs.demo.repo.Passbookrepo;

@Service
public class PassbookService {

    @Autowired
    private Passbookrepo pprepo;

    public List<UserPassbookDTO> getDetail() {
        List<Object[]> rows = pprepo.getUserPassbookDetails();
        return mapToDTO(rows);
    }

    public List<UserPassbookDTO> getUserPassbookDetailById(int rid) {
        List<Object[]> rows = pprepo.getUserPassbookDetailsById(rid);
        return mapToDTO(rows);
    }

    private List<UserPassbookDTO> mapToDTO(List<Object[]> rows) {
        List<UserPassbookDTO> list = new ArrayList<>();

        for (Object[] row : rows) {
            UserPassbookDTO dto = new UserPassbookDTO();

            dto.setName((String) row[0]);

            // FIXED
            dto.setAcno(String.valueOf(row[1]));

            // FIXED
            dto.setRdamt(((Number) row[2]).intValue());

            // SAFE CAST
            dto.setDdate((java.util.Date) row[3]);

            list.add(dto);
        }

        return list;
    }
}