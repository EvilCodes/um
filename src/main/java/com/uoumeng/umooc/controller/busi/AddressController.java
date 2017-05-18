package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.entity.Address;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/5/18.
 * 待测试
 */
@Controller
@RequestMapping(value = "/student")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/selectAddressById", method = RequestMethod.GET)
    private @ResponseBody
    Result selectAddressById(@RequestParam("id") Integer id) {
        try {
            Address address = addressService.selectById(id);
            Map<String, Address> map = new HashMap<>();
            map.put("address", address);
            return new Result(true, map);
        } catch (MyException e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/selectAddressByStuId", method = RequestMethod.GET)
    private @ResponseBody
    Result selectAddressByStuId(HttpServletRequest request) {
        try {
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            List<Address> addressList = addressService.selectAddressByStuId(token.getId());
            Map<String, List<Address>> map = new HashMap<>();
            map.put("address", addressList);
            return new Result(true, map);
        } catch (MyException e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
    private @ResponseBody
    Result deleteAddress(@RequestParam("id") Integer id, HttpServletRequest request) {
        try {
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            boolean flag = addressService.deleteById(id,token.getId());
            return new Result(true, flag);
        } catch (MyException e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    private @ResponseBody
    Result updateAddress(@RequestParam("address") Address address) {
        try {
            boolean flag = addressService.updateAddress(address);
            return new Result(true, flag);
        } catch (MyException e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/insertAddress", method = RequestMethod.POST)
    private @ResponseBody
    Result insertAddress(@RequestParam("address") Address address) {
        try {
            boolean flag = addressService.insertAddress(address);
            return new Result(true, flag);
        } catch (MyException e) {
            return new Result(false, e.getMessage());
        }
    }
}
