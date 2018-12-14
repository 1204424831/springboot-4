package com.baizhi.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/query")
    public String test(HttpSession session){
        List<User> list=userMapper.selectAll();
        session.setAttribute("list",list);
        System.out.println(list);
        return "index";
    }
}
