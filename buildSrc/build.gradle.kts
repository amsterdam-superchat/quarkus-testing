import java.io.FileInputStream
import java.util.Properties

val props = Properties()
FileInputStream(file("../gradle.properties")).use {
    props.load(it)
}

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    val kotlinVersion = props.getProperty("kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")

    val quarkusVersion = props.getProperty("quarkusVersion")
    implementation("io.quarkus:gradle-application-plugin:${quarkusVersion}")
}
