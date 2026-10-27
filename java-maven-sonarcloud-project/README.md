# Java Maven + Jenkins + SonarQube Cloud Demo

A small Java 17 Maven project for practicing a Jenkins CI/CD pipeline with SonarQube Cloud analysis.

## Project contents

- `src/main/java/com/example/Calculator.java` — sample Java application.
- `src/test/java/com/example/CalculatorTest.java` — JUnit 5 unit tests.
- `pom.xml` — Maven dependencies, build, tests, JaCoCo coverage and Sonar scanner.
- `Jenkinsfile` — pipeline for checkout, build/test, SonarCloud scan, quality gate and artifact archiving.

## Requirements

- JDK 17
- Maven 3.8 or newer
- A GitHub repository containing this project
- A SonarQube Cloud account and project
- Jenkins with Pipeline, Git, SonarQube Scanner for Jenkins, and JUnit plugins

## Run locally

From this directory:

```bash
mvn clean verify
```

The JAR should be created under `target/`. The JaCoCo XML report should be at `target/site/jacoco/jacoco.xml`.

## Configure SonarQube Cloud

1. Sign in at https://sonarcloud.io/ and import this GitHub repository.
2. Open the SonarQube Cloud project and copy the exact **Project Key** and **Organization Key**.
3. Replace `REPLACE_WITH_YOUR_SONARCLOUD_PROJECT_KEY` and `REPLACE_WITH_YOUR_SONARCLOUD_ORGANIZATION` in both `pom.xml` properties and the `Jenkinsfile`.
4. In Jenkins, add the SonarQube Cloud token as a secret credential. Configure **Manage Jenkins → System → SonarQube servers** with:
   - Name: `SonarCloud`
   - Server URL: `https://sonarcloud.io`
   - Authentication token: the credential you added
5. In **Manage Jenkins → Tools**, configure JDK name `JDK17` and Maven name `Maven3`, or update the Jenkinsfile to match your existing tool names.
6. Add a SonarQube Cloud webhook pointing to `https://YOUR-JENKINS-URL/sonarqube-webhook/` if Jenkins must wait for the Quality Gate. Jenkins must be reachable by SonarQube Cloud.
7. Push the project to GitHub, create a Jenkins Pipeline job using **Pipeline script from SCM**, select Git, provide the repository URL, and set Script Path to `Jenkinsfile`.

## About the 80% quality gate

The Jenkinsfile waits for the Quality Gate configured in SonarQube Cloud; it does not itself define an 80% rule. Configure the relevant condition in your SonarQube Cloud Quality Gate if your course requires an 80% threshold. For example, `Coverage on New Code` is a different metric from overall coverage.

## Important notes

- Never commit your SonarQube Cloud token to GitHub or put it in this file.
- This pipeline uses Linux shell commands (`sh`). For a Windows Jenkins agent, replace them with suitable `bat` commands.
- The `JDK17` and `Maven3` names must match Jenkins tool configuration.
