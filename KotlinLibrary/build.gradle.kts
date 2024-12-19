plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
	id("maven-publish")
}

android {
	namespace = "com.fpacheco.kotlin.library"
	compileSdk = 34

	defaultConfig {
		minSdk = 25

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)

	implementation("com.google.code.gson:gson:2.11.0")
}

afterEvaluate {
	publishing {
		publications {
			create<MavenPublication>("release") {
				from(components["release"])

				groupId = "com.github.ferpachecocanul"
				artifactId = "kotlin-library"
				version = "1.0"
			}
		}
	}
}