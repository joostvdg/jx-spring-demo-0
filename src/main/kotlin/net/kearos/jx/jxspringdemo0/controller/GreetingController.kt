package net.kearos.jx.jxspringdemo0.controller

import net.kearos.jx.jxspringdemo0.model.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @GetMapping("/greeting")
    fun greetings(): Greeting {
        return Greeting("Greetings")
    }

    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "Hello world"
    }
}