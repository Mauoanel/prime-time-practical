package za.co.bmw.primetime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.*;
import za.co.bmw.primetime.calculate.PrimeNumbersCalculator;
import za.co.bmw.primetime.pojo.Range;

import java.util.List;

@RestController
public class PrimeTimeController {

    @Autowired
    PrimeNumbersCalculator primeNumbersCalculator;


    private final CounterService counterService;

    @Autowired
    public PrimeTimeController(CounterService counterService){
        this.counterService = counterService;
    }

    /**
     * Get a list prime numbers for a given start and end.
     * @param range
     * @return a list of prime numbers.
     */
    @RequestMapping(value = "/api/v1/calculate/primenumber",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public @ResponseBody Object getPrimeTime(@RequestBody Range range) {
        counterService.increment("counter.services.primenumbers.invoked");
        return (range.getSieveOfEratosthenes() ? primeNumbersCalculator.getPrimeNumbersWithSieveOfEratosthenes(range) : primeNumbersCalculator.getPrimeNumbers(range)) ;
    }
}
