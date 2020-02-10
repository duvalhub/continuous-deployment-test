package com.duvalhub.jenkins

class LaunchBuild {
    String name
    String job
    String version

    LaunchBuild(String name, String job, String version) {
        this.name = name
        this.job = job
        this.version = version
    }

    LaunchBuild(String job_name) {
        String[] names = job_name.split('/')
        this.name = names[0]
        this.job = names[1]
        this.version = names[2]
    }

    String getBuild() {
        return String.format("%s/%s/%s", this.name, this.job, this.version)
    }
}