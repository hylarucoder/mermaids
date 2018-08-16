package xyz.twocucao.mermaids.core

import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
//@EnableDiscoveryClient
//@EnableCircuitBreaker
class BlogApplication: SpringBootServletInitializer(){
//    companion object {
//        @JvmStatic fun main(args: Array<String>) {
//            SpringApplication.run(BlogApplication::class.java, *args)
//        }
//    }
}

fun main(vararg args: String) {
    SpringApplication.run(BlogApplication::class.java, *args)
}


