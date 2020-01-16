package rw.babyl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	@GetMapping(value = "/")
	public String homepage() {
		return "index";
	}
}
