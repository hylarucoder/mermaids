includeBuild("web-core") {
    dependencySubstitution {
        substitute(module("mermaids:web-core")).with(project(":"))
    }
}
includeBuild("web-cli")
includeBuild("web-utils")
