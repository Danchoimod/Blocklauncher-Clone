plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "net.zhuoweizhang.mcpelauncher"
    compileSdk = 34

    defaultConfig {
        applicationId = "net.zhuoweizhang.mcpelauncher"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        ndk {
            abiFilters.addAll(setOf("armeabi-v7a", "x86"))
        }

        externalNativeBuild {
            cmake {
                cppFlags("")
            }
        }
    }

    buildFeatures {
        buildConfig = true
    }

    useLibrary("org.apache.http.legacy")

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":afilechooser"))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.github.chainfire:libsuperuser:1.1.1")
}
