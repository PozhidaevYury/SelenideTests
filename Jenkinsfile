node {

    stage("checkout repo") {
    git branch: "master",
    credentialsId: "6e59f8a1-06fa-482e-b30b-6f93aafcc9df",
    url: "https://github.com/PozhidaevYury/SelenideTests.git"
    }

    stage("build") {
        sh "./gradlew clean api-test:assemble"
    }

    stage("run api tests") {
        sh "./gradlew api-test:test"
    }

    allure([
        includeProperties: false,
        jdk: "",
        properties: [],
        reportBuildPolicy: "ALWAYS",
        results: [[path: 'api-test/build/allure-results']]
        ])
}