plugins {
    `java-library`
    groovy
    kotlin("jvm")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.javaParameters = true
    }
}

testing {
    suites { 
        val test by getting(JvmTestSuite::class) { 
            useSpock()
        }
    }
}
