package rw.babyl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rw.babyl.service.IFizzBuzzPinkFlamingoService;

/**
 * @Author: chabiman
 * @FileName: IPinkBuzzFlamingoController.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.controller
 * @ProjectName: babyl-backend-exam
 *
 */
@RestController
public class FizzFlamingoController {

	@Autowired
	private IFizzBuzzPinkFlamingoService babylonService;

	@GetMapping(value = "/fizzbuzz/{minNumber}/{maxNumber}")
	public ResponseEntity<List<Object>> getPinkBuzzResultChallenge(@PathVariable("minNumber") int minNumber,
			@PathVariable("maxNumber") int maxNumber) {

		List<Object> fizzBuzzResponse = babylonService.fizzBuzzChallenge(minNumber, maxNumber);

		return new ResponseEntity<>(fizzBuzzResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/flamingo/{minNumber}/{maxNumber}")
	public ResponseEntity<Object> getPinkBuzzFlamingoResultChallenge(@PathVariable("minNumber") int minNumber,
			@PathVariable("maxNumber") int maxNumber) {
		List<Object> pinkFlammingoResponse = babylonService.pinkFlamingoChallenge(minNumber, maxNumber);

		return new ResponseEntity<>(pinkFlammingoResponse, HttpStatus.OK);

	}

}
