package com.dockerspring.test.web;

import com.dockerspring.test.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/book")
@ResponseBody
public class RestController {
    private final RestService restService;

    @Autowired
    public RestController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/get")
    public ResponseEntity getBook(@RequestParam String id){
        Long Id = Long.parseLong(id);
        return ResponseEntity.ok(restService.getBookStats(Id));
    }
}
