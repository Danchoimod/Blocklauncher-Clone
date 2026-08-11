plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.ipaulpro.afilechooser"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.setSrcDirs(listOf("src"))
            res.setSrcDirs(listOf("res"))
        }
    }
}
