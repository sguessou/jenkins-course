job('NodeJS example') {
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
        shell("npm install")
    }
}
