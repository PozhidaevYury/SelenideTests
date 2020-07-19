node {

    stage("checkout repo") {
    git branch: "master",
    credentialsId: "",
    url: "https://github.com/PozhidaevYury/SelenideTests.git"
    }

    stage("run ui tests") {
        sh "./gradlew ui-test:test -Dlogging=${LOGGING}"
    }

    allure([
    includeProperties false,
    jdk: "",
    properties: [],
    reportBuildPolicy: "ALWAYS",
    results: [[path: 'ui-test/build/allure-results']]
    ])
}