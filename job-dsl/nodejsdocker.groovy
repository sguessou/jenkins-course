job('NodeJS Docker example') {
    scm {
        git('git://github.com/sguessou/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('sguessou')
            node / gitConfigEmail('guessous_saad@hotmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('sguessou/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
