package com.school.school.controller;


import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubjectDto;
import com.school.school.dto.SubscriptionDto;
import com.school.school.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("subscription")
@Controller
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping("/")
    public String addSubscription(Model model) {
        model.addAttribute("subscription", subscriptionService.fetchSubscription());
        return "subscription_list";
    }


    @GetMapping("/insertPage")
    public String getInsertPage(){return "subscription_form";}


    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveSubscription(@RequestBody SubscriptionDto subscriptionDto){
        return subscriptionService.addSubscription(subscriptionDto);
    }


    @GetMapping("/activate")
    @ResponseBody
    public ResponseDto activateSubscription(@RequestParam int id){return subscriptionService.activateSubscription(id);}

    @GetMapping("deactivate")
    @ResponseBody
    public ResponseDto deactivateSubscription(@RequestParam int id){return subscriptionService.deactivateSubscription(id);}


    @PostMapping("/update")
    @ResponseBody
    public ResponseDto update(@RequestBody SubscriptionDto subscriptionDto) {
        return subscriptionService.update(subscriptionDto);
    }

    @GetMapping("/getUpdateData")
    public String getSubscriptionData(@RequestParam int id, Model model) {
        model.addAttribute("subscription", subscriptionService.getSubscriptionData(id).getData());
        return "subscription_form";
    }




}
