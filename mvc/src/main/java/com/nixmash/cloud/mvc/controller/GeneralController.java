package com.nixmash.cloud.mvc.controller;

import com.nixmash.cloud.mvc.io.PostReader;
import com.nixmash.cloud.mvc.ui.WebUI;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    // region Constants

    public static final String HOME_VIEW = "home";

    // endregion

    // region Beans

    private final WebUI webUI;
    private final PostReader postReader;

    public GeneralController(WebUI webUI, PostReader postReader) {
        this.webUI = webUI;
        this.postReader = postReader;
    }

    // endregion

    @GetMapping(value = "/")
    public String home(Model model) {
        String springVersion = webUI.parameterizedMessage("spring.version",
                SpringBootVersion.getVersion(), SpringVersion.getVersion());
        model.addAttribute("springVersion", springVersion);
        model.addAttribute("posts", postReader.recent().getContent());
        return HOME_VIEW;
    }
}
