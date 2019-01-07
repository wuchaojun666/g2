package g2.controller.auth;

import g2.model.UserKey;
import g2.service.LoginService;
import g2.util.properties.SessionProperties;
import g2.util.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Auth {
    private final
    LoginService loginService;

    @Autowired
    public Auth(LoginService loginService) {
        this.loginService = loginService;
    }


    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "index";
    }

    @RequestMapping("/login")
    public String doLogin(UserKey userKey, HttpServletRequest request) {
        if (loginService.chkLogin(userKey)) {
            UserSession session = new UserSession(userKey);
            session.setSession(request);
            return UserProperties.typeString[session.getType()];
        } else System.out.println(false);
        return "404";
    }

    @RequestMapping("/logout")
    public String doLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(SessionProperties.state);
        request.getSession().removeAttribute(SessionProperties.name);
        request.getSession().removeAttribute(SessionProperties.type);
        request.getSession().invalidate();
        return "index";
    }
}
