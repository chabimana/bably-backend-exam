package rw.babyl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rw.babyl.service.IFizzBuzzService;
import rw.babyl.util.PinkFlamingoResponse;

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
	private IFizzBuzzService babylonService;

	@GetMapping(value = "/fizzbuzz/{minNumber}/{maxNumber}")
	public ResponseEntity<List<Object>> getPinkBuzzResultChallenge(@PathVariable("minNumber") int minNumber,
			@PathVariable("maxNumber") int maxNumber) {

		List<Object> fizzBuzzResponse = babylonService.multipleOfThreeChallenge(minNumber, maxNumber);

		return new ResponseEntity<>(fizzBuzzResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/flamingo")
	public ResponseEntity<PinkFlamingoResponse> getPinkBuzzFlamingoResultChallenge(@PathVariable int minNumber,
			@PathVariable int maxNumber) {

		PinkFlamingoResponse response = new PinkFlamingoResponse();

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
