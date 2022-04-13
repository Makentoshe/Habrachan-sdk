@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform") version "1.6.10"
    id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

group = "com.makentoshe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        source = objects.fileCollection().from(
            io.gitlab.arturbosch.detekt.extensions.DetektExtension.DEFAULT_SRC_DIR_JAVA,
            io.gitlab.arturbosch.detekt.extensions.DetektExtension.DEFAULT_TEST_SRC_DIR_JAVA,
            io.gitlab.arturbosch.detekt.extensions.DetektExtension.DEFAULT_SRC_DIR_KOTLIN,
            io.gitlab.arturbosch.detekt.extensions.DetektExtension.DEFAULT_TEST_SRC_DIR_KOTLIN,
        )
    }

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        jvmTarget = "1.8"
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
    }


    val analysisDir = file(projectDir)
    val configFile = file("$rootDir/detekt.yml")

    val kotlinFiles = "**/*.kt"
    val kotlinScriptFiles = "**/*.kts"
    val resourceFiles = "**/resources/**"
    val buildFiles = "**/build/**"

    val detektFormat by tasks.registering(io.gitlab.arturbosch.detekt.Detekt::class) {
        description = "Formats whole project."
        parallel = true
        disableDefaultRuleSets = true
        buildUponDefaultConfig = true
        autoCorrect = true
        config.setFrom(configFile)
        setSource(analysisDir)
        include(kotlinFiles)
        include(kotlinScriptFiles)
        exclude(resourceFiles)
        exclude(buildFiles)
        reports {
            xml.required.set(true)
            html.required.set(true)
            txt.required.set(true)
        }
    }

    val detektAll by tasks.registering(io.gitlab.arturbosch.detekt.Detekt::class) {
        description = "Runs the whole project at once."
        parallel = true
        buildUponDefaultConfig = true
        config.setFrom(configFile)
        setSource(analysisDir)
        include(kotlinFiles)
        include(kotlinScriptFiles)
        exclude(resourceFiles)
        exclude(buildFiles)
        reports {
            xml.required.set(true)
            html.required.set(true)
            txt.required.set(true)
        }
    }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(BOTH) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                // Ktor client - http multiplatform client
                // https://github.com/ktorio/ktor
                implementation("io.ktor:ktor-client-core:2.0.0")
                implementation("io.ktor:ktor-client-cio:2.0.0")
            }
        }
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}
