import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    base
    application
    idea
    eclipse

//    id("io.spring.dependency-management")
    id("org.springframework.boot") version "2.0.4.RELEASE"
    kotlin("jvm") version "1.2.60"
}

group = "xyz.twocucao.mermaids.core"
version = "1.0"

application {
    mainClassName = "xyz.twocucao.mermaids.cli.CliKt"
}

repositories {
    jcenter()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

tasks {

    getByName<BootJar>("bootJar") {
        archiveName = "app.jar"
        mainClassName = "xyz.twocucao.mermaids.core.BlogApplicationKt"
    }

    getByName<BootRun>("bootRun") {
        main = "xyz.twocucao.mermaids.core.BlogApplicationKt"
        args("--spring.profiles.active=demo")
    }
}

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
    compile("org.springframework.boot:spring-boot-starter-web:2.0.4.RELEASE")
    compile("org.springframework.boot:spring-boot-starter-data-jpa:2.0.4.RELEASE")
    compile("org.springframework.boot:spring-boot-starter-web:2.0.4.RELEASE")
    compile("org.springframework.boot:spring-boot-starter-mustache:2.0.4.RELEASE")
//    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    testCompile("org.springframework.boot:spring-boot-starter-test:2.0.4.RELEASE")
    subprojects.forEach {
        archives(it)
    }
    testCompile("junit:junit:4.12")
}

