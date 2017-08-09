package com.tgorgics.instaprofilepic.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgorgics.instaprofilepic.util.InstaProfilePicUtils;
import com.tgorgics.instaprofilepic.web.dto.UserDTO;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/getPicture", method = RequestMethod.POST)
    public String getPic(@ModelAttribute("user") final UserDTO user, final Model model) {
        final String url = InstaProfilePicUtils.assembleUrl(user.getUserName());

        if ("".equals(url) || null == url) {
            return "error/url_error";
        }
        model.addAttribute("url", url);

        return "picture :: profilePicture";
    }

    @ModelAttribute("user")
    public UserDTO getUserObject() {
        return new UserDTO();
    }
}
