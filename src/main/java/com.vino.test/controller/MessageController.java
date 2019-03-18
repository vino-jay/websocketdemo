package com.vino.test.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.GsonBuilder;
import com.vino.test.entity.NbaPlayer;
import com.vino.test.entity.WebSocketMsg;
import com.vino.test.websocket.SpringWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

/**
 * @ClassName: MessageController
 * @Description: message组件
 * @author: wenjie.fei
 * @date: 2019/1/5 10:37
 * @version: V1.0
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Resource
    private SpringWebSocketHandler handler;

    Map<Long, NbaPlayer> nbaPlayers = new HashMap<>();

    // 模拟一些数据
    @ModelAttribute
    public void setReqAndRes() {
        NbaPlayer kebe = new NbaPlayer();
        kebe.setId(24L);
        kebe.setName("科比");
        nbaPlayers.put(kebe.getId(), kebe);

        NbaPlayer james = new NbaPlayer();
        james.setId(23L);
        james.setName("詹姆斯");
        nbaPlayers.put(james.getId(), james);

    }

    // 用户登录
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView doLogin(NbaPlayer player, HttpServletRequest request) {
        request.getSession().setAttribute("uid", player.getId());
        request.getSession().setAttribute("name", nbaPlayers.get(player.getId()).getName());
        return new ModelAndView("redirect:talk");
    }

    // 跳转到交谈聊天页面
    @RequestMapping(value = "talk", method = RequestMethod.GET)
    public ModelAndView talk() {
        return new ModelAndView("talk");
    }

    // 跳转到发布广播页面
    @RequestMapping(value = "broadcast", method = RequestMethod.GET)
    public ModelAndView broadcast() {
        return new ModelAndView("broadcast");
    }

    // 发布系统广播（群发）
    @ResponseBody
    @RequestMapping(value = "broadcast", method = RequestMethod.POST)
    public void broadcast(@RequestBody String text) throws IOException {
        WebSocketMsg msg = new WebSocketMsg();
        msg.setDate(new Date());
        msg.setFrom(-1L);
        msg.setFromName("系统广播");
        msg.setTo(0L);
        msg.setText(text);
        handler.broadCast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
    }

}
