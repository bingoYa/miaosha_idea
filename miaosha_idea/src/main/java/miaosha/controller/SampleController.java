package miaosha.controller;

import miaosha.result.CodeMsg;
import miaosha.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//这个标签是结点标签的标识，结点主要用于传值和跳转页面
@RequestMapping("/demo")//路径
public class SampleController {

    @RequestMapping("/thymeleaf")//当访问localhost：8080是默认的就会跳转到hello页面，通过映射来找到页面
    public String thymeleaf(Model model){//用model传递参数
        model.addAttribute("name","Joshua");//model里传了一个变量,name是传入前端的标识
        return "hello";
    }

    //1.rest api json输出2.集成thymeleaf做页面模板
    @RequestMapping("hello")
    @ResponseBody
    public Result<String> hello(){
        return Result.success("hello,imooc");
        //return new Result(0,"SUCCESS","hello,imooc");
    }

    @RequestMapping("helloError")
    @ResponseBody
    public Result<String> helloError(){
        return Result.error(CodeMsg.SERVER_ERROR);//封装对象
        //return new Result(500100,"session失效“);
        //return new Result(500101,"xxx“);
        //return new Result(500102,"xxxx“);
    }
}
