package com.duvalhub.jenkins
import com.duval.BaseObject

class LaunchBuild extends BaseObject {
    String name
    String job
    String version
    String[] params

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