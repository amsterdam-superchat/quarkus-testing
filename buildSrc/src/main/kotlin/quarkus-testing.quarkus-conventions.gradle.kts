import java.io.FileInputStream
import java.util.Properties

val props = Properties()
FileInputStream(file("../../gradle.properties")).use {
    props.load(it)
}
val quarkusVersion = props.getProperty("quarkusVersion")

plugins {
    id("quarkus-testing.global-conventions")
    id("io.quarkus")
    kotlin("plugin.allopen")
}

allOpen {
    annotation("io.quarkus.test.junit.QuarkusTest")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("javax.ws.rs.Path")
}

dependencies {
    implementation(enforcedPlatform("io.quarkus:quarkus-universe-bom:${quarkusVersion}"))
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-smallrye-openapi")
    implementation("io.quarkus:quarkus-smallrye-health")
}

testing {
    suites {
        val integrationTest by registering(JvmTestSuite::class) { 
            useJUnitJupiter("5.8.2")
            dependencies {
                implementation("io.quarkus:quarkus-junit5:${quarkusVersion}")
            }
        }
    }
}
