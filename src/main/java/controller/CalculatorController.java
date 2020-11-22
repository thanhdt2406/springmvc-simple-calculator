package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @PostMapping
    public ModelAndView calculate(Model model, @RequestParam(defaultValue = "0") Double num1, @RequestParam(defaultValue = "0") Double num2, @RequestParam String opera) {
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        double result = 0;
        switch (opera) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    return new ModelAndView("index", "result", "Error!");
                }
                result = num1 * 1.0 / num2;
                break;
        }
        return new ModelAndView("index", "result", result);
    }
}
