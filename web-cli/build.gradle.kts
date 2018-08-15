plugins {
    application
}

group = "xyz.twocucao.mermaids.web-cli"
version = "1.0"

application {
    mainClassName = "cli.Main"
}

dependencies {
    compile("mermaids:web-core:1.0")
}

repositories {
    jcenter()
}
