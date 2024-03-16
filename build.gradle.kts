plugins {
    kotlin("jvm") version "1.9.22"
    `maven-publish`
}

group = "world.avionik"
version = "1.0.1"

repositories {
    mavenCentral()

    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(kotlin("stdlib"))

    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    testCompileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}

publishing {
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])

            groupId = project.group as String?
            artifactId = project.name
            version = project.version.toString()
        }
    }
}