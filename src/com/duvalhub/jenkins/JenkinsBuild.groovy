package com.duvalhub.jenkins
import com.duvalhub.BaseObject

class JenkinsBuild extends BaseObject {
    String name
    String job
    String version
    String[] params

    JenkinsBuild(String name, String job, String version) {
        this.name = name
        this.job = job
        this.version = version
    }


    String getBuild() {
        return String.format("%s/%s/%s", this.name, this.job, this.version)
    }
}