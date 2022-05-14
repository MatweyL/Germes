package com.example.germes.controller;

import com.example.germes.entity.UserOrder;
import com.example.germes.repo.UserOrderRepository;
import com.example.germes.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Controller
@RequestMapping(value = "/user_order")
public class UserOrderController {

    @Autowired
    private final UserOrderService userOrderService;

    public UserOrderController(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }

    @GetMapping({"/list", "/"})
    private ModelAndView getAllUserOrders() {
        ModelAndView mav = new ModelAndView("user/list-user-orders");
        mav.addObject("userOrders", userOrderService.findAll());
        return mav;
    }

    @GetMapping("/addUserOrderForm")
    private ModelAndView addUserOrderForm() {
        ModelAndView mav = new ModelAndView("user/add-user-order-form");
        UserOrder newUserOrder = new UserOrder();
        mav.addObject("userOrder", newUserOrder);
        return mav;
    }


    //saveUserOrderRedirect
    @RequestMapping(value = "/payUserOrder",method={ RequestMethod.GET, RequestMethod.POST })
    public ModelAndView payUserOrder(@ModelAttribute UserOrder userOrder, @RequestParam(name = "dateTimeString") String dateTimeString,
                                       BindingResult binding, ModelAndView mav,
                                       final RedirectAttributes redirectAttributes) {
        userOrderService.setUserOrderDateOfDispatch(userOrder, dateTimeString);
        userOrderService.setUserOrderDeliveryCost(userOrder);
        redirectAttributes.addFlashAttribute("userOrder", userOrder);
        mav.setViewName("user/user-order-payment");
        return mav;
    }

    @PostMapping("/saveUserOrder")
    private String saveUserOrder(@ModelAttribute UserOrder userOrder) {
        userOrderService.setIsClosedUserOrder(userOrder, false);
        userOrderService.save(userOrder);
        return "redirect:list";
    }

    @GetMapping("/showUserOrderDetails")
    private ModelAndView showUserOrderDetails(@RequestParam Long userOrderId) {
        ModelAndView mav = new ModelAndView("user/user-order-details");
        UserOrder userOrder = userOrderService.getById(userOrderId);
        mav.addObject("userOrder", userOrder);
        return mav;
    }

}
