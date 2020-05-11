plugins {
    kotlin("jvm") version "1.3.72"
    id("com.github.johnrengelman.shadow") version "5.0.0"
    id("application")
}

application {
    mainClassName = "br.com.itidigitalchallenge.application.ITIDigitalChallengeApplicationKt"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.koin:koin-ktor:2.0.1")
    implementation("io.ktor:ktor-jackson:1.2.6")
    implementation("io.ktor:ktor-server-netty:1.2.6")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.2")
    implementation("com.github.kittinunf.fuel:fuel:2.2.0")

    testImplementation("junit:junit:4.13")
    testImplementation("org.assertj:assertj-core:3.11.1")

    api("ch.qos.logback:logback-classic:1.2.3")
}

tasks {
    shadowJar {
        manifest {
            attributes(mapOf("Main-Class" to "io.ktor.server.netty.EngineMain"))
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
