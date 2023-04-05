package com.hsy.controller;

import com.hsy.pojo.User;
import com.hsy.pojo.UserLike;
import com.hsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/2
 * @Description: com.hsy.controller
 * @version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService service;
    /* 根据用户的id查询用户的信息 */
    @RequestMapping("/findUserById")
    @ResponseBody
    public String findUserById(){
        User user = service.selectUserById(2);
        System.out.println(user);
        return user.toString();
    }

    /* 根据用户的姓名模糊查询用户的信息 */
    @RequestMapping("/findUsersByName")
    @ResponseBody
    public List<User> findUsersByName(){
        List<User> users = service.selectUsersByName("%张%");
        users.forEach(System.out::println);
        return users;
    }

    /*  插入用户信息 */
    @RequestMapping("/insertUser")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public String insertUserInfo(){
        User user = new User(5,"赵六",new Date(),"南京");
        service.insertUserInfo(user);
        return "用户添加成功！";
    }

    /* 更新用户信息 */
    @RequestMapping("/updateUser")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public String updateUserInfo(){
        User user = new User(5,"小明",new Date(),"福建");
        service.updateUserInfo(user);
        return "用户更新成功！";
    }

    /* 删除用户信息 */
    @RequestMapping("/deleteUser")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public String deleteUserInfo(){
        service.deleteUserInfo(5);
        return "用户删除成功！";
    }

    /* 按照用户的姓名模糊或者地址模糊查询用户的信息 */
    @RequestMapping("/findUserByNameOrAddrLike")
    @ResponseBody
    public List<User> findUserByNameOrAddrLikeInfo(){
        UserLike userLike = new UserLike("%张%","%北%");
        List<User> uboas = service.findUserByNameOrAddrLikeInfo(userLike);
        uboas.forEach(System.out::println);
        return uboas;
    }

    /* 按照用户的姓名模糊或者地址模糊查询用户的数量 */
    @RequestMapping("/findUserByCount")
    @ResponseBody
    public String findUserByCount(){
        UserLike userLike = new UserLike("%张%","%北%");
        int count = service.findUserByCount(userLike);
        System.out.println("用户的数量为:" + count);
        return "用户的数量为:" + count;
    }

    /* 按照多个ID查询用户的信息 */
    @RequestMapping("/findUserByIds")
    @ResponseBody
    public List<User> findUserByIdsInfo(){
        UserLike userLike = new UserLike();
        List<Integer> list = Arrays.asList(1, 2, 3);
        userLike.setIds(list);
        List<User> userByIdsInfo = service.findUserByIdsInfo(userLike);
        userByIdsInfo.forEach(System.out::println);
        return userByIdsInfo;
    }
}
