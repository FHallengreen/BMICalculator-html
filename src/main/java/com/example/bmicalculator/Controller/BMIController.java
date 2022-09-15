package com.example.bmicalculator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BMIController {

    @GetMapping("/")
        public String frontpage(){
        return "/frontpage";
        }


        @PostMapping("/calculate")
    public String calculateBMI(@RequestParam("userweight") double weight, @RequestParam("userheight") int height, RedirectAttributes attributes){
        attributes.addAttribute("userweight", weight);
        attributes.addAttribute("userheight", height);
            return "redirect:/calculate";
        }

        @GetMapping("/calculate")
        public String calculationPage(@RequestParam("userweight") double weight, @RequestParam("userheight") int height, Model model){

            double bmi = (10000*weight / (height * height));
            bmi =Math.round(bmi);

            model.addAttribute("result", bmi);
            model.addAttribute("userweight", weight);
            model.addAttribute("userheight", height);
            System.out.println(bmi);
            return "calculation";
        }


}
