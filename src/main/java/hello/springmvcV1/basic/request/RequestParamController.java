package hello.springmvcV1.basic.request;

import hello.springmvcV1.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        response.getWriter().write("ok");
    }
    //이건 그냥 서블릿으로 한거
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        return "요청 파라미터로 받는 v2"+memberName+memberAge;
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        return "요청 파라미터로 받는 v2"+username +age;
    }
    // 리퀘스트 파람까지 생략가능
    // 필수, 기본값 설정
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String,Object>paramMap){
        return ""+paramMap.get("username")+""+paramMap.get("age");

    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        return " "+helloData.getUsername()+" "+helloData.getAge();
    }
}
