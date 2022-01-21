package ca.sheridancollege.bask.as1.controllers;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.bask.as1.beans.Evaluation;

/**
 * The controller class to handle the requests
 * @author Kubra Bas
 */

@Controller
public class MainController {

	// load the index page
	@GetMapping("/")
	public String goindex() {
		return "index.html";
	}
	
	//load the evaluation page
	@GetMapping("/evalc")
	public String goevals() {
		return "evaluation.html";
	}
	
	
	/* Get the parameters from the form in evaluation.html
	 * Construct an evaluation bean
	 * Add the bean into the model to make it reachable from the output page
	 * Load the output page(evalResults.html)
	 */
	@PostMapping("/evals")
	public String doEval(Model model,
			@RequestParam String title,
			@RequestParam double mark,
			@RequestParam double max,
			@RequestParam double weight,
			@RequestParam
			@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate date) {
		
		//construct an evaluation bean object
		Evaluation eval = new Evaluation(title, mark, max, weight, date);
		
		//add the bean object into the model to make it reachable from the output page
		model.addAttribute("evaluation", eval);
		
		//load the output page(evalResults.html)
		return "evalResults.html";
	}
	
}

