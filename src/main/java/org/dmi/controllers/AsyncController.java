package org.dmi.controllers;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.dmi.data.CustomData;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Dmytro Gundartsev (dmytro.gundartsev@embedit.cz) on 04.12.17.
 */
@RestController
@RequestMapping("/async")
public class AsyncController {
    @RequestMapping(
            path = "/generator/{quantity}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public @ResponseBody Flux<CustomData> getLines(@PathVariable Integer quantity) {
        List<Integer> nums = IntStream.range(0, quantity).boxed().collect(Collectors.toList());
        return Flux
                .interval(Duration.ofMillis(1000))
                .zipWithIterable(nums)
                .map(item -> CustomData.of(item.getT2(), "Item " + item.getT1() + " is transferred"));
    }

}
