tasks {
    "run" {
        dependsOn(gradle.includedBuild("web-cli").task(":run"))
        group = "Application"
        description = "Runs the :web-cli project :run task"
    }
}

repositories {
    jcenter()
}
