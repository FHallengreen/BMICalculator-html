package com.example.bmicalculator.Controller;

import com.example.bmicalculator.Model.DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;

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

            double result = (100*100*weight / (height * height));
            result=Math.round(result);

            model.addAttribute("result",result);
            model.addAttribute("userweight", weight);
            model.addAttribute("userheight", height);
            System.out.println(result);
            return "calculation";
        }


}
