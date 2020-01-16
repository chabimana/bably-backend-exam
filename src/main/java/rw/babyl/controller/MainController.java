package rw.babyl.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import rw.babyl.service.fizzbuzz.IFizzBuzzPinkFlamingoService;
import rw.babyl.service.romancalculator.IRomanBodmasCalculatorService;
import rw.babyl.util.FIzzBuzzRequest;
import rw.babyl.util.RomanRequest;

/**
 * @Author: chabiman
 * @FileName: MainController.java
 * @Date: Jan 16, 2020
 * @Package: rw.babyl.controller
 * @ProjectName: babyl-backend-exam
 *
 */
@Controller
public class MainController {

	Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private IFizzBuzzPinkFlamingoService fizzBuzzPinkFlamingoService;

	@Autowired
	private IRomanBodmasCalculatorService bodmasCalculator;

	@GetMapping(value = "/")
	public String homepage(Model model) {
		FIzzBuzzRequest request = new FIzzBuzzRequest();
		model.addAttribute("request", request);
		return "index";
	}

	@GetMapping(value = "/fizzbuzz")
	public String fizzbuzzHome(Model model) {
		FIzzBuzzRequest request = new FIzzBuzzRequest();
		model.addAttribute("request", request);
		return "index";
	}

	@PostMapping(value = "/fizzbuzz")
	public String generateFizzBuzzNumbers(@ModelAttribute("request") @Valid FIzzBuzzRequest requestValue, Model model,
			BindingResult results) {
		LOGGER.info("Request:  {}", requestValue);
		LOGGER.error("Errors: {}", results);
		if (results.hasErrors()) {
			FIzzBuzzRequest request = new FIzzBuzzRequest();
			model.addAttribute("request", request);
			return "index";
		}

		List<Object> response = fizzBuzzPinkFlamingoService.fizzBuzzChallenge(requestValue.getStartAt(),
				requestValue.getStopAt());
		LOGGER.info("Response: {}", response);
		model.addAttribute("response", response);
		model.addAttribute("messageDisplay", true);
		return "index";
	}

	@GetMapping(value = "/flamingo")
	public String pinkFlamingoHome(Model model) {
		FIzzBuzzRequest request = new FIzzBuzzRequest();
		model.addAttribute("request", request);
		return "flamingo";
	}

	@PostMapping(value = "/flamingo")
	public String generatePinkFlamingoNumbers(@ModelAttribute("request") @Valid FIzzBuzzRequest requestValue,
			Model model, BindingResult results) {
		LOGGER.info("Request:  {}", requestValue);
		LOGGER.error("Errors: {}", results);
		if (results.hasErrors()) {
			FIzzBuzzRequest request = new FIzzBuzzRequest();
			model.addAttribute("request", request);
			return "flamingo";
		}

		List<Object> response = fizzBuzzPinkFlamingoService.pinkFlamingoChallenge(requestValue.getStartAt(),
				requestValue.getStopAt());
		LOGGER.info("Response: {}", response);
		model.addAttribute("response", response);
		model.addAttribute("messageDisplay", true);
		return "flamingo";
	}

	@GetMapping(value = "/bodmas")
	public String bodmasHome(Model model) {
		RomanRequest request = new RomanRequest();
		model.addAttribute("request", request);
		return "bodmas";
	}

	@PostMapping(value = "/bodmas")
	public String processBodmasExpression(@ModelAttribute("request") @Valid RomanRequest token, Model model,
			BindingResult results) {
		LOGGER.info("Request:  {}", token);
		LOGGER.error("Errors: {}", results);
		if (results.hasErrors()) {
			RomanRequest request = new RomanRequest();
			model.addAttribute("request", request);
			return "bodmas";
		}

		String response = bodmasCalculator.calculateRomanExpressionResult(token.getRomanExpression().toUpperCase());

		LOGGER.info("Response: {}", response);
		model.addAttribute("response", response);
		model.addAttribute("messageDisplay", true);
		return "bodmas";
	}
}
