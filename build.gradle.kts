plugins {
    id("java-library")
}

group = "de.matthiaslosch.barcode"
version = "0.1.0"

repositories {
    mavenCentral()
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
