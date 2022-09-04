plugins {
    kotlin("multiplatform") version "1.7.10"

}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io")
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()
            commonWebpackConfig {
                sourceMaps = true
                cssSupport.enabled = true
            }
        }
    }
    sourceSets.named("jsMain") {
        dependencies {
            implementation("com.github.romangraef:neamoe:8969cee")
            implementation(npm("@fontsource/comic-mono", "^4.5.0"))
        }
    }
}




