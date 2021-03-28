package com.ecom.discovery.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api")
@RefreshScope
public class DiscoveryController {
    @Value("${ecom.info.description}")
    private String desc;

    @Value("${ecom.msg}")
    private String msg;

    @Value("${ecom.info.version}")
    private String version;

    @PostConstruct
    private void init() {
        System.out.println(version + "____" + desc);
    }

    @GetMapping
    public ResponseEntity<?> getDemo() {
        return new ResponseEntity<String>(version + " _ " + desc + " ===> " + msg, HttpStatus.OK);
    }
}
