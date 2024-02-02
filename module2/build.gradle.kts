plugins {
    id("application")
}

application {
    mainClass = "com.example.module2.Main"
}

dependencies {
    implementation(project(":module1"))
}
