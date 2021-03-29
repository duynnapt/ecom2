package com.ecom.core.api;

import com.ecom.core.model.Bills;
import com.ecom.core.payload.BillResponse;
import com.ecom.core.payload.NewBillRequest;
import com.ecom.core.repo.BillRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@RefreshScope
public class EcomController {
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

    @GetMapping("/test")
    public ResponseEntity<?> getDemo() {
        return new ResponseEntity<>(version + " _ " + desc + " ==> " + msg, HttpStatus.OK);
    }

    @Autowired
    private BillRepository billRepository;

    @GetMapping()
    public ResponseEntity<List<BillResponse>> getBills() {
        List<Bills> l = billRepository.findAll();
        List<BillResponse> res = l.stream()
                .map(this::toRes)
                .collect(Collectors.toList());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    private BillResponse toRes(Bills b) {
        BillResponse r =new BillResponse();
        BeanUtils.copyProperties(b, r);
        return r;
    }

    private Bills toEntity(NewBillRequest b) {
        Bills bb = new Bills();
        BeanUtils.copyProperties(b, bb);
        return bb;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillResponse> getBill(@PathVariable String id) {
        Optional<Bills> o = billRepository.findById(id);
        if (!o.isPresent()) {
            return new ResponseEntity<>(new BillResponse(), HttpStatus.OK);
        }
        return new ResponseEntity<>(this.toRes(o.get()), HttpStatus.OK);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<BillResponse> createBill(@RequestBody NewBillRequest rq) {
        Bills b = this.toEntity(rq);
        b.setId(UUID.randomUUID().toString().replace("-", ""));
        Bills bb = billRepository.save(b);
        return new ResponseEntity<>(this.toRes(bb), HttpStatus.OK);
    }
}
