package rw.babyl.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import rw.babyl.service.fizzbuzz.IFizzBuzzPinkFlamingoService;
import rw.babyl.service.romancalculator.IRomanBodmasCalculatorService;
import rw.babyl.service.romancalculator.IRomanNumeralConvertorService;
import rw.babyl.util.FIzzBuzzRequest;
import rw.babyl.util.NumeralRequest;
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

	/** The fizz buzz pink flamingo service. */
	@Autowired
	private IFizzBuzzPinkFlamingoService fizzBuzzPinkFlamingoService;

	/** The bodmas calculator. */
	@Autowired
	private IRomanBodmasCalculatorService bodmasCalculator;

	/** The converter service. */
	@Autowired
	private IRomanNumeralConvertorService converterService;

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
	public String generateFizzBuzzNumbers(@ModelAttribute("request") @Valid FIzzBuzzRequest request, Errors errors,
			Model model) {
		if (errors.hasErrors()) {
			LOGGER.info("{}", errors.getAllErrors());
			return "redirect:/fizzbuzz";
		}
		List<Object> response = fizzBuzzPinkFlamingoService.fizzBuzzChallenge(request.getStartAt(),
				request.getStopAt());
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
			BindingResult results, Model model) {
		LOGGER.info("Request:  {}", requestValue);
		LOGGER.error("Errors: {}", results);
		if (results.hasErrors()) {
			FIzzBuzzRequest request = new FIzzBuzzRequest();
			model.addAttribute("request", request);
			return "flamingo";
		}
		try {
			List<Object> response = fizzBuzzPinkFlamingoService.pinkFlamingoChallenge(requestValue.getStartAt(),
					requestValue.getStopAt());
			LOGGER.info("Response: {}", response);
			model.addAttribute("response", response);
			model.addAttribute("messageDisplay", true);
			return "flamingo";
		} catch (IllegalArgumentException ex) {
			model.addAttribute("response", "Invalid input data");
			model.addAttribute("messageDisplay", true);
			return "flamingo";
		}

	}

	@GetMapping(value = "/bodmas")
	public String bodmasHome(Model model) {
		RomanRequest request = new RomanRequest();
		model.addAttribute("request", request);
		return "bodmas";
	}

	@PostMapping(value = "/bodmas")
	public String processBodmasExpression(@ModelAttribute("request") @Valid RomanRequest token, BindingResult results,
			Model model) {
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

	@GetMapping(value = "/converter/toRoman")
	public String converteRomanHome(Model model) {
		NumeralRequest numRequest = new NumeralRequest();
		model.addAttribute("numRequest", numRequest);
		return "converterroman";
	}

	@PostMapping(value = "/converter/toRoman")
	public String convertNumeralToRoman(@ModelAttribute("numRequest") @Valid NumeralRequest number,
			BindingResult results, Model model) {
		LOGGER.info("Request:  {}", number);
		LOGGER.error("Errors: {}", results);
		if (results.hasErrors()) {
			NumeralRequest numRequest = new NumeralRequest();
			model.addAttribute("numRequest", numRequest);
			return "converterroman";
		}

		String response = converterService.convertNumeralToRomanNumber(number.getNumber());

		LOGGER.info("Response: {}", response);
		model.addAttribute("response", response);
		model.addAttribute("messageDisplayRoman", true);
		return "converterroman";
	}

	@GetMapping(value = "/converter/toNumeral")
	public String converterNumeralHome(Model model) {
		RomanRequest romanRequest = new RomanRequest();
		model.addAttribute("romanRequest", romanRequest);
		return "converternumeral";
	}

	@PostMapping(value = "/converter/toNumeral")
	public String convertRomanToNumeral(@ModelAttribute("romanRequest") @Valid RomanRequest romanExpression,
			BindingResult results, Model model) {
		LOGGER.info("Request:  {}", romanExpression);
		LOGGER.error("Errors: {}", results);
		if (results.hasErrors()) {
			RomanRequest romanRequest = new RomanRequest();
			model.addAttribute("romanRequest", romanRequest);
			return "converternumeral";
		}

		int response = converterService.convertRomanToNumericNumber(romanExpression.getRomanExpression());

		LOGGER.info("Response: {}", response);
		model.addAttribute("response", response);
		model.addAttribute("messageDisplayNumeral", true);
		return "converternumeral";
	}
}
