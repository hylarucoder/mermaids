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


allprojects {

    group = "xyz.twocucao.mermaids"

    version = "1.0"

    repositories {
        jcenter()
        maven { setUrl("https://repo.spring.io/milestone") }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


//tasks {
//    "run" {
//        dependsOn(gradle.includedBuild("web-cli").task(":run"))
//        group = "Application"
//        description = "Runs the :web-cli project :run task"
//    }
//}

//buildscript {
//    val springBootVersion by extra { "2.0.4.RELEASE" }
//    extra["junitVersion"] = "5.0.1"
//    extra["kotlinVersion"] = "1.1.51"
//
//    repositories {
//        jcenter()
//        maven { setUrl("http://repo.spring.io/milestone") }
//    }
//
//    dependencies {
//        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
//        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.1")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.51")
//    }
//}






tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

tasks {

    getByName<BootJar>("bootJar") {
        archiveName = "app.jar"
        mainClassName = "xyz.twocucao.mermaids.core.BlogApplication"
    }

    getByName<BootRun>("bootRun") {
        main = "xyz.twocucao.mermaids.core.BlogApplication"
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


