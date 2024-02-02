import org.gradle.crypto.checksum.Checksum
import java.util.Properties

plugins {
    id("java-library")
    id("org.gradle.crypto.checksum") version "1.4.0"
}

tasks.processResources {
    val inputFile = file("my-filter-values.properties")
    inputs.file(inputFile)
    filesMatching("**") {
        val properties = Properties()
            .apply {
                inputFile.inputStream().use {
                    load(it)
                }
            }
            .mapKeys { it.key as String }
        expand(properties)
    }
}

//val jar = tasks.getByName("jar")
val jar by tasks.getting

val createChecksums by tasks.registering(Checksum::class) {
    dependsOn(jar)
    inputFiles = jar.outputs.files
    // outputDirectory = layout.buildDirectory.dir("hash")
}

jar.finalizedBy(createChecksums)
