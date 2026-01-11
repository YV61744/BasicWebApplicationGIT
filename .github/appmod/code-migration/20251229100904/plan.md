# Migration Plan: Upgrade to Java 21

- Migration Session ID: 8029dc55-cd26-49ac-b0d9-022bd39e4829
- Plan Creation Time: 2025-12-29 10:09:04
- Uncommitted Changes Policy (vscode config): Always Stash

## Summary
Goal: Upgrade the project `BasicWebApplicationGIT` to use Java 21 (LTS).
Approach: Add Maven build (`pom.xml`) configured for Java 21, install JDK 21 to `C:\Users\Mohan Vamsi\.jdk` if required, update compilation settings, and validate build/tests.

## Scope
- Add a `pom.xml` (Maven) at project root to enable reproducible builds and dependency management.
- Configure compiler to use Java 21 (`maven-compiler-plugin` / `release` 21).
- Add necessary compile-time dependencies (e.g., `javax.servlet-api` scope `provided`) to compile servlets.
- Install JDK 21 into `C:\Users\Mohan Vamsi\.jdk` if not present.
- Run build and validation steps via migration tools.

## Detected project state
- Java sources: `src/main/java/TestServlet.java`, `src/main/java/Helloworld.java`
- No build descriptor found: no `pom.xml` or `build.gradle` in repository root
- System JDKs found: Java 11.0.12 at `C:\Program Files\Java\jdk-11.0.12\bin` (from `JAVA_HOME`)
- No Maven installation detected on system

## Decision: Use Maven
- Reason: Maven is widely used for Java webapps, simple to add (`pom.xml`) and preferred by the automated migration tool.
- Target artifact: war (web application archive)

## JDK Plan
- Detected JDK: Java 11.0.12 (insufficient for target Java 21)
- Need to install JDK 21: YES
- Install path (required): `C:\Users\Mohan Vamsi\.jdk`
- After install, set `JAVA_HOME` in build environment to the JDK 21 path.

## Build tool plan
- Tool: Maven
- Wrapper: none detected. We'll add `pom.xml` and rely on system Maven or install Maven to `C:\Users\Mohan Vamsi\.maven` if needed.
- MAVEN_HOME will be set if we install Maven; otherwise the migration tools can use an installed Maven.

## Files to be changed / added (initial)
- Add: `pom.xml` at repository root
- Add: `c:\Users\Mohan Vamsi\.jdk` (JDK 21) via tool if not present
- Update: progress and plan files in `.github/appmod/code-migration/20251229100904/`

## Order of operations
1. Create branch `appmod/java-migration-20251229100904` (version control step).
2. Install JDK 21 to `C:\Users\Mohan Vamsi\.jdk` (if required) using migration tool.
3. Add `pom.xml` to project root (packaging `war`, compiler set to Java 21).
4. Run `build_java_project` with session ID to attempt build and capture errors.
5. Fix compilation issues and update source code as needed (e.g., imports or API changes).
6. Run CVE checks for dependencies and apply fixes.
7. Run tests and validation loops (consistency/completeness).
8. Commit final changes and generate `summary.md`.

## Risks & Notes
- The source code currently uses `javax.servlet.*` imports. Servlet API is provided by the container; in `pom.xml` we add `javax.servlet-api` with scope `provided` so compilation succeeds without bundling it in the WAR.
- If you plan to migrate to Jakarta namespace (`jakarta.servlet.*`), additional source changes will be required. For minimal migration to Java 21, retaining `javax.servlet` compile-time dependency is simplest.

## Next immediate actions
- Create branch with name `appmod/java-migration-20251229100904` (tool will stash uncommitted changes per policy "Always Stash").
- Install JDK 21 to `C:\Users\Mohan Vamsi\.jdk` if not present.
- Add `pom.xml` (done now) and attempt a build.

## Migration session
- Session ID to use for subsequent tool calls: `8029dc55-cd26-49ac-b0d9-022bd39e4829`
