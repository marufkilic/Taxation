package com.nerodata.controller;

import com.nerodata.model.InputTaxation;
import com.nerodata.model.OutputTaxation;
import com.nerodata.model.Trader;
import com.nerodata.service.TraderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trader")
public class TraderController {

    private final TraderService traderService;

    @GetMapping()
    public List<Trader> getAllTraders() {
        return traderService.getAllTraders();
    }

    @GetMapping("/{id}")
    public Trader getTrader(@PathVariable("id") int id) {
        return traderService.getTraderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTrader(@PathVariable("id") int id) {
        traderService.delete(id);
    }

    @PostMapping()
    public ResponseEntity<Object> saveTrader(@RequestBody Trader trader) {
        try {
            getTrader(trader.getTraderId());
            return new ResponseEntity<>("The trader you want to add is already added. Please try with different id.", HttpStatus.CONFLICT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(traderService.saveOrUpdate(trader), HttpStatus.OK);
        }
    }

    @PostMapping("/calculate")
    public ResponseEntity<Object> test(@RequestBody InputTaxation taxation) {
        try {
            OutputTaxation result = traderService.calculateTaxation(taxation.getTraderId(), taxation.getPurchaseAmount());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}