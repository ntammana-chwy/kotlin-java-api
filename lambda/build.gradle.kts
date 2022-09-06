plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
    id("io.micronaut.library") version "3.4.1"
}

version = "0.0.1"
group = "com.learning"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    compileOnly("org.projectlombok:lombok:1.18.24")
    implementation("org.projectlombok:lombok:1.18.24")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.20")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.aws:micronaut-function-aws-test")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("io.projectreactor:reactor-core:3.4.22")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
