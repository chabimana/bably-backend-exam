package rw.babyl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rw.babyl.service.IFizzBuzzService;
import rw.babyl.util.FizzBuzzResponse;
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

	@GetMapping(value = "/pinkbuzz")
	public ResponseEntity<FizzBuzzResponse> getPinkBuzzResultChallenge(@PathVariable int minNumber,
			@PathVariable int maxNumber) {
		FizzBuzzResponse response = new FizzBuzzResponse();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/flamingo")
	public ResponseEntity<PinkFlamingoResponse> getPinkBuzzFlamingoResultChallenge(@PathVariable int minNumber,
			@PathVariable int maxNumber) {

		PinkFlamingoResponse response = new PinkFlamingoResponse();

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
