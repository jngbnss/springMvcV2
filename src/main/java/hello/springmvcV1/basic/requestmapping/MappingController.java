package hello.springmvcV1.basic.requestmapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello-basic")
public class MappingController {

    @GetMapping
    @RequestMapping("/hello-basic")
    public String helloBasic(){
        return "잘나오는지 화면에 표시";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        return "너의 아이디는 "+data;
    }
}
