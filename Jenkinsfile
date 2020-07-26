node {

    stage("checkout repo") {
    git branch: "master",
    credentialsId: "10fa4ef4-3e2c-42af-875a-3d5e222f89ee",
    url: "https://github.com/PozhidaevYury/SelenideTests.git"
    }

    stage("build") {
        sh "./gradlew clean api-test:assemble"
    }

    stage("run api tests") {
        sh "./gradlew api-test:test"
    }
}