plugins {
    checkstyle
    findbugs
    pmd
    jdepend
    jacoco
    application
    kotlin("jvm") version "1.2.60"
}

application {
    mainClassName = "xyz.twocucao.mermaids.common.BlogApplication"
}

group = "xyz.twocucao.mermaids"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}



checkstyle {
    configFile = file("config/checkstyle/sun_checks.xml")
    isIgnoreFailures = true
}

findbugs {
    isIgnoreFailures = true
}

pmd {
    isIgnoreFailures = true
}

jdepend {
    isIgnoreFailures = true
}

jacoco {
    toolVersion = "0.7.9"
}

tasks {
    "jacocoTestCoverageVerification"(JacocoCoverageVerification::class) {
        violationRules {
            rule { limit { minimum = BigDecimal.valueOf(0.2) } }
        }
        val check by tasks
        check.dependsOn(this)
    }
}

dependencies {
    compile(kotlin("stdlib"))

    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-mustache")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")

    testCompile("junit:junit:4.12")
}

repositories {
    jcenter()
}
