package g2.controller.admin;

import g2.model.Card;
import g2.model.Usertype;
import g2.service.CardService;
import g2.service.UsertypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/card")
public class CardController {
    private final CardService cardService;
    private final UsertypeService usertypeService;

    public CardController(CardService cardService, UsertypeService usertypeService) {
        this.cardService = cardService;
        this.usertypeService = usertypeService;
    }


    @RequestMapping("")
    public String indexCard(Model model, Long id, String type) {
        List<String> list = usertypeService.selectType();
        List<Card> card = cardService.selectByIT(id, type);
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("list", list);
        model.addAttribute("card", card);
        return "admin/indexCard";
    }

    @RequestMapping("/update")
    public String change(Model model, Long id, String state) {
        cardService.updateByType(id, state);
        model.addAttribute("id", id);
        return "redirect:/admin/card";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "admin/cardInsert";
    }

    @RequestMapping("/insertDo")
    @ResponseBody
    public String insertDo(Long id, String type, String state, Double amount, Double limit) {
        Card card = new Card(null, type, state, amount, limit);
        Usertype usertype = new Usertype(type);
        int n = cardService.insertById(usertype, card);
        return n > 0 ? "success" : "failed";
        //return "redirect:/admin/card";
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public String reCharge(Model model, Long id, Double amount) {
        model.addAttribute("id",id);
        model.addAttribute("amount", amount);
        return "admin/cardRecharge";
    }

    @RequestMapping("/rechargeDo")
    @ResponseBody
    public String reChargeDo(Model model, Long id, Double money) {
        model.addAttribute("id", id);
        int n = cardService.reCharge(id, money);
        return n > 0 ? "success" : "failed";
        // return "redirect:/admin/card/";
    }

    @RequestMapping("/support")
    public String reCharge(Model model) {
        List<String> list = usertypeService.selectType();
        model.addAttribute("list", list);
        return "admin/cardSupport";
    }

    @RequestMapping("/supportDo")
    @ResponseBody
    public String supportDo(Model model, String type, Double money) {
        model.addAttribute("type", type);
        int n = cardService.support(type, money);
        return n > 0 ? "success" : "failed";
        //  return "redirect:/admin/card/";
    }


}
