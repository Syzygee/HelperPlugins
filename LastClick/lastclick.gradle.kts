import ProjectVersions.openosrsVersion

/*
 * Copyright (c) 2020 Syzygee <https://github.com/Syzygee>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

version = "0.0.1"

project.extra["PluginName"] = "Last Click" // This is the name that is used in the external plugin manager panel
project.extra["PluginDescription"] = "The ultimate click" // This is the description that is used in the external plugin manager panel

dependencies {
    annotationProcessor(Libraries.lombok)
    annotationProcessor(Libraries.pf4j)
    annotationProcessor(Libraries.apacheCommonsText)

    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.12")
    annotationProcessor(group = "org.pf4j", name = "pf4j", version = "3.2.0")
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.2.3")
    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.6")
    implementation(group = "com.google.guava", name = "guava", version = "28.2-jre")
    implementation(group = "com.google.inject", name = "guice", version = "4.2.3", classifier = "no_aop")
    implementation(group = "com.openosrs", name = "http-api", version = "3.3.8")
    implementation(group = "com.openosrs", name = "injected-client", version = "3.3.8")
    implementation(group = "com.openosrs", name = "runelite-api", version = "3.3.8")
    implementation(group = "com.openosrs", name = "runelite-client", version = "3.3.8")
    implementation(group = "com.openosrs.rs", name = "runescape-api", version = "3.3.8")
    implementation(group = "com.openosrs.rs", name = "runescape-client", version = "3.3.8")
    implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "4.5.0")
    implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "4.5.0")
    implementation(group = "io.reactivex.rxjava3", name = "rxjava", version = "3.0.2")
    implementation(group = "net.sf.jopt-simple", name = "jopt-simple", version = "5.0.4")
    implementation(group = "org.apache.commons", name = "commons-text", version = "1.8")
    implementation(group = "org.pf4j", name = "pf4j", version = "3.2.0")
    implementation(group = "org.projectlombok", name = "lombok", version = "1.18.12")

    compileOnly("com.openosrs:runelite-api:$openosrsVersion+")
    compileOnly("com.openosrs:runelite-client:$openosrsVersion+")

    compileOnly(Libraries.guice)
    compileOnly(Libraries.javax)
    compileOnly(Libraries.lombok)
    compileOnly(Libraries.pf4j)
    compileOnly(Libraries.apacheCommonsText)
}

tasks {
    jar {
        manifest {
            attributes(mapOf(
                    "Plugin-Version" to project.version,
                    "Plugin-Id" to nameToId(project.extra["PluginName"] as String),
                    "Plugin-Provider" to project.extra["PluginProvider"],
                    "Plugin-Description" to project.extra["PluginDescription"],
                    "Plugin-License" to project.extra["PluginLicense"]
            ))
        }
    }
}