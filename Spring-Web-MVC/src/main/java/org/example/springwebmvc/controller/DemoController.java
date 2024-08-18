package org.example.springwebmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/demo")
@RestController
public class DemoController {
    @GetMapping(value = "/pattern/{name}")
    public String pathVariable(@PathVariable ("name") String name) {
        return "DemoController run perfectly with :"+name;
    }
    @GetMapping(value = "/patternRegex/{id:C\\d{3}}")
    public String pathvariableWithRegex(@PathVariable("id") String id) {
        return "DemoController run perfectly with :"+id;
    }

    @GetMapping(value = "/patternRegex/{id:C\\d{3}}",headers = "X-number")
    public String pathvariableWithRegexAndHeader(@PathVariable("id") String id,@RequestHeader("X-number") int num) {
        return "Path variable is :"+id + " and Header is :"+num;
    }

    @GetMapping(params = "test=all")
    public String params() {
        return "All are tested";
    }

    @GetMapping
    public String otherTest(){
        return "Other test";
    }

    @PostMapping(params = {"name","quantity"})
    public String paramData(@RequestParam("name") String param01,@RequestParam ("quantity") String param02) {
        return "Param data are "+ param01 + " and " + param02;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveJSON(){
        return "Save JSON";
    }

    @PostMapping("/dynamic/{value:\\d{2}}")
    public ResponseEntity<String> returnDynamicData(@PathVariable ("value") int incomingValue){
        if(incomingValue % 2 == 0){
            return ResponseEntity.ok("Dynamic data are even");
        }
        return ResponseEntity.ok("Dynamic data are odd");
    }
}
