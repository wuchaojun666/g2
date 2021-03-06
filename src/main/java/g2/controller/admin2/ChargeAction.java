package g2.controller.admin2;

import g2.model.Card;
import g2.model.Charge;
import g2.model.Machine;
import g2.service.CardService;
import g2.service.ChargeService;
import g2.service.MachineService;
import g2.service.UserService;
import g2.util.Parse;
import g2.util.Properites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
@RequestMapping("admin2/charge")
public class ChargeAction {
    private final MachineService machineService;
    private final CardService cardService;
    private final UserService userService;
    private final ChargeService chargeService;

    @Autowired
    public ChargeAction(MachineService machineService, CardService cardService, UserService userService, ChargeService chargeService) {
        this.machineService = machineService;
        this.cardService = cardService;
        this.userService = userService;
        this.chargeService = chargeService;
    }

    @RequestMapping(value = "mac", params = "macID", method = RequestMethod.POST)
    public ModelAndView mac(Long macID) {
        Machine mac = machineService.selectByPrimaryKey(macID);
        if (mac == null || mac.getId() == null) return new ModelAndView("redirect:/admin2/charge");
        ModelAndView modelAndView = new ModelAndView("admin2/chargeAction/machine");
        modelAndView.addObject("mac", mac);
        return modelAndView;
    }

    @RequestMapping("scan")
    public String scanner() {
        return "admin2/chargeAction/scan";
    }

    @RequestMapping("popMsg")
    public ModelAndView popUpMsg(String pMsg) {
        ModelAndView modelAndView = new ModelAndView("admin2/chargeAction/message");
        modelAndView.addObject(new JSONMsg.PlainMessage(pMsg).toString());
        return modelAndView;
    }

    /**
     * decode Base64 to JSON
     *
     * @param str Base64 String
     * @return JSONMsg
     */
    @RequestMapping("decodeIF")
    public JSONMsg decode(String str) {
        return new JSONMsg(Parse.decodeBase64JSON(str));
    }

    /**
     * 接口：从单位ID获取machine
     *
     * @param id 单位ID
     * @return JSON消息
     */
    @RequestMapping(value = "macListIF", method = RequestMethod.POST)
    public JSONMsg macList(Long id) {
        return new JSONMsg(machineService.getMachineByUnit(id));
    }

    /**
     * 接口：产生收费记录
     *
     * @param cardID 卡号
     * @param macID  刷卡机号
     * @param amount 金额
     * @return 收费信息
     */
    @RequestMapping(value = "chargeIF", method = RequestMethod.POST, params = {"cardID", "macID", "amount", "name"})
    public JSONMsg charge(Long cardID, Long macID, Double amount, String name) {
        if (!userService.getNameByCardID(cardID).equals(name)) return new JSONMsg("Err:扫描出错,请重新扫码");
        machineService.selectByPrimaryKey(macID);//确保刷卡机没被删除
        Charge charge = new Charge();
        Card card = cardService.get(cardID);
        charge.setCar_id(cardID);
        charge.setMac_id(macID);
        charge.setName(userService.getNameByCardID(cardID));
        charge.setAmount(amount);
        charge.setTime(new Date());
        //检查卡状态
        if (card.getState().equals(Properites.CardStatus.frozen)) {
            charge.setReason(Properites.ErrorMessages.Report_Loss);
            charge.setResult(Properites.Result.failed);
            chargeService.add(charge);
            return new JSONMsg(charge);
        }
        //检查余额
        if (card.getAmount() < amount) {
            charge.setReason(Properites.ErrorMessages.Insufficient_Balance);
            charge.setResult(Properites.Result.failed);
            chargeService.add(charge);
            return new JSONMsg(charge);
        }

        //检查消费限制
        if (card.getLimit() < amount) {
            charge.setReason(Properites.ErrorMessages.Exceed_Limit);
            charge.setResult(Properites.Result.failed);
            chargeService.add(charge);
            return new JSONMsg(charge);
        }

        //扣费
        card.setAmount(card.getAmount() - amount);
        if (cardService.update(card) > 0)
            charge.setResult(Properites.Result.success);
        else {
            charge.setResult(Properites.Result.failed);
            charge.setReason(Properites.ErrorMessages.DBERROR);
        }
        chargeService.add(charge);
        return new JSONMsg(charge);
    }
}
