package sia.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacos.Order;
import sia.tacos.User;
import sia.tacos.data.OrderRepository;

import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
@Slf4j
public class OrderController {
    private OrderRepository orderRepo;
    public OrderController(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }
    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal User user, @ModelAttribute Order order){
        //model.addAttribute("order", new Order());
        if (order.getDeliveryName() == null){
            order.setDeliveryName(user.getFullname());
        }
        if (order.getDeliveryStreet() == null){
            order.setDeliveryStreet(user.getStreet());
        }
        if (order.getDeliveryCity() == null) {
            order.setDeliveryCity(user.getCity());
        }
        if (order.getDeliveryState() == null) {
            order.setDeliveryState(user.getState());
        }
        if (order.getDeliveryZip() == null) {
            order.setDeliveryZip(user.getZip());
        }
            order.setPrice(order.summary());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderForm";
        }
        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
