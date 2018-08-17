package xyz.twocucao.mermaids.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
//@EnableDiscoveryClient
//@EnableCircuitBreaker
class BlogApplication : SpringBootServletInitializer()

fun main(vararg args: String) {
    SpringApplication.run(BlogApplication::class.java, *args)
}


