//includeBuild("web-core") {
//    dependencySubstitution {
//        substitute(module("mermaids:web-core")).with(project(":"))
//    }
//}
includeBuild("web-core")
includeBuild("web-cli")
includeBuild("web-utils")
rootProject.name = "mermaids"

